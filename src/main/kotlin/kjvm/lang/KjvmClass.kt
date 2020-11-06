package kjvm.lang

import kjvm.runtime.Env

interface KjvmClass {
    fun newInstance(env: Env): KjvmObject
    fun getMethod(name: String, description: String): KjvmMethod
    fun hasMethod(name: String, description: String): Boolean
    fun getField(name: String): KjvmField
    fun getClassLoader(): KjvmClassLoader
    fun getSuperClass(): KjvmClass
    fun getName(): String
}