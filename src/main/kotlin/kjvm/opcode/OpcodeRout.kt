package kjvm.opcode

import kjvm.runtime.Env
import kjvm.runtime.StackFrame
import org.apache.bcel.Constants

enum class OpcodeRout(code: Short) {
    ALOAD_0(Constants.ALOAD_0) {
        override fun invoke(env: Env?, frame: StackFrame?, operands: ByteArray?) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun getCode(): Short {
            return Constants.ALOAD_0
        }

    },
    ALOAD_1(Constants.ALOAD_1) {
        override fun invoke(env: Env?, frame: StackFrame?, operands: ByteArray?) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun getCode(): Short {
            return Constants.ALOAD_1
        }
    },
    ALOAD_2(Constants.ALOAD_2) {
        override fun invoke(env: Env?, frame: StackFrame?, operands: ByteArray?) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun getCode(): Short {
            return Constants.ALOAD_2
        }
    },
    ALOAD_3(Constants.ALOAD_3) {
        override fun invoke(env: Env?, frame: StackFrame?, operands: ByteArray?) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun getCode(): Short {
            return Constants.ALOAD_3
        }
    },
    RETURN(Constants.RETURN) {
        override fun invoke(env: Env?, frame: StackFrame?, operands: ByteArray?) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun getCode(): Short {
            return Constants.RETURN
        }

    },
    INVOKESPECIAL(Constants.INVOKESPECIAL) {
        override fun invoke(env: Env?, frame: StackFrame?, operands: ByteArray?) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun getCode(): Short {
            return Constants.INVOKESPECIAL
        }

    };

    companion object {
        private val codeMapping = hashMapOf<Short, OpcodeRout>()

        init {
            for (opcode in values()) {
                codeMapping[opcode.getCode()] = opcode
            }
        }


        fun valueOf(code: Short): OpcodeRout {
            return codeMapping[code]
                ?: throw InternalError("The opcode " + code.toInt() + " Not Impl")
        }
    }

    @Throws(Exception::class)
    abstract fun invoke(env: Env?, frame: StackFrame?, operands: ByteArray?)
    abstract fun getCode(): Short
}
