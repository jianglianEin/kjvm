package kjvm.runtime

import kjvm.lang.KjvmClass
import kjvm.lang.KjvmMethod
import kjvm.opcode.OpcodeInvoker
import org.apache.bcel.classfile.ConstantPool

class StackFrame(
    private val kjvmClass: KjvmClass,
    private val kjvmMethod: KjvmMethod,
    private val constantPool: ConstantPool?,
    private val opcodes: ArrayList<OpcodeInvoker>?,
    variables: Int,
    stackSize: Int
) {
    private val operandStack = SlotsStack<Any>(stackSize)
    private val localVariables = Slots<Any>(variables)
    private var pc = 0
    private var isReturned = false
    private var returnVal: Any? = null
    private var returnType: String = ""

    fun getLocalVariables(): Slots<Any> {
        return localVariables
    }

    fun getOperandStack(): SlotsStack<Any> {
        return operandStack
    }

    fun getConstantPool(): ConstantPool? {
        return constantPool
    }

    fun setPC(pc: Int) {
        this.pc = pc
    }

    fun getPC(): Int {
        return pc
    }

    fun increasePC(): Int {
        return pc++
    }

    fun getOpcodes(): ArrayList<OpcodeInvoker>? {
        return opcodes
    }

    fun getKjvmClass(): KjvmClass {
        return kjvmClass
    }

    fun getKjvmMethod(): KjvmMethod {
        return kjvmMethod
    }

    fun setReturn(returnVal: Any?, returnType: String?) {
        isReturned = true
        this.returnVal = returnVal
        this.returnType = returnType!!
    }

    fun getReturn(): Any? {
        return returnVal
    }

    fun getReturnType(): String? {
        return returnType
    }

    fun isReturned(): Boolean{
        return isReturned
    }
}