package kjvm.opcode

import kjvm.lang.*
import kjvm.runtime.Env
import java.nio.file.Path

class KjvmOpcodeClass: KjvmClass {
    companion object {
        fun read(classLoader: KjvmClassLoader?, path: Path?): KjvmOpcodeClass? {
            return null
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
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getClassLoader(): KjvmClassLoader {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getSuperClass(): KjvmClass {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getName(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}