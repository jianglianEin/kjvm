package kjvm.tools

import kotlin.Exception

class ClassFileHelper {
    companion object {
        fun parseMethodSignature(name: String): Int {
            val boundary: Int = name.indexOf(")") + 1
            var index: Int = 0
            var count = 0
            while (index < boundary) {
                var tempString: String
                when (name[index++]) {
                    '*', '+', ',', '-', '.', '/', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', ':', ';', '<', '=', '>', '?', '@', 'A', 'E', 'G', 'H', 'K', 'M', 'N', 'O', 'P', 'Q', 'R', 'T', 'U', 'W', 'X', 'Y' -> throw Exception()
                    'B' -> tempString = "byte"
                    'C' -> tempString = "char"
                    'D' -> tempString = "double"
                    'F' -> tempString = "float"
                    'I' -> tempString = "int"
                    'J' -> tempString = "long"
                    'L' -> {
                        val var9: Int = name.indexOf(59.toChar(), index)
                        if (var9 == -1) {
                        }
                        tempString = name.substring(index, var9).replace('/', '.')
                        index = var9 + 1
                    }
                    'S' -> tempString = "short"
                    'V' -> tempString = "void"
                    'Z' -> tempString = "boolean"

                }
                ++count
            }
            return count
        }
    }
}