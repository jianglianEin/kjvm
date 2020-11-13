package kjvm

import kjvm.lang.KjvmClass
import kjvm.runtime.Env
import java.nio.file.Path

class VirtualMachine(private val rootPath: Path, private var classPackage: String) {
    private val methodArea = hashMapOf<String, KjvmClass>()
    private val classLoader = KJvmClassLoader(rootPath)

    fun run(args: Array<String>) {
        val env = Env(this)
        val kjvmClass = getClassFile(classPackage)

        val kjvmMethod = kjvmClass.getMethod(
            "main",
            "([Ljava/lang/String;)V"
        )

        kjvmMethod.call(env, null, arrayOf<Any>(args))
    }

    fun getClassFile(classPackage: String): KjvmClass {
        val kjvmClass = methodArea[classPackage]
        return if (kjvmClass == null) {
            val loadClass = classLoader.loadClass(classPackage)
            methodArea[classPackage] = loadClass
            loadClass
        } else {
            kjvmClass
        }
    }
}