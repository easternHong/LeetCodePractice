package adt.sort

/**
 * Created by hds on 17-10-13.
 */


object QuitckSort {


    @JvmStatic
    fun main(args: Array<String>) {
        println("quick sort")
        val array = arrayOf(20, 1, 3, 21, 53, 8, 6)
        quickSort(array, 0, array.size - 1)
        for (i in array)
            println(i)
    }

    fun quickSort(array: Array<Int>, l: Int, r: Int) {
        if (l < r) {
            val partition = partition(array, l, r)
            quickSort(array, l, partition - 1)
            quickSort(array, partition + 1, r)
        }
    }

    fun partition(array: Array<Int>, l: Int, r: Int): Int {
        var x = l
        var y = r
        var target = array[r]
        while (x < y) {
            while (x < y && array[x] < target)
                x++
            while (x < y && array[y] >= target)
                y--
            //判断x y的值，交换
            var tmp = array[y]
            array[y] = array[x]
            array[x] = tmp
        }
        //判断交换过后的 x和end的值，交换，否则向后移动一位
        if (array[x] >= array[r]) {
            var tmp = array[r]
            array[r] = array[x]
            array[x] = tmp
        } else x++
        return x
    }


}