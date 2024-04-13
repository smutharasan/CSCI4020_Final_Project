grammar PL;

@header {
  //package backend;
  import backend.*;
  import java.util.*;
}

@members {
    void error(String message) {
        System.err.println("Error: " + message);
        throw new RuntimeException(message);
    }
}

// Entry point of the parser
program returns [Expr expr]
    : statements+=statement* EOF { 
        List<Expr> exprList = new ArrayList<>();
        for (StatementContext stmt : $statements) {
            exprList.add(stmt.expr);
        }
        $expr = new Block(exprList);
    }
    ;
    
statement returns [Expr expr]
    : assignment (';'|)  { $expr = $assignment.expr; }
    | expression ';'  { $expr = $expression.expr; } // Keep using 'expression'
    | 'print' '(' expression ')' (';'|) { $expr = new PrintExpr($expression.expr); }
    | loop { $expr = $loop.expr; }
    | function { $expr = $function.funcResult;}
    | ifelse { $expr = $ifelse.expr; }
    | whileloop { $expr = $whileloop.expr; }
    | foreach { $expr = $foreach.expr; }  
    ;

    
assignment returns [Expr expr]
    : type ID  '=' expression { $expr = new AssignmentExpr($ID.text, $type.text, $expression.expr); }
    | ID '=' expression { $expr = new AssignmentExpr($ID.text, null, $expression.expr); }
    ;


expression returns [Expr expr] // Stay with 'expression'
    : '(' expression ')'   { $expr = $expression.expr; }
    | functionCall { $expr = $functionCall.expr; }
    | NOT_OP expression    { $expr = new LogicalNotExpr($expression.expr); } // Handling logical NOT
    | left=expression op=('*'|'/') right=expression { 
        $expr = new Arithmetics($op.text.equals("*") ? Operator.Mul : Operator.Div, $left.expr, $right.expr); 
    }
    | left=expression op=('+'|'-') right=expression { 
        $expr = new Arithmetics($op.text.equals("+") ? Operator.Add : Operator.Sub, $left.expr, $right.expr); 
    }
    | left=expression '[' givenIndex=expression ']' { $expr = new AccessExpr($left.expr, $givenIndex.expr); }
    | left=expression DOT_OP ID LPARANTHESIS arguments RPARANTHESIS {
        $expr = new MethodCallExpr($left.expr, $ID.text, $arguments.args);
    }
    | left=expression AND_OP right=expression {
        $expr = new LogicalAndExpr($left.expr, $right.expr);
    }
    | left=expression OR_OP right=expression {
        $expr = new LogicalOrExpr($left.expr, $right.expr);
    }
    | left=expression '++' right=expression { $expr = new ConcatExpr($left.expr, $right.expr); }
    | left=expression op=('<'|'>'|'<='|'>='|'!='|'==') right=expression { 
        backend.Comparator comparator = null; // Initialize with null
        switch ($op.text) {
            case "<": comparator  = backend.Comparator.LT; break;
            case ">": comparator  = backend.Comparator.GT; break;
            case "<=": comparator = backend.Comparator.LE; break;
            case ">=": comparator = backend.Comparator.GE; break;
            case "!=": comparator = backend.Comparator.NE; break;
            case "==": comparator = backend.Comparator.EQ; break;
            default: throw new IllegalArgumentException("Unsupported operator: " + $op.text);
        }
        $expr = new Compare(comparator, $left.expr, $right.expr); 
    }
    | value            { $expr = $value.expr; }
    | ID               { $expr = new VariableExpr($ID.text); }
    ;

parenExpr returns [Expr expr]:
    LPARANTHESIS expression RPARANTHESIS { $expr = $expression.expr; }
    ;

functionCall returns [Expr expr]:
    ID LPARANTHESIS arguments RPARANTHESIS {$expr = new Invoke($ID.text, $arguments.args);}
    ;

expressionOrBlock returns [Expr expr]
    : '{' statements+=statement* '}' {
        List<Expr> exprList = new ArrayList<>();
        for (StatementContext stmt : $statements) {
            exprList.add(stmt.expr);
        }
        $expr = new Block(exprList);
    }
    | singleExpression=expression {
        $expr = $singleExpression.expr;
    }
    ;

value returns [Expr expr]
    : NUMBER { $expr = new IntExpr($NUMBER.text); } // Directly pass the string
    | STRING { $expr = new StringExpr($STRING.text.substring(1, $STRING.text.length() - 1)); }
    | BOOLEAN { $expr = new BooleanLiteral($BOOLEAN.text); }
    | DOUBLE { $expr = new DoubleExpr($DOUBLE.text); }
    | dictLiteral { $expr = $dictLiteral.expr; } // Add dictionary literals
    | arrayLiteral { $expr = $arrayLiteral.expr; }
    ;
    
arrayLiteral returns [Expr expr]
    : '{' (elements+=expression (COMMA elements+=expression)*)? '}' {
        List<Expr> exprList = new ArrayList<>();
        for (ExpressionContext element : $elements) {
            exprList.add(element.expr); // Convert each ExpressionContext to Expr
        }
        $expr = new ArrayExpr(exprList);
    }
    ;
    

