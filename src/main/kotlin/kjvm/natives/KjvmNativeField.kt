package kjvm.natives

import kjvm.lang.KjvmField
import kjvm.runtime.Env
import java.lang.reflect.Field

class KjvmNativeField(private val kjvmNativeClass: KjvmNativeClass, private val field: Field) : KjvmField {
    override fun set(env: Env, thiz: Any, value: Any) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun get(env: Env, thiz: Any?): Any? {
        return KjvmNativeObject.wrap(field.get(thiz), field.type, kjvmNativeClass.getClassLoader())
    }
}