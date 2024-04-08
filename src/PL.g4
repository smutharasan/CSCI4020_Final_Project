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
    | expression ' ;'  { $expr = $expression.expr; } // Keep using 'expression'
    | 'print' '(' expression ')' (';'|) { $expr = new PrintExpr($expression.expr); }
    | loop { $expr = $loop.expr; }
    | function { $expr = $function.funcResult;}
    | ifelse { $expr = $ifelse.expr; }
    | whileloop { $expr = $whileloop.expr; }
    ;

    
assignment returns [Expr expr]
    : ID '=' expression { $expr = new AssignmentExpr($ID.text, $expression.expr); }
    ;

expression returns [Expr expr] // Stay with 'expression'
    : '(' expression ')' { $expr = $expression.expr; }
    | value            { $expr = $value.expr; }
    | ID               { $expr = new VariableExpr($ID.text); }
    // Update arithmetic expressions to use Arithmetics class
    // Corrected expressions for arithmetic operations
    | left=expression op=('*'|'/') right=expression { 
        $expr = new Arithmetics($op.text.equals("*") ? Operator.Mul : Operator.Div, $left.expr, $right.expr); 
    }
    | left=expression op=('+'|'-') right=expression { 
        $expr = new Arithmetics($op.text.equals("+") ? Operator.Add : Operator.Sub, $left.expr, $right.expr); 
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
    | ID '(' arguments ')' {$expr = new Invoke($ID.text, $arguments.args);}
    ;

value returns [Expr expr]
    : NUMBER { $expr = new IntExpr($NUMBER.text); } // Directly pass the string
    | STRING { $expr = new StringExpr($STRING.text.substring(1, $STRING.text.length() - 1)); }
    | BOOLEAN { $expr = new BooleanLiteral($BOOLEAN.text); }
    ;
    
loop returns [Expr expr]
    : 'for' '(' ID 'in' startexpr=expression '..' endexpr=expression ')' '{' statements+=statement* '}' {
        List<Expr> exprList = new ArrayList<>();
        for (StatementContext stmt : $statements) {
            exprList.add(stmt.expr);
        } // This closing brace ends the for-loop
        $expr = new ForLoopExpr($ID.text, $startexpr.expr, $endexpr.expr, new Block(exprList));
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
    : (first=expression (',' others+=expression)*)? {
        $args = new ArrayList<>();
        if ($first.expr != null) { // Check if at least one expression is matched
            $args.add($first.expr); // Add the first matched expression to the list
        }
        if ($others != null) { // Check if there are additional expressions matched
            for (ExpressionContext exprCtx : $others) { // Iterate over the additional expressions
                $args.add(exprCtx.expr); // Add each to the list
            }
        }
    }
    ;


function returns [Expr funcResult]
    : 'function' ID '(' params=paramList ')' '{' statements+=statement* '}' {
            List<Expr> exprList = new ArrayList<>();
            for (StatementContext stmt : $statements) {
                exprList.add(stmt.expr);
            } // This closing brace ends the for-loop
            $funcResult = new Declare($ID.text, $params.paramNames, new Block(exprList));
        }
    ;
    
paramList returns [List<String> paramNames]
    : { $paramNames = new ArrayList<>(); } // Initialize the list
      (id=ID { $paramNames.add($id.text); } // Add the first matched ID
      (',' id=ID { $paramNames.add($id.text); })* // Add subsequent matched IDs
      )?
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



NUMBER: [0-9]+ ;                        // Match integers
STRING: '"' ( ~["\\] | '\\' . )* '"' ;  // Match string literals
BOOLEAN: 'true' | 'false';              // Match boolean literals
ID: [a-zA-Z_][a-zA-Z_0-9]* ;            // Match identifiers
WS: [ \t\r\n]+ -> skip ;                // Skip whitespace
COMMENT: '/*' .*? '*/' -> skip ;        // Skip block comments
LINE_COMMENT: '//' ~[\r\n]* -> skip ;   // Skip line comments
