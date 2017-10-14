package adt.utils

import java.util.*

/**
 * Created by hds on 17-10-14.
 */
object Utils {


    val randomList: ArrayList<Int>
        get() {
            val list = ArrayList<Int>()
            for (i in 0..9) {
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
