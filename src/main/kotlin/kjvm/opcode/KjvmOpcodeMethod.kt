package kjvm.opcode

import kjvm.lang.KjvmMethod
import kjvm.runtime.Env
import kjvm.tools.ClassFileHelper
import org.apache.bcel.classfile.Code
import org.apache.bcel.classfile.Method


class KjvmOpcodeMethod(private val opcodeClass: KjvmOpcodeClass, private val method: Method) : KjvmMethod {

    private val codeAttribute = method.attributes[0]
    private val name = method.name
    private val parameterCount = ClassFileHelper.parseMethodSignature(method.signature)
    private val opcodes = BytecodeInterpreter.parseCodes((method.attributes[0] as Code).code)


    override fun call(env: Env, thiz: Any?, vararg args: Any?) {
        val frame = env.getStack().newFrame(
            opcodeClass,
            this,
            opcodeClass.getClassParser().constantPool,
            opcodes,
            (codeAttribute as Code).maxLocals,
            (codeAttribute as Code).maxStack
        )
    }

    override fun getParameterCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getName(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}