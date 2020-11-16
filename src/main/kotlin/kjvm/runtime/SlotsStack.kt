package kjvm.runtime

class SlotsStack<T>(size: Int) {
    private val buffer =  arrayOfNulls<Any?>(size) as kotlin.Array<T?>

    private var end = 0

    fun push(entity: T?) {
        push(entity, 1)
    }

    fun push(entity: T?, size: Int) {
        if (size <= 0 || end + size > buffer.size) {
            throw IllegalArgumentException("invalid entity size: $size")
        }
        buffer[end] = entity
        for (i in 1 until size) {
            buffer[end + i] = null
        }
        end += size
    }

    fun pop(): T {
        while (end > 0) {
            end--
            val entity = buffer[end]
            if (entity != null) {
                buffer[end] = null
                return entity
            }
        }
        throw NoSuchElementException()
    }

    fun multiPop(count: Int): ArrayList<T> {
        if (count < 0) throw IllegalArgumentException("count can not <= 0")

        var countDown = count

        val result = arrayListOf<T>()
        while (end > 0 && countDown > 0) {
            end--
            val entity = buffer[end]
            if (entity != null) {
                buffer[end] = null
                result.add(entity)
                countDown--
            }
        }
        return result
    }

    fun pick(): T? {
        var localEnd = end
        while (localEnd > 0) {
            localEnd--
            val entity = buffer[localEnd]
            if (entity != null) {
                return entity
            }
        }
        return null
    }

    fun getEndSize(): Int{
        var localEnd = end
        while (localEnd > 0){
            localEnd--
            if (buffer[localEnd] != null){
                return end - localEnd
            }
        }
        return 0
    }
}