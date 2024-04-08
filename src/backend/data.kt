package backend

abstract class Data

object None:Data() {
    override fun toString() = "None"
}

// Implement the integer data class
data class IntData(val value: Int) : Data() {
    override fun toString(): String = "$value"
}

// Implement the string data class
data class StringData(val value: String) : Data() {
    override fun toString(): String = "\"$value\""
}

// Implement the boolean data class
data class BooleanData(val value: Boolean) : Data() {
 override fun toString() = 
    "${value}"
}

// Implement the function data class
data class FunctionData(val parameters: List<String>, val body: Expr) : Data() {
    override fun toString(): String = "Function(${parameters.joinToString(", ")})"
}
