package kjvm.opcode

import kjvm.runtime.Env
import kjvm.runtime.StackFrame
import org.apache.bcel.Constants
import org.apache.bcel.classfile.ConstantClass
import org.apache.bcel.classfile.ConstantFieldref
import org.apache.bcel.classfile.ConstantNameAndType
import org.apache.bcel.classfile.ConstantUtf8

enum class OpcodeRout(code: Short) {
    ALOAD_0(Constants.ALOAD_0) {
        override fun invoke(env: Env, frame: StackFrame, operands: ByteArray) {
            val value = frame.getLocalVariables()[0]
            frame.getOperandStack().push(value, 1)
        }

        override fun getCode(): Short {
            return Constants.ALOAD_0
        }

    },
    ALOAD_1(Constants.ALOAD_1) {
        override fun invoke(env: Env, frame: StackFrame, operands: ByteArray) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun getCode(): Short {
            return Constants.ALOAD_1
        }
    },
    ALOAD_2(Constants.ALOAD_2) {
        override fun invoke(env: Env, frame: StackFrame, operands: ByteArray) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun getCode(): Short {
            return Constants.ALOAD_2
        }
    },
    ALOAD_3(Constants.ALOAD_3) {
        override fun invoke(env: Env, frame: StackFrame, operands: ByteArray) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun getCode(): Short {
            return Constants.ALOAD_3
        }
    },
    RETURN(Constants.RETURN) {
        override fun invoke(env: Env, frame: StackFrame, operands: ByteArray) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun getCode(): Short {
            return Constants.RETURN
        }

    },
    INVOKESPECIAL(Constants.INVOKESPECIAL) {
        override fun invoke(env: Env, frame: StackFrame, operands: ByteArray) {
            val arg = operands[0].toInt() shl 8 or operands[1].toInt()

            frame.getConstantPool()?.constantPool?.get(arg)
        }

        override fun getCode(): Short {
            return Constants.INVOKESPECIAL
        }

    },
    GETSTATIC(Constants.GETSTATIC) {
        override fun invoke(env: Env, frame: StackFrame, operands: ByteArray) {
            val index = (operands[0].toInt() shl 8) or operands[1].toInt()
            val constantPool = frame.getConstantPool()!!
            val cpClassIndex = constantPool.getConstant((constantPool.constantPool[index] as ConstantFieldref).classIndex)
            val cpNameAndTypeIndex = constantPool.getConstant((constantPool.constantPool[index] as ConstantFieldref).nameAndTypeIndex)

            val classPackage =(constantPool.getConstant((cpClassIndex as ConstantClass).nameIndex) as ConstantUtf8).bytes
            val methodName =(constantPool.getConstant((cpNameAndTypeIndex as ConstantNameAndType).nameIndex) as ConstantUtf8).bytes

            val kjvmClass = env.getVirtualMachine().getClassFile(classPackage)
            val kjvmFiled = kjvmClass.getField(methodName)

            val value = kjvmFiled.get(env, null)
            frame.getOperandStack().push(value, 1)

        }

        override fun getCode(): Short {
            return Constants.GETSTATIC
        }

    },
    LDC(Constants.LDC) {
        override fun invoke(env: Env, frame: StackFrame, operands: ByteArray) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun getCode(): Short {
            return Constants.LDC
        }
    },
    INVOKEVIRTUAL(Constants.INVOKEVIRTUAL) {
        override fun invoke(env: Env, frame: StackFrame, operands: ByteArray) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun getCode(): Short {
            return Constants.INVOKEVIRTUAL
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
    abstract fun invoke(env: Env, frame: StackFrame, operands: ByteArray)

    abstract fun getCode(): Short
}
