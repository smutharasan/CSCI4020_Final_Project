package backend

abstract class Expr {
    abstract fun eval(runtime:Runtime):Data
}

// An expression representing a parenthesized expression
class ParenExpr(val expr: Expr) : Expr() {
    override fun eval(runtime: Runtime): Data {
        // Simply evaluates the contained expression
        return expr.eval(runtime)
    }
}

class Block(val exprs:List<Expr>):Expr() {
    override fun eval(runtime:Runtime):Data
    = exprs.map { it.eval(runtime) }.last()
}

class NoneExpr(): Expr() {
    override fun eval(runtime:Runtime) = None
}

// An expression representing a literal integer value
class IntExpr(val value: String) : Expr() {
  override fun eval(runtime:Runtime): Data
    = IntData(Integer.parseInt(value))
}

// An expression representing a literal string value
class StringExpr(val value: String) : Expr() {
    override fun eval(runtime: Runtime): Data = StringData(value)
}

class BooleanLiteral(val lexeme:String): Expr() {
    override fun eval(runtime:Runtime): Data
    = BooleanData(lexeme.equals("true"))
}

// An expression representing an assignment
class AssignmentExpr(val symbol:String, val expr:Expr): Expr() {
    override fun eval(runtime:Runtime): Data
    = expr.eval(runtime).apply {
        runtime.symbolTable.put(symbol, this)
    }
}

// An expression representing a variable reference
class VariableExpr(val name: String) : Expr() {
    override fun eval(runtime:Runtime):Data {
        val data = runtime.symbolTable[name]
        if(data == null) {
            throw Exception("~~ $name is not assigned.")
        }
        return data
    }
}

// An expression representing the concatenation of two expressions
class ConcatExpr(val left: Expr, val right: Expr) : Expr() {
    override fun eval(runtime: Runtime): Data {
        val leftVal = left.eval(runtime)
        val rightVal = right.eval(runtime)
        
        // Assuming concatenation is only valid for strings for simplicity
        // You might need additional logic for type checking and conversion
        if (leftVal is StringData && rightVal is StringData) {
            return StringData(leftVal.value + rightVal.value)
        } else {
            throw IllegalArgumentException("Concatenation only supported for strings.")
        }
    }
}

// An expression representing a print operation
class PrintExpr(val expression: Expr) : Expr() {
    override fun eval(runtime: Runtime): Data {
        val value = expression.eval(runtime)
        
        // Assuming the runtime has some method to handle output, like println
        println(value.toString())
        
        // Depending on your language design, print might not return any value
        // Or you might decide to return the printed value or some status indicator
        return None // Assuming 'None' is an object representing a lack of value
    }
}

enum class Operator {
    Add,
    Sub,
    Mul,
    Div
}

class Arithmetics(
    val op: Operator,
    val left: Expr,
    val right: Expr
): Expr() {
    override fun eval(runtime: Runtime): Data {
        val x = left.eval(runtime)
        val y = right.eval(runtime)
        
        return when (op) {
            Operator.Mul -> handleMultiplication(x, y)
            Operator.Add, Operator.Sub, Operator.Div -> handleArithmetic(x, y, op)
            else -> throw Exception("Unsupported operator")
        }
    }

    private fun handleMultiplication(x: Data, y: Data): Data {
        // Check if one operand is StringData and the other is IntData, for commutative operation
        return when {
            x is StringData && y is IntData -> StringData(x.value.repeat(y.value))
            x is IntData && y is StringData -> StringData(y.value.repeat(x.value))
            x is IntData && y is IntData -> IntData(x.value * y.value)
            else -> throw Exception("Invalid types for multiplication")
        }
    }

    private fun handleArithmetic(x: Data, y: Data, op: Operator): Data {
        if (x !is IntData || y !is IntData) {
            throw Exception("Arithmetic operations other than multiplication can only handle integers")
        }

        return when (op) {
            Operator.Add -> IntData(x.value + y.value)
            Operator.Sub -> IntData(x.value - y.value)
            Operator.Div -> {
                if (y.value != 0) {
                    IntData(x.value / y.value)
                } else {
                    throw Exception("cannot divide by zero")
                }
            }
            else -> throw Exception("Unknown arithmetic operator")
        }
    }
}


