package test

import java.util.*

/**
 * Created by eastern on 2017/10/15.
 */
object Test {


    @JvmStatic
    fun main(args: Array<String>) {

        for (i in 0..9)
            println(getString()?.length)

    }

    fun getString(): String? {
        val r = Random().nextInt() % 2
        if (r == 0) return null
        return "" + r
    }


}
