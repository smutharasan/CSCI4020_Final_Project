package backend

class Runtime() {
    val symbolTable: MutableMap<String, Data> = mutableMapOf()
    val typeTable: MutableMap<String, String> = mutableMapOf()

    fun setVariable(name: String, type: String?, value: Data) {
        val existingType = typeTable[name]
        if (type != null) {
            if (existingType != null && existingType != type) {
                throw RuntimeException("Type mismatch: variable $name is of type $existingType, cannot assign $type")
            }
            typeTable[name] = type
        } else if (existingType != null && !isTypeCompatible(existingType, value)) {
            throw RuntimeException("Type mismatch: expected $existingType, found ${value.javaClass.simpleName}")
        }
        symbolTable[name] = value
    }

    private fun isTypeCompatible(expectedType: String, value: Data): Boolean {
        return when (expectedType) {
            "Int" -> value is IntData
            "String" -> value is StringData
            "Boolean" -> value is BooleanData
            "Double" -> value is DoubleData
            else -> false
        }
    }

    fun subscope(bindings: Map<String, Data>): Runtime {
        val parentSymbolTable = this.symbolTable
        parentSymbolTable.map {
            entry -> "${entry.key} = ${entry.value}"
        }.joinToString("; ")
        return Runtime().apply {
            symbolTable.putAll(parentSymbolTable)
            symbolTable.putAll(bindings)
            typeTable.putAll(this@Runtime.typeTable)
        }
    }

    override fun toString(): String =
        symbolTable.map {
            entry -> "${entry.key} = ${entry.value}"
        }.joinToString("; ")
}
