package kjvm.opcode

import kjvm.lang.KjvmObject
import kjvm.runtime.Env
import kjvm.runtime.StackFrame
import org.apache.bcel.Constants
import org.apache.bcel.classfile.*
import java.util.*
import kotlin.collections.ArrayList

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
    ILOAD_0(Constants.ILOAD_0) {
        override fun invoke(env: Env, frame: StackFrame, operands: ByteArray) {
            val value = frame.getLocalVariables()[0]
            frame.getOperandStack().push(value, 1)
        }

        override fun getCode(): Short {
            return Constants.ILOAD_0
        }

    },
    ILOAD_1(Constants.ILOAD_1) {
        override fun invoke(env: Env, frame: StackFrame, operands: ByteArray) {
            val value = frame.getLocalVariables()[1]
            frame.getOperandStack().push(value, 1)
        }

        override fun getCode(): Short {
            return Constants.ILOAD_1
        }

    },
    ILOAD_2(Constants.ILOAD_2) {
        override fun invoke(env: Env, frame: StackFrame, operands: ByteArray) {
            val value = frame.getLocalVariables()[2]
            frame.getOperandStack().push(value, 1)
        }

        override fun getCode(): Short {
            return Constants.ILOAD_2
        }

    },
    ILOAD_3(Constants.ILOAD_3) {
        override fun invoke(env: Env, frame: StackFrame, operands: ByteArray) {
            val value = frame.getLocalVariables()[3]
            frame.getOperandStack().push(value, 1)
        }

        override fun getCode(): Short {
            return Constants.ILOAD_3
        }

    },
    ICONST_0(Constants.ICONST_0) {
        override fun invoke(env: Env, frame: StackFrame, operands: ByteArray) {
            frame.getOperandStack().push(0, 1)
        }

        override fun getCode(): Short {
            return Constants.ICONST_0
        }

    },
    ICONST_1(Constants.ICONST_1) {
        override fun invoke(env: Env, frame: StackFrame, operands: ByteArray) {
            frame.getOperandStack().push(1, 1)
        }

        override fun getCode(): Short {
            return Constants.ICONST_1
        }

    },
    ICONST_2(Constants.ICONST_2) {
        override fun invoke(env: Env, frame: StackFrame, operands: ByteArray) {
            frame.getOperandStack().push(2, 1)
        }

        override fun getCode(): Short {
            return Constants.ICONST_2
        }

    },
    ICONST_3(Constants.ICONST_3) {
        override fun invoke(env: Env, frame: StackFrame, operands: ByteArray) {
            frame.getOperandStack().push(3, 1)
        }

        override fun getCode(): Short {
            return Constants.ICONST_3
        }

    },
    ICONST_4(Constants.ICONST_4) {
        override fun invoke(env: Env, frame: StackFrame, operands: ByteArray) {
            frame.getOperandStack().push(4, 1)
        }

        override fun getCode(): Short {
            return Constants.ICONST_4
        }

    },
    ICONST_5(Constants.ICONST_5) {
        override fun invoke(env: Env, frame: StackFrame, operands: ByteArray) {
            frame.getOperandStack().push(5, 1)
        }

        override fun getCode(): Short {
            return Constants.ICONST_5
        }

    },
    BIPUSH(Constants.BIPUSH) {
        override fun invoke(env: Env, frame: StackFrame, operands: ByteArray) {
            frame.getOperandStack().push(operands[0], 1)
        }

        override fun getCode(): Short {
            return Constants.BIPUSH
        }

    },
    ISTORE(Constants.ISTORE) {
        override fun invoke(env: Env, frame: StackFrame, operands: ByteArray) {
            TODO("implement like ISTORE_1")
        }

        override fun getCode(): Short {
            return Constants.ISTORE
        }

    },
    ISTORE_1(Constants.ISTORE_1) {
        override fun invoke(env: Env, frame: StackFrame, operands: ByteArray) {
            val storeNum = frame.getOperandStack().pop() as Int
            frame.getLocalVariables().set(1, storeNum, 1)
        }

        override fun getCode(): Short {
            return Constants.ISTORE_1
        }

    },
    ISTORE_2(Constants.ISTORE_2) {
        override fun invoke(env: Env, frame: StackFrame, operands: ByteArray) {
            TODO("implement like ISTORE_1")
        }

        override fun getCode(): Short {
            return Constants.ISTORE_2
        }

    },
    ISTORE_3(Constants.ISTORE_3) {
        override fun invoke(env: Env, frame: StackFrame, operands: ByteArray) {
            TODO("implement like ISTORE_1")
        }

        override fun getCode(): Short {
            return Constants.ISTORE_3
        }

    },
    ASTORE_1(Constants.ASTORE_1) {
        override fun invoke(env: Env, frame: StackFrame, operands: ByteArray) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun getCode(): Short {
            return Constants.ASTORE_1
        }

    },
    ASTORE_2(Constants.ASTORE_2) {
        override fun invoke(env: Env, frame: StackFrame, operands: ByteArray) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun getCode(): Short {
            return Constants.ASTORE_2
        }

    },
    IASTORE(Constants.IASTORE) {
        override fun invoke(env: Env, frame: StackFrame, operands: ByteArray) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun getCode(): Short {
            return Constants.IASTORE
        }

    },
    ILOAD(Constants.ILOAD) {
        override fun invoke(env: Env, frame: StackFrame, operands: ByteArray) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun getCode(): Short {
            return Constants.ILOAD
        }

    },
    IALOAD(Constants.IALOAD) {
        override fun invoke(env: Env, frame: StackFrame, operands: ByteArray) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun getCode(): Short {
            return Constants.IALOAD
        }

    },
    DUP(Constants.DUP) {
        override fun invoke(env: Env, frame: StackFrame, operands: ByteArray) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun getCode(): Short {
            return Constants.DUP
        }

    },
    IADD(Constants.IADD) {
        override fun invoke(env: Env, frame: StackFrame, operands: ByteArray) {
            val args: ArrayList<Any> = frame.getOperandStack().multiPop(2)
            if (args[0] is Int && args[1] is Int) {
                val result: Int = args[0] as Int + args[1] as Int
                frame.getOperandStack().push(result, 1)
            } else {
                throw InternalError("Args type should be Int")
            }

        }

        override fun getCode(): Short {
            return Constants.IADD
        }

    },
    ISUB(Constants.ISUB) {
        override fun invoke(env: Env, frame: StackFrame, operands: ByteArray) {
            val args: ArrayList<Any> = frame.getOperandStack().multiPop(2)
            args.reverse()
            if (args[0] is Int && args[1] is Int) {
                val result: Int = args[0] as Int - args[1] as Int
                frame.getOperandStack().push(result, 1)
            } else {
                throw InternalError("Args type should be Int")
            }

        }

        override fun getCode(): Short {
            return Constants.ISUB
        }

    },
    IINC(Constants.IINC) {
        override fun invoke(env: Env, frame: StackFrame, operands: ByteArray) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun getCode(): Short {
            return Constants.IINC
        }

    },
    NEWARRAY(Constants.NEWARRAY) {
        override fun invoke(env: Env, frame: StackFrame, operands: ByteArray) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun getCode(): Short {
            return Constants.NEWARRAY
        }

    },
    ARRAYLENGTH(Constants.ARRAYLENGTH) {
        override fun invoke(env: Env, frame: StackFrame, operands: ByteArray) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun getCode(): Short {
            return Constants.ARRAYLENGTH
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
    IRETURN(Constants.IRETURN) {
        override fun invoke(env: Env, frame: StackFrame, operands: ByteArray) {
            frame.setReturn(frame.getOperandStack().pop(), "int")
        }

        override fun getCode(): Short {
            return Constants.IRETURN
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
    IF_ICMPNE(Constants.IF_ICMPNE) {
        override fun invoke(env: Env, frame: StackFrame, operands: ByteArray) {
            val value1 = frame.getOperandStack().pop()
            val value2 = frame.getOperandStack().pop()
            if (value1 != value2) {
                val arg = operands[0].toInt() shl 8 or operands[1].toInt()
                val offset = arg - operands.size
                frame.setPC(frame.getPC() + offset - 1)
            }
        }

        override fun getCode(): Short {
            return Constants.IF_ICMPNE
        }

    },
    IF_ICMPGE(Constants.IF_ICMPGE) {
        override fun invoke(env: Env, frame: StackFrame, operands: ByteArray) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun getCode(): Short {
            return Constants.IF_ICMPGE
        }

    },
    IFNE(Constants.IFNE) {
        override fun invoke(env: Env, frame: StackFrame, operands: ByteArray) {
            val value = frame.getOperandStack().pop()
            if (value != 0) {
                val arg = operands[0].toInt() shl 8 or operands[1].toInt()
                val offset = arg - operands.size
                frame.setPC(frame.getPC() + offset - 1)
            }
        }

        override fun getCode(): Short {
            return Constants.IFNE
        }

    },
    GOTO(Constants.GOTO) {
        override fun invoke(env: Env, frame: StackFrame, operands: ByteArray) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun getCode(): Short {
            return Constants.GOTO
        }

    },
    INVOKEVIRTUAL(Constants.INVOKEVIRTUAL) {
        override fun invoke(env: Env, frame: StackFrame, operands: ByteArray) {
            INVOKESPECIAL.invoke(env, frame, operands)
        }

        override fun getCode(): Short {
            return Constants.INVOKEVIRTUAL
        }
    },
    INVOKESTATIC(Constants.INVOKESTATIC) {
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

            val args = frame.getOperandStack().multiPop(kjvmMethod.getParameterCount())
            args.reverse()
            val argsArr = args.toArray()

            kjvmMethod.call(env, null, Arrays.copyOfRange(argsArr, 0, argsArr.size))
        }

        override fun getCode(): Short {
            return Constants.INVOKESTATIC
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
