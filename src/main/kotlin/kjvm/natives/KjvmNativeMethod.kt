package kjvm.natives

import kjvm.lang.KjvmMethod
import kjvm.runtime.Env
import kjvm.runtime.StackFrame
import java.lang.reflect.Method

class KjvmNativeMethod(private val nativeClass: KjvmNativeClass, private val method: Method) : KjvmMethod {
    private val name = method.name

    override fun call(env: Env, thiz: Any?, args: Array<Any?>) {
        assert(thiz is KjvmNativeObject)
        val frame: StackFrame = env.getStack().newFrame(nativeClass, this)
        val any: Any = (thiz as KjvmNativeObject).getNativeObject()!!
        var res = method.invoke(any, *KjvmNativeObject.multiUnwrap(args))

        res = KjvmNativeObject.wrap(res, method.returnType, nativeClass.getClassLoader())
        frame.setReturn(res, method.returnType.name)
    }

    override fun getParameterCount(): Int {
        return method.parameterCount
    }

    override fun getName(): String {
        return name
    }
}