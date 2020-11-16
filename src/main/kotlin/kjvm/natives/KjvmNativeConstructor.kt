package kjvm.natives

import kjvm.lang.KjvmMethod
import kjvm.runtime.Env
import java.lang.reflect.Constructor

class KjvmNativeConstructor(private val nativeClass: KjvmNativeClass, private val constructor: Constructor<*>) :
    KjvmMethod {
    override fun call(env: Env, thiz: Any?, args: Array<Any?>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getParameterCount(): Int {
        return constructor.parameterCount
    }

    override fun getName(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}