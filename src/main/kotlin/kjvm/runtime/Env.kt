package kjvm.runtime

import kjvm.VirtualMachine

class Env(private val virtualMachine: VirtualMachine) {
    private val jvmStack = JvmStack()

    fun getStack(): JvmStack{
        return jvmStack
    }
    fun getVirtualMachine(): VirtualMachine {
        return virtualMachine
    }
}