package backend


abstract class Expr {
    abstract fun eval(runtime:Runtime):Data
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

// An expression representing a literal double value
class DoubleExpr(val value: String) : Expr() {
    override fun eval(runtime:Runtime): Data
        = DoubleData(value.toDouble())
}

// An expression representing a literal string value
class StringExpr(val value: String) : Expr() {
    override fun eval(runtime: Runtime): Data = StringData(value)
}

class BooleanLiteral(val lexeme:String): Expr() {
    override fun eval(runtime:Runtime): Data
    = BooleanData(lexeme.equals("true"))
}

class LogicalNotExpr(val operand: Expr) : Expr() {
    override fun eval(runtime: Runtime): Data {
        val operandVal = operand.eval(runtime)
        
        // Assuming BooleanData represents boolean values in your language
        // and it has a 'value' property that is the actual boolean value.
        if (operandVal is BooleanData) {
            return BooleanData(!operandVal.value)
        } else {
            throw IllegalArgumentException("Logical NOT operator requires a boolean operand.")
        }
    }
}

class LogicalAndExpr(val left: Expr, val right: Expr) : Expr() {
    override fun eval(runtime: Runtime): Data {
        val leftVal = left.eval(runtime)

        if (leftVal !is BooleanData) {
            throw IllegalArgumentException("Left operand of AND is not boolean.")
        }
        // Use short-circuit logic for logical AND
        if (!leftVal.value) {
            return BooleanData(false)  // If leftVal is false, return false without evaluating right operand
        }

        val rightVal = right.eval(runtime)
        if (rightVal !is BooleanData) {
            throw IllegalArgumentException("Right operand of AND is not boolean.")
        }

        return BooleanData(leftVal.value && rightVal.value)
    }
}


class LogicalOrExpr(val left: Expr, val right: Expr) : Expr() {
    override fun eval(runtime: Runtime): Data {
        val leftVal = left.eval(runtime)

        if (leftVal !is BooleanData) {
            throw IllegalArgumentException("Left operand of OR is not boolean.")
        }
        // Use short-circuit logic for logical OR
        if (leftVal.value) {
            return BooleanData(true)  // If leftVal is true, return true without evaluating right operand
        }

        val rightVal = right.eval(runtime)
        if (rightVal !is BooleanData) {
            throw IllegalArgumentException("Right operand of OR is not boolean.")
        }

        return BooleanData(rightVal.value)  // Corrected to evaluate right operand correctly
    }
}


class ArrayExpr(val elements: List<Expr>) : Expr() {
    override fun eval(runtime: Runtime): Data {
        // Evaluate each element of the expression list to obtain a list of Data objects
        val evaluatedElements = elements.map { it.eval(runtime) }
        // Return an ArrayData object encapsulating the evaluated elements
        return ArrayData(evaluatedElements)
    }
}

class AccessExpr(val target: Expr, val index: Expr) : Expr() {
    override fun eval(runtime: Runtime): Data {
        val targetData = target.eval(runtime)
        val indexData = index.eval(runtime)

        // Handling arrays and dictionaries
        return when (targetData) {
            is ArrayData -> {
                if (indexData !is IntData) {
                    throw RuntimeException("Array index must be an integer")
                }
                targetData.get(indexData.value)
            }
            is DictData -> {
                targetData.get(indexData) ?: throw RuntimeException("Key not found: $indexData")
            }
            else -> throw RuntimeException("Access operation not supported on this type")
        }
    }
}

class DictExpr(val map: Map<Expr, Expr>) : Expr() {
    override fun eval(runtime: Runtime): Data {
        val resultMap = mutableMapOf<Data, Data>()
        map.entries.forEach { entry ->
            val keyData = entry.key.eval(runtime)
            val valueData = entry.value.eval(runtime)
            resultMap[keyData] = valueData
        }
        return DictData(resultMap)
    }
}

class KeyValuePair(val key: Expr, val value: Expr)

// An expression representing an assignment
class AssignmentExpr(val name: String, val type: String?, val expr: Expr) : Expr() {
    override fun eval(runtime: Runtime): Data {
        val value = expr.eval(runtime)
        runtime.setVariable(name, type, value)
        return value
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

        // Handle operations for both IntData and DoubleData
        return when (op) {
            Operator.Mul -> handleMultiplication(x, y)
            Operator.Add, Operator.Sub, Operator.Div -> handleArithmetic(x, y, op)
            else -> throw Exception("Unsupported operator")
        }
    }

    private fun handleMultiplication(x: Data, y: Data): Data {
        // Supporting multiplication for DoubleData as well
        return when {
            x is StringData && y is IntData -> StringData(x.value.repeat(y.value))
            x is IntData && y is StringData -> StringData(y.value.repeat(x.value))
            x is IntData && y is IntData -> IntData(x.value * y.value)
            x is DoubleData && y is DoubleData -> DoubleData(x.value * y.value)
            x is IntData && y is DoubleData -> DoubleData(x.value * y.value)
            x is DoubleData && y is IntData -> DoubleData(x.value * y.value)
            else -> throw Exception("Invalid types for multiplication")
        }
    }

    private fun handleArithmetic(x: Data, y: Data, op: Operator): Data {
        // Extending arithmetic operations to handle DoubleData
        return when {
            x is IntData && y is IntData -> {
                performIntArithmetic(x.value, y.value, op)
            }
            x is DoubleData && y is DoubleData -> {
                performDoubleArithmetic(x.value, y.value, op)
            }
            x is IntData && y is DoubleData -> {
                performDoubleArithmetic(x.value.toDouble(), y.value, op)
            }
            x is DoubleData && y is IntData -> {
                performDoubleArithmetic(x.value, y.value.toDouble(), op)
            }
            else -> throw Exception("Unsupported types for arithmetic operation")
        }
    }

