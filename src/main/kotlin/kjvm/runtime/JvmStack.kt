package kjvm.runtime

import kjvm.lang.KjvmClass
import kjvm.lang.KjvmMethod
import kjvm.opcode.OpcodeInvoker
import org.apache.bcel.classfile.ConstantPool

class JvmStack {
    private val frames = SlotsStack<StackFrame>(1024)
    private var running = false

    fun newFrame(kjvmClass: KjvmClass, kjvmMethod: KjvmMethod): StackFrame {
        val frame = StackFrame(kjvmClass, kjvmMethod, null, null, 0, 0)
        frames.push(frame)
        return frame
    }

    fun newFrame(
        kjvmClass: KjvmClass,
        kjvmMethod: KjvmMethod,
        constantPool: ConstantPool,
        opcodes: ArrayList<OpcodeInvoker>,
        variables: Int,
        stackSize: Int
    ): StackFrame {
        val frame = StackFrame(kjvmClass, kjvmMethod, constantPool, opcodes, variables, stackSize)
        frames.push(frame)
        return frame
    }

    fun currentFrame(): StackFrame? {
        return frames.pick()
    }

    fun popFrame(): StackFrame? {
        return frames.pop()
    }

    fun isRunning(): Boolean {
        return running
    }

    fun setRunning(running: Boolean) {
        this.running = running
    }
}