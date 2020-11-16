package kjvm.opcode

import kjvm.lang.KjvmObject
import kjvm.runtime.Env
import kjvm.runtime.StackFrame
import org.apache.bcel.Constants
import org.apache.bcel.classfile.*
import java.util.*

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
            frame.setReturn(null, "void")
        }

        override fun getCode(): Short {
            return Constants.RETURN
        }

    },
    INVOKESPECIAL(Constants.INVOKESPECIAL) {
        override fun invoke(env: Env, frame: StackFrame, operands: ByteArray) {
            val arg = operands[0].toInt() shl 8 or operands[1].toInt()

            val info = frame.getConstantPool()?.constantPool?.get(arg) as ConstantMethodref
            val constantPool = frame.getConstantPool()!!
            val classIndex = constantPool.getConstant(info.classIndex) as ConstantClass
            val nameAndType = constantPool.getConstant(info.nameAndTypeIndex) as ConstantNameAndType

            val classPackage = classIndex.getConstantValue(constantPool) as String

            val kjvmClass = env.getVirtualMachine().getClassFile(classPackage)
            val kjvmMethod = kjvmClass.getMethod(
                nameAndType.getName(constantPool)
                , nameAndType.getSignature(constantPool)
            )

            val args = frame.getOperandStack().multiPop(kjvmMethod.getParameterCount() + 1)
            args.reverse()
            val argsArr = args.toArray()
            var thiz: KjvmObject = args[0] as KjvmObject

            while (thiz.getClazz().getName() != kjvmClass.getName()) {
                thiz = thiz.getSuper()
            }
            kjvmMethod.call(env, thiz, Arrays.copyOfRange(argsArr, 1, argsArr.size))
        }

        override fun getCode(): Short {
            return Constants.INVOKESPECIAL
        }

    },
    GETSTATIC(Constants.GETSTATIC) {
        override fun invoke(env: Env, frame: StackFrame, operands: ByteArray) {
            val index = (operands[0].toInt() shl 8) or operands[1].toInt()
            val constantPool = frame.getConstantPool()!!
            val classIndex =
                constantPool.getConstant((constantPool.constantPool[index] as ConstantFieldref).classIndex) as ConstantClass
            val nameAndType =
                constantPool.getConstant((constantPool.constantPool[index] as ConstantFieldref).nameAndTypeIndex) as ConstantNameAndType

            val classPackage = classIndex.getConstantValue(constantPool) as String
            val methodName = nameAndType.getName(constantPool)

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
            val arg = operands[0]
            val info = frame.getConstantPool()?.getConstant(arg.toInt())

            frame.getOperandStack().push(convert2Value(info, frame), 1)
        }

        override fun getCode(): Short {
            return Constants.LDC
        }
    },
    INVOKEVIRTUAL(Constants.INVOKEVIRTUAL) {
        override fun invoke(env: Env, frame: StackFrame, operands: ByteArray) {
            INVOKESPECIAL.invoke(env, frame, operands)
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

        private fun convert2Value(info: Constant?, frame: StackFrame): Any? {
            return when {
                info!!.tag == Constants.CONSTANT_String -> {
                    (frame.getConstantPool()?.getConstant((info as ConstantString).stringIndex) as ConstantUtf8).bytes
                }
                info.tag == Constants.CONSTANT_Integer -> {
                    (frame.getConstantPool()?.getConstant((info as ConstantInteger).bytes) as ConstantInteger).bytes
                }
                info.tag == Constants.CONSTANT_Float -> {
                    (info as ConstantFloat).bytes
                }
                else -> {
                    throw InternalError("unknown type: " + info.tag)
                }
            }
        }
    }

    @Throws(Exception::class)
    abstract fun invoke(env: Env, frame: StackFrame, operands: ByteArray)

    abstract fun getCode(): Short
}
