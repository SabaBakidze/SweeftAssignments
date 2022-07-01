import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class DataStructure {
    var arr = ArrayList<Int>()
    private var hash = HashMap<Int, Int>()


    fun add(x: Int) {
        var size = arr.size
        arr.add(x)

        hash[x] = size
    }

    fun remove(x: Int){
        var index: Int = hash[x] ?: return

        hash.remove(x)
        var size = arr.size
        var lastElement = arr[size-1]
        Collections.swap(arr, index, size-1)

        arr.removeAt(size-1)

        hash[lastElement] = index
    }

    fun get(x: Int): Int? {
        return hash[x]
    }
}