package kjvm.natives

import kjvm.lang.KjvmClass
import kjvm.lang.KjvmClassLoader
import kjvm.lang.KjvmObject
import java.util.*

class KjvmNativeObject(private val kjvmNativeClass: KjvmNativeClass) : KjvmObject {
    private var any: Any? = null

    companion object {
        fun wrap(any: Any?, clazz: Class<*>, classLoader: KjvmClassLoader): Any? {
            if (any == null) {
                return null
            }
            val primitiveTypes = arrayOf(
                Byte::class.javaPrimitiveType!!.name,
                Short::class.javaPrimitiveType!!.name,
                Int::class.javaPrimitiveType!!.name,
                Long::class.javaPrimitiveType!!.name,
                Char::class.javaPrimitiveType!!.name,
                Float::class.javaPrimitiveType!!.name,
                Double::class.javaPrimitiveType!!.name,
                Boolean::class.javaPrimitiveType!!.name
            )

            Arrays.sort(primitiveTypes)
            if (Arrays.binarySearch(primitiveTypes, clazz.name) < 0) {
                val wrap: KjvmNativeObject =
                    KjvmNativeObject(KjvmNativeClass(classLoader, clazz))
                wrap.setNativeObject(any)
                return wrap
            }

            return any
        }

        fun multiUnwrap(anyList: Array<*>): Array<Any?> {
            val res = arrayOfNulls<Any>(anyList.size)
            for (i in anyList.indices) {
                res[i] = unwrap(anyList[i]!!)
            }
            return res
        }

        fun unwrap(any: Any): Any? {
            if (any is KjvmNativeObject){
                return (any as KjvmNativeObject).getNativeObject()
            }
            return any
        }
    }

    override fun getSuper(): KjvmObject {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getClazz(): KjvmClass {
        return kjvmNativeClass
    }

    fun setNativeObject(any: Any) {
        this.any = any
    }

    fun getNativeObject(): Any? {
        return any
    }
}