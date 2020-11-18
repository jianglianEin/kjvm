package kjvm.tools

import kotlin.Exception

class ClassFileHelper {
    companion object {
        fun parseMethodSignatureAndGetParameterCount(signature: String): Int {
            val boundary: Int = signature.indexOf(")") + 1
            var index: Int = 0
            var count = 0
            loop@ while (index < boundary) {
                when (signature[index++]) {
                    '(', ')' -> continue@loop
                    '*', '+', ',', '-', '.', '/', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', ':', ';', '<', '=', '>', '?', '@', 'A', 'E', 'G', 'H', 'K', 'M', 'N', 'O', 'P', 'Q', 'R', 'T', 'U', 'W', 'X', 'Y' -> throw Exception()
                    'B', 'C', 'D', 'F', 'I', 'J', 'S', 'V', 'Z' -> ++count
                    'L' -> {
                        val var9: Int = signature.indexOf(59.toChar(), index)
                        if (var9 == -1) {
                        }
                        index = var9 + 1
                        ++count
                        continue@loop
                    }
                }
            }
            return count
        }
    }
}