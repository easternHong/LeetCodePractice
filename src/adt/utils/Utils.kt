package adt.utils

import java.util.*

/**
 * Created by hds on 17-10-14.
 */
object Utils {

    class Node<T>(var leftNode: Node<T>?, var rightNode: Node<T>?, data: T) {
        var data: T? = data
    }

    private fun createNode(data: Int): Node<Int> {
        return Node(null, null, data)
    }

    fun getRandomTree(cnt: Int): Node<Int> {
        var head = createNode(10)
        var first = head
        for (i in 0..cnt) {
            val r = Utils.getRandom(20)
            println("random:" + r)
            if (r % 2 == 0) {
                var leftChild = createNode(i)
                head.rightNode = leftChild
                head = leftChild
            } else {
                var rightChild = createNode(i)
                head.leftNode = rightChild
                head = rightChild
            }
        }
        return first
    }

    val randomList: ArrayList<Int>
        get() {
            val list = ArrayList<Int>()
            for (i in 0..9) {
                list.add(getRandom(50))
            }
            println(list)
            return list
        }

    fun randomList(size: Int): ArrayList<Int> {
        val list = ArrayList<Int>()
        for (i in 0..size) {
            list.add(getRandom(50))
        }
        println(list)
        return list
    }

    fun getRandom(max: Int): Int {
        return getRandom(0, max)
    }

    /**
     * get random int between min and max
     *
     * @param min
     * @param max
     * @return
     *  * if min > max, return 0
     *  * if min == max, return min
     *  * else return random int between min and max
     *
     */
    fun getRandom(min: Int, max: Int): Int {
        if (min > max) {
            return 0
        }
        return if (min == max) {
            min
        } else min + Random().nextInt(max - min)
    }
}
