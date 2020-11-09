package kjvm

import kjvm.lang.KjvmClass
import kjvm.lang.KjvmClassLoader
import kjvm.opcode.KjvmOpcodeClass
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

class KJvmClassLoader(private val classPath: Path) : KjvmClassLoader {

    override fun loadClass(classPackage: String): KjvmClass {
        val fileString: String = classPath.toString() + "/" + classPackage.toString().replace(".", "/") + ".class"
        val filePath = Paths.get(fileString)
        return if (Files.exists(filePath)) {
            KjvmOpcodeClass.read(this, filePath)!!
        } else {
    //            return KjvmNativeClass(this, Class.forName(classPackage.replace("/", ".")))
            KjvmOpcodeClass.read(this, filePath)!!
        }
    }
}