package kjvm.opcode
import kjvm.runtime.Env
import kjvm.runtime.StackFrame
import org.apache.bcel.Constants
import java.util.*

class BytecodeInterpreter {
    companion object{
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