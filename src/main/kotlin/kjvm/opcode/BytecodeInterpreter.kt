package kjvm.opcode
import kjvm.runtime.Env
import kjvm.runtime.StackFrame
import org.apache.bcel.Constants
import java.util.*

class BytecodeInterpreter {
    companion object{
        fun run(env: Env) {
            if (env.getStack().isRunning()) {
                return
            }

            val jvmStack = env.getStack()
            jvmStack.setRunning(true)
            var frame = jvmStack.currentFrame()

            while (frame != null){
                if (frame.isReturned()) {
                    val oldFrame = frame
                    jvmStack.popFrame()
                    frame = jvmStack.currentFrame()
                    if (frame != null && "void" != frame.getReturnType()){
                        frame.getOperandStack().push(oldFrame.getReturn())
                    }
                    continue
                }

                val opcodes = frame.getOpcodes()
                var pc = frame.increasePC()

                val sb = StringBuilder()
                sb.append("> ")
                sb.append(frame.getKjvmClass().getName())
                sb.append(".")
                sb.append(frame.getKjvmMethod().getName())
                sb.append("@")
                sb.append(pc)
                sb.append(":")
                sb.append(opcodes[pc])
                println(sb)

                opcodes[pc].invoke(env, frame)
            }
            
        }

        fun parseCodes(codes: ByteArray): ArrayList<OpcodeInvoker>{
            val opcodes = arrayListOf<OpcodeInvoker>()
            var i = 0
            while (i < codes.size) {
                val code = (0xff and codes[i].toInt()).toShort()
                val route: OpcodeRout = OpcodeRout.valueOf(code)
                val noOfOperands = Constants.NO_OF_OPERANDS[code.toInt()]
                val operands = codes.copyOfRange(i + 1, i + 1 + noOfOperands)
                opcodes.add(object : OpcodeInvoker {
                    override fun invoke(env: Env, stackFrame: StackFrame) {
                        fun invoke(env: Env?, frame: StackFrame?) {
                            route.invoke(env, frame, operands)
                        }

                        fun toString(): String? {
                            return route.name
                        }
                    }
                })
                i += noOfOperands.toInt()
                i++
            }
            return opcodes.clone() as ArrayList<OpcodeInvoker>
        }
    }
}