package kjvm.lang

interface KjvmObject {
    fun getSuper(): KjvmObject

    fun getClazz(): KjvmObject
}