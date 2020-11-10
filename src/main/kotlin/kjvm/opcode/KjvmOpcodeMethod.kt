package kjvm.opcode

import kjvm.lang.KjvmMethod
import kjvm.runtime.Env
import kjvm.tools.ClassFileHelper
import org.apache.bcel.classfile.Code
import org.apache.bcel.classfile.Method


class KjvmOpcodeMethod(private val opcodeClass: KjvmOpcodeClass, private val method: Method) : KjvmMethod {
    init {
        val codeAttribute = method.attributes[0]
        val name = method.name
        val argsNum = ClassFileHelper.parseMethodSignature(method.signature)
        val opcodes = BytecodeInterpreter.parseCodes((method.attributes[0] as Code).code)
    }

    override fun call(env: Env?, thiz: Any?, vararg args: Any?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getParameterCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getName(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}