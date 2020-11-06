package kjvm.lang

interface KjvmClassLoader {
    fun loadClass(classPackage: String): KjvmClass
}