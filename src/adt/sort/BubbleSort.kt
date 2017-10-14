package adt.sort

import adt.utils.Utils

/**
 * Created by hds on 17-10-13.
 */

object BubbleSort {


    @JvmStatic
    fun main(args: Array<String>) {
        println("BubbleSort")

        bubbleSort(Utils.randomList)
    }

    //[时间复杂度]最好情况不需要排序O(n),最坏的情况O(n^2),
    //[空间复杂度] O(1)
    //[解题思路]:从左边开始，选中第一个数A，然后从它的下一个数X开始遍历，当X<A时候，交换A<->X的位置。
    private fun bubbleSort(arrays: ArrayList<Int>) {
        val cnt = arrays.size - 1
        for (i in 0..cnt) {
            for (j in i + 1..cnt) {
                if (arrays[j] < arrays[i]) {
                    val tmp = arrays[i]
                    arrays[i] = arrays[j]
                    arrays[j] = tmp
                }
            }
        }
        println(arrays)
    }

    private fun bubbleSortEnhance(arrays: ArrayList<Int>) {
        println("改进版bubble")
    }
}