dictLiteral returns [Expr expr]
    : '{' (pairs+=keyValuePair (COMMA pairs+=keyValuePair)*)? '}' {
        Map<Expr, Expr> map = new LinkedHashMap<>();
        for (KeyValuePairContext pair : $pairs) {
            map.put(pair.key.expr, pair.val.expr);
        }
        $expr = new DictExpr(map);
    }
    ;

keyValuePair returns [KeyValuePair pair]
    : key=expression COLON val=expression { $pair = new KeyValuePair($key.expr, $val.expr); }
    ;

    
loop returns [Expr expr]
    : 'for' '(' ID 'in' startexpr=expression RANGE_OP endexpr=expression ')' '{' statements+=statement* '}' {
        List<Expr> exprList = new ArrayList<>();
        for (StatementContext stmt : $statements) {
            exprList.add(stmt.expr);
        } // This closing brace ends the for-loop
        $expr = new ForLoopExpr($ID.text, $startexpr.expr, $endexpr.expr, new Block(exprList));
      }
    ;

foreach returns [Expr expr]
    : 'foreach' '(' ID 'in' collection=expression ')' '{' statements+=statement* '}' {
        List<Expr> stmtList = new ArrayList<>();
        for (StatementContext stmt : $statements) {
            stmtList.add(stmt.expr);
        }
        $expr = new ForeachExpr($ID.text, $collection.expr, new Block(stmtList));
      }
    ;


// Defining the whileloop rule
whileloop returns [Expr expr]
    : 'while' '(' condition=expression ')' '{' statements+=statement* '}' {
        List<Expr> exprList = new ArrayList<>();
        for (StatementContext stmt : $statements) {
            exprList.add(stmt.expr);
        }
        $expr = new While($condition.expr, new Block(exprList));
    }
    ;

arguments returns [List<Expr> args]
    : (expressionList+=expression (',' expressionList+=expression)*)? {
        $args = new ArrayList<>();
        if ($expressionList != null) { // Check if any expressions were matched
            for (ExpressionContext exprCtx : $expressionList) {
                if (exprCtx != null && exprCtx.expr != null) {
                    // Safely add the expression's corresponding Expr object
                    $args.add(exprCtx.expr);
                }
            }
        }
    }
    ;



function returns [Expr funcResult]
    : 'function' ID '(' params=parameters ')' '{' statements+=statement* '}' {
            List<Expr> exprList = new ArrayList<>();
            for (StatementContext stmt : $statements) {
                exprList.add(stmt.expr);
            } // This closing brace ends the for-loop
            $funcResult = new Declare($ID.text, $params.ids, new Block(exprList));
        }
    ;
    
parameters returns [List<String> ids]: (first=ID (',' rest+=ID)*)? {
    $ids = new ArrayList<>();
    if ($first != null) {
        $ids.add($first.text);
        if ($rest != null) {
            for (Token id : $rest) {
                $ids.add(id.getText());
            }
        }
    }
};

methodCall returns [Expr expr]
    : expression '.' methodName=ID '(' arguments ')' {
        $expr = new MethodCallExpr($expression.expr, $methodName.text, $arguments.args);
      }
    ;
    
ifelse returns [Expr expr]
    : 'if' '(' condition=expression ')' '{' trueStatements+=statement* '}' ('else' '{' falseStatements+=statement* '}')? {
        List<Expr> trueExprList = new ArrayList<>();
        for (StatementContext stmt : $trueStatements) {
            trueExprList.add(stmt.expr);
        }
        
        List<Expr> falseExprList = new ArrayList<>();
        if ($falseStatements != null) { // Check if there are statements in the else block
            for (StatementContext stmt : $falseStatements) {
                falseExprList.add(stmt.expr);
            }
        }
        
        $expr = new Ifelse($condition.expr, new Block(trueExprList), new Block(falseExprList));
      }
    ;




RANGE_OP: '..';
DOT_OP: '.';
AND_OP: '&&';
OR_OP: '||';
NOT_OP: '!';
COLON: ':';

LBRACK: '[' ; // Left bracket
RBRACK: ']' ; // Right bracket

LPARANTHESIS: '(';
RPARANTHESIS: ')';

COMMA: ',' ;  // Comma

NUMBER: [0-9]+ ;                        // Match integers
STRING: '"' ( ~["\\] | '\\' . )* '"' ;  // Match string literals
BOOLEAN: 'true' | 'false';              // Match boolean literals
ID: [a-zA-Z_][a-zA-Z_0-9]* ;            // Match identifiers
WS: [ \t\r\n]+ -> skip ;                // Skip whitespace
COMMENT: '/*' .*? '*/' -> skip ;        // Skip block comments
LINE_COMMENT: '//' ~[\r\n]* -> skip ;   // Skip line comments
DOUBLE: [0-9]+ '.' [0-9]+ | '0' '.' [0-9]+;
type: 'Int' | 'String' | 'Boolean' | 'Double' ;