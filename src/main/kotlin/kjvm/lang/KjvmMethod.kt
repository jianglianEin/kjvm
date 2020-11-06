package kjvm.lang

import kjvm.runtime.Env

interface KjvmMethod {
    fun call(env: Env?, thiz: Any?, vararg args: Any?)
    fun getParameterCount(): Int
    fun getName(): String
}