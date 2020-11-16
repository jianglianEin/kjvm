package kjvm.natives

import kjvm.lang.KjvmMethod
import kjvm.runtime.Env
import java.lang.reflect.Method

class KjvmNativeMethod(private val nativeClass: KjvmNativeClass, private val method: Method) : KjvmMethod {
    private val name = method.name

    override fun call(env: Env, thiz: Any?, vararg args: Any?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getParameterCount(): Int {
        return method.parameterCount
    }

    override fun getName(): String {
        return name
    }
}