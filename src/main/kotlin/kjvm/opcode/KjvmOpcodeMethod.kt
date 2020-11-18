package kjvm.opcode

import kjvm.lang.KjvmMethod
import kjvm.runtime.Env
import kjvm.tools.ClassFileHelper
import org.apache.bcel.Constants
import org.apache.bcel.classfile.Code
import org.apache.bcel.classfile.Method
import kotlin.experimental.and


class KjvmOpcodeMethod(private val opcodeClass: KjvmOpcodeClass, private val method: Method) : KjvmMethod {

    private val codeAttribute = method.attributes[0]
    private val name = method.name
    private val parameterCount = ClassFileHelper.parseMethodSignatureAndGetParameterCount(method.signature)
    private val opcodes = BytecodeInterpreter.parseCodes((method.attributes[0] as Code).code)


    override fun call(env: Env, thiz: Any?, args: Array<Any?>) {
        val frame = env.getStack().newFrame(
            opcodeClass,
            this,
            opcodeClass.getClassParser().constantPool,
            opcodes,
            (codeAttribute as Code).maxLocals,
            (codeAttribute as Code).maxStack
        )

        val localVariables = frame.getLocalVariables()
        var pos = 0

        if (Constants.ACC_STATIC.and(method.accessFlags.toShort()).toInt() == 0) {
            localVariables.set(0, thiz, 1)
            pos++
        }

        for (arg in args) {
            localVariables.set(pos++, arg, 1)
        }

        opcodeClass.clinit(env)
        BytecodeInterpreter.run(env)

    }

    override fun getParameterCount(): Int {
        return parameterCount
    }

    override fun getName(): String {
        return name
    }
}