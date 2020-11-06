package kjvm.lang

import kjvm.runtime.Env

interface KjvmField {
    fun set(env: Env, thiz: Any, value: Any)
    fun get(env: Env, thiz: Any): Any
}