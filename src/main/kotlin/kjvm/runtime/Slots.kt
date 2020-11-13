package kjvm.runtime

import java.util.*

class Slots<T>(size: Int) {
    private val buffer = arrayOfNulls<Any?>(size) as kotlin.Array<T?>

    fun set(pos: Int, entity: T?, size: Int){
        require(!(pos < 0 || pos + size > buffer.size)) { "invalid entity size $size" }
        buffer[pos] = entity
        for (i in 1 until size) {
            buffer[pos + i] = null
        }
    }

    @Throws(NoSuchElementException::class)
    operator fun get(pos: Int): T? {
        if (pos < 0 || pos >= buffer.size) {
            throw NoSuchElementException()
        }
        return buffer[pos]
    }

    fun size(): Int {
        return buffer.size
    }
}