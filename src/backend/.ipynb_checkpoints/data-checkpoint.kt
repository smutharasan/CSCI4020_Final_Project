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

// Implement the double data class
data class DoubleData(val value: Double) : Data() {
    override fun toString(): String = value.toString()
}

// Implement the boolean data class
data class BooleanData(val value: Boolean) : Data() {
 override fun toString() = 
    "${value}"
}

// Implement the function data class
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

// ArrayData class to hold an array of Data objects
class ArrayData(val elements: List<Data>) : Data() {
    // Get an element at a specific index
    fun get(index: Int): Data {
        if (index < 0 || index >= elements.size) {
            throw IndexOutOfBoundsException("Index: $index, Size: ${elements.size}")
        }
        return elements[index]
    }

    // Perhaps a method to return the size of the array
    fun size(): Int {
        return elements.size
    }
    
    fun map(transform: (Data) -> Data): ArrayData {
        val result = elements.map(transform)
        return ArrayData(result)
    }

    fun filter(predicate: (Data) -> Boolean): ArrayData {
        val result = elements.filter(predicate)
        return ArrayData(result)
    }
    
    // Override toString for better representation
    override fun toString(): String {
        return elements.joinToString(prefix = "[", postfix = "]", transform = Data::toString)
    }
}