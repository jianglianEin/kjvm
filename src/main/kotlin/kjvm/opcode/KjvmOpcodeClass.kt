package kjvm.opcode


import kjvm.lang.*
import kjvm.runtime.Env
import org.apache.bcel.classfile.ClassParser
import org.apache.bcel.classfile.JavaClass
import org.apache.bcel.classfile.Method
import java.nio.file.Path
import java.util.*

class KjvmOpcodeClass(private val classLoader: KjvmClassLoader?, private val classParser: JavaClass) : KjvmClass {
    private val className = classParser.className
    private val methodsMap = hashMapOf<Map.Entry<String, String>, KjvmOpcodeMethod>()
    private val fieldsMap = hashMapOf<String, KjvmField>()

    private var isInited = false

    init {
        for (method: Method in classParser.methods) {
            val name = method.name
            val signature = method.signature
            methodsMap[AbstractMap.SimpleEntry(name, signature)] = KjvmOpcodeMethod(this, method)
        }
    }


    companion object {
        fun read(classLoader: KjvmClassLoader?, path: Path?): KjvmOpcodeClass? {
            val classParser = ClassParser(path.toString()).parse()
            return KjvmOpcodeClass(classLoader, classParser)
        }
    }

    override fun newInstance(env: Env): KjvmObject {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getMethod(name: String, description: String): KjvmMethod {
        return methodsMap[AbstractMap.SimpleEntry(name, description)]
            ?: throw NoSuchMethodException("opcode method: $name, description: $description")
    }

    override fun hasMethod(name: String, description: String): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getField(name: String): KjvmField {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getClassLoader(): KjvmClassLoader {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getSuperClass(): KjvmClass {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getName(): String {
        return className
    }

    fun getClassParser(): JavaClass {
        return classParser
    }

    fun clinit(env: Env) {
        if (isInited) {
            return
        }
        synchronized(this) {
            if (isInited) {
                return
            }
            isInited = true

            methodsMap[AbstractMap.SimpleEntry("<clinit>", "()V")]?.call(env, null)
        }
    }
}