    private fun performIntArithmetic(x: Int, y: Int, op: Operator): IntData = when (op) {
        Operator.Add -> IntData(x + y)
        Operator.Sub -> IntData(x - y)
        Operator.Div -> if (y != 0) IntData(x / y) else throw Exception("Cannot divide by zero")
        else -> throw Exception("Unknown arithmetic operator")
    }

    private fun performDoubleArithmetic(x: Double, y: Double, op: Operator): DoubleData = when (op) {
        Operator.Add -> DoubleData(x + y)
        Operator.Sub -> DoubleData(x - y)
        Operator.Div -> if (y != 0.0) DoubleData(x / y) else throw Exception("Cannot divide by zero")
        else -> throw Exception("Unknown arithmetic operator")
    }
}



class ForLoopExpr(
    val loopVarName: String, 
    val startExpr: Expr, 
    val endExpr: Expr, 
    val body: Expr
): Expr() {
    override fun eval(runtime: Runtime): Data {
        println(runtime) 
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

class Declare(
    val name: String,
    val params: List<String>,
    val body: Expr
): Expr() {
    override fun eval(runtime:Runtime):Data
    = FuncData(name, params, body).also {
        if(name == null){
            throw Exception("$name does not exist")
        }
        runtime.symbolTable[name] = it
    }
}

class Invoke(val name: String, val args: List<Expr>?): Expr() {
    override fun eval(runtime: Runtime): Data {
        val func = runtime.symbolTable[name]
        if (func == null || func !is FuncData) {
            throw Exception("Function '$name' is not defined.")
        }
        val evaluatedArgs = args?.map { it.eval(runtime) } ?: emptyList()
        // Ensure the number of provided arguments matches the function's parameters
        if (func.params.size != evaluatedArgs.size) {
            throw Exception("Function '$name' expects ${func.params.size} arguments but received ${evaluatedArgs.size}.")
        }

        val functionScope = runtime.subscope(func.params.zip(evaluatedArgs).toMap())
        return func.body.eval(functionScope)
    }
}

class MethodCallExpr(
    val target: Expr, // The target object of the method call
    val methodName: String, // The name of the method being called
    val arguments: List<Expr> // The arguments passed to the method
) : Expr() {
    override fun eval(runtime: Runtime): Data {
        val targetData = target.eval(runtime)

        return when (targetData) {
            is ArrayData -> handleArrayMethods(targetData, methodName, arguments, runtime)
            is DictData -> handleDictMethods(targetData, methodName, arguments, runtime)
            else -> throw IllegalArgumentException("The target for method '$methodName' must be an array or a dictionary. Found: ${targetData::class.simpleName}")
        }
    }

    // Depending on the need, change visibility to `internal` or keep `public`
    fun handleArrayMethods(arrayData: ArrayData, methodName: String, arguments: List<Expr>, runtime: Runtime): Data {
        return when (methodName) {
            "size" -> {
                if (arguments.isNotEmpty()) throw IllegalArgumentException("size method does not take arguments")
                IntData(arrayData.elements.size)
            }
            else -> throw UnsupportedOperationException("Method '$methodName' is not supported on arrays")
        }
    }

    // Depending on the need, change visibility to `internal` or keep `public`
    fun handleDictMethods(dictData: DictData, methodName: String, arguments: List<Expr>, runtime: Runtime): Data {
        return when (methodName) {
            "put" -> {
                requireArgumentsSize(arguments, 2, methodName)
                val key = arguments[0].eval(runtime)
                val value = arguments[1].eval(runtime)
                dictData.put(key, value)
                None
            }
            "remove" -> {
                requireArgumentsSize(arguments, 1, methodName)
                val key = arguments[0].eval(runtime)
                dictData.remove(key) ?: None
            }
            "keys" -> {
                requireArgumentsSize(arguments, 0, methodName)
                dictData.keys()
            }
            "values" -> {
                requireArgumentsSize(arguments, 0, methodName)
                dictData.values()
            }
            else -> throw UnsupportedOperationException("Method '$methodName' is not supported on dictionaries")
        }
    }

    fun requireArgumentsSize(arguments: List<Expr>, requiredSize: Int, methodName: String) {
        if (arguments.size != requiredSize) {
            throw IllegalArgumentException("The method '$methodName' requires exactly $requiredSize arguments.")
        }
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

class ForeachExpr(
    val loopVarName: String, 
    val collectionExpr: Expr, 
    val body: Expr
) : Expr() {
    override fun eval(runtime: Runtime): Data {
        val collectionData = collectionExpr.eval(runtime)
        
        if (collectionData !is ArrayData) {
            throw IllegalArgumentException("Foreach loop requires an array to iterate over, got ${collectionData::class.simpleName}")
        }

        var lastResult: Data = None  // Use the None singleton for initial value.

        // Iterate over each element in the array.
        for (element in collectionData.elements) {
            // Set the loop variable in the current scope.
            runtime.symbolTable[loopVarName] = element
            // Execute the body of the loop.
            lastResult = body.eval(runtime)
        }

        runtime.symbolTable.remove(loopVarName)
        // Return the last evaluated result or some other value depending on your language design.
        return lastResult
    }
}
