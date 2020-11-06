package kjvm

import java.nio.file.Paths
import java.util.*

class Kjvm {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) { // write your code here
            if (args.isEmpty()) {
                println("Usage: <classpath> <classfile> [args...]")
            }
            val rootPath = args[0]
            val classPackage = args[1]

            val virtualMachine = VirtualMachine(Paths.get(rootPath), classPackage)

            val remainArgs = args.copyOfRange(2, args.size)
            virtualMachine.run(remainArgs)

        }
    }
}