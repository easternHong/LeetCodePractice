/**
 * Created by eastern on 2017/10/12.
 */


//在一个排好序的数组中查找某值value，如果找到则返回对应index，不存在则返回能插入数组中的位置
object _SearchInsertPosition {


    @JvmStatic
    fun main(args: Array<String>) {
        var data = arrayOf(1, 5, 9, 13)
        println(_binSearch(data, 10))
        println(_binSearch(data, 14))
        println(_binSearch(data, 2))
    }


    //二分查找法正是 这个答案
    fun _binSearch(data: Array<Int>, target: Int): Int {
        var l = 0
        var r = data.size - 1
        while (l <= r) {
            val mid = l + (r - l) / 2
            if (data[mid] > target) {
                r = mid - 1
            } else if (data[mid] < target) {
                l = mid + 1
            } else {
                //find the index
                return mid
            }
        }
        return l
    }
}