class ForLoopExpr(
    val loopVarName: String, 
    val startExpr: Expr, 
    val endExpr: Expr, 
    val body: Expr
): Expr() {
    override fun eval(runtime: Runtime): Data {
        val startValue = startExpr.eval(runtime)
        val endValue = endExpr.eval(runtime)

        if (startValue !is IntData || endValue !is IntData) {
            throw IllegalArgumentException("For loop start and end values must be integers")
        }

        var result: Data = None
        for (i in startValue.value..endValue.value) {
            // Update the loop variable in the symbol table
            runtime.symbolTable[loopVarName] = IntData(i)
            // Evaluate the body of the loop
            result = body.eval(runtime)
        }

        // Optionally clear the loop variable from the symbol table after the loop
        runtime.symbolTable.remove(loopVarName)

        // The result of the last iteration is returned, similar to how a block expression works
        return result
    }
}

class FuncData(
    val name: String,
    val params: List<String>,
    val body: Expr
): Data() {
    override fun toString()
    = params.joinToString(", ").let {
        "$name($it) { ... }"
    }
}

class Declare(
    val name: String,
    val params: List<String>,
    val body: Expr
): Expr() {
    override fun eval(runtime:Runtime):Data
    = FuncData(name, params, body).also {
        runtime.symbolTable[name] = it
    }
}

class Invoke(val name:String, val args:List<Expr>):Expr() {
    override fun eval(runtime:Runtime):Data {
        val func:Data? = runtime.symbolTable[name]
        if(func == null) {
            throw Exception("$name does not exist")
        }
        if(func !is FuncData) {
            throw Exception("$name is not a function.")
        }
        if(func.params.size != args.size) {
            throw Exception(
                "$name expects ${func.params.size} arguments "
                + "but received ${args.size}"
            )
        }
        
        val r = runtime.subscope(
            func.params.zip(args.map {it.eval(runtime)}).toMap()
        )
        return func.body.eval(r)
    }
}

enum class Comparator {
    LT,
    LE,
    GT,
    GE,
    EQ,
    NE,
}

class Compare(
    val comparator: Comparator,
    val left: Expr,
    val right: Expr
): Expr() {
    override fun eval(runtime:Runtime): Data {
        val x = left.eval(runtime)
        val y = right.eval(runtime)
        if(x is IntData && y is IntData) {
            return BooleanData(
                when(comparator) {
                    Comparator.LT -> x.value < y.value
                    Comparator.LE -> x.value <= y.value
                    Comparator.GT -> x.value > y.value
                    Comparator.GE -> x.value >= y.value
                    Comparator.EQ -> x.value == y.value
                    Comparator.NE -> x.value != y.value
                }
            )
        } else {
            throw Exception("Non-integer data in comparison")
        }
    }
}

class Ifelse(
    val cond:Expr,
    val trueExpr:Expr,
    val falseExpr:Expr
): Expr() {
    override fun eval(runtime:Runtime): Data {
        val cond_data = cond.eval(runtime)
        if(cond_data !is BooleanData) {
            throw Exception("need boolean data in if-else")
        }
        return if(cond_data.value) {
            return trueExpr.eval(runtime)
        } else {
            return falseExpr.eval(runtime)
        }
    }
}

class While(val cond: Expr, val body: Expr) : Expr() {
    override fun eval(runtime: Runtime): Data {
        var flag = cond.eval(runtime) as BooleanData
        var result: Data = None // Use None instead of NullData
        var iter: Int = 1_000_000
        while (flag.value) {
            result = body.eval(runtime)
            flag = cond.eval(runtime) as BooleanData
            if (iter == 0) {
                println("MAX_ITER reached")
                println(runtime)
                return None // Use None instead of NullData
            }
            iter--
        }
        return result
    }
}
