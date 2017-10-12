/**
 * Created by hds on 17-10-12.
 */

object _342_PowerOfFour {


    @JvmStatic
    fun main(args: Array<String>) {
        for (i in 0..100)
            println("i:" + i + "," + isPowerOfFour(i))
    }

    //4的幂
    //4^0,4^1,4^2
    private fun isPowerOfFour(data: Int): Boolean {
        if (data < 0) return false
        var n = data
        while (n > 0 && (n % 4 == 0)) {
            n /= 4
        }
        return n == 1
    }
}