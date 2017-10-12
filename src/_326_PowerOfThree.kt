/**
 * Created by hds on 17-10-12.
 */


object _326_PowerOfThree {


    @JvmStatic
    fun main(args: Array<String>) {
        for (i in 0..100)
            println("i:" + i + "," + isPowerOfThree(i))
    }

    //3的幂
    //3^0,3^1,3^2
    private fun isPowerOfThree(data: Int): Boolean {
        if (data < 0) return false
        var n = data
        while (n > 0 && (n % 3 == 0)) {
            n /= 3
        }
        return n == 1
    }
}