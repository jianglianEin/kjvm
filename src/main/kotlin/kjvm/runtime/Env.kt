package kjvm.runtime

import kjvm.VirtualMachine

class Env(private val virtualMachine: VirtualMachine) {
    private val jvmStack = JvmStack()
}