//package kjvm.natives
//
//import jdk.internal.org.objectweb.asm.Type
//import kjvm.lang.*
//import kjvm.runtime.Env
//import java.util.*
//import java.util.AbstractMap.SimpleEntry
//
//class KjvmNativeClass(classLoader: KjvmClassLoader, nativeClass: Class<*>?) : KjvmClass {
//    private val methods: HashMap<Map.Entry<String, String>, KjvmMethod> = HashMap()
//
//    init {
//        val className = nativeClass!!.name
//        for (method in nativeClass.methods) {
//            methods.put(
//                SimpleEntry(
//                    method.name,
//                    Type.getMethodDescriptor(method)
//                ),
//                (this, method)
//            )
//        }
//    }
//
//    override fun newInstance(env: Env): KjvmObject {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
//
//    override fun getMethod(name: String, description: String): KjvmMethod {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
//
//    override fun hasMethod(name: String, description: String): Boolean {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
//
//    override fun getField(name: String): KjvmField {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
//
//    override fun getClassLoader(): KjvmClassLoader {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
//
//    override fun getSuperClass(): KjvmClass {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
//
//    override fun getName(): String {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
//}