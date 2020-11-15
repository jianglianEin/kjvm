package kjvm.natives


import kjvm.lang.*
import kjvm.runtime.Env
import org.objectweb.asm.Type
import java.util.*
import java.util.AbstractMap.SimpleEntry

class KjvmNativeClass(private val classLoader: KjvmClassLoader, private val nativeClass: Class<*>) : KjvmClass {
    private val methods: HashMap<Map.Entry<String, String>, KjvmMethod> = HashMap()
    private val className = nativeClass.name

    init {

        for (method in nativeClass.methods) {
            methods[SimpleEntry(
                method.name, Type.getMethodDescriptor(method)
            )] = KjvmNativeMethod(this, method)
        }

        for (constructor in nativeClass.constructors) {
            methods[SimpleEntry(
                "<init>", Type.getConstructorDescriptor(constructor)
            )] = KjvmNativeConstructor(this, constructor)
        }
    }

    override fun newInstance(env: Env): KjvmObject {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getMethod(name: String, description: String): KjvmMethod {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hasMethod(name: String, description: String): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getField(name: String): KjvmField {
        return KjvmNativeField(this, nativeClass.getField(name))
    }

    override fun getClassLoader(): KjvmClassLoader {
        return classLoader
    }

    override fun getSuperClass(): KjvmClass {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getName(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}