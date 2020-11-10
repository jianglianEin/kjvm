package kjvm.opcode

import kjvm.runtime.Env
import kjvm.runtime.StackFrame

interface OpcodeInvoker {
    fun invoke(env: Env, stackFrame: StackFrame)
}