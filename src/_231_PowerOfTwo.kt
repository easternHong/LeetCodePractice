/**
 * Created by hds on 17-10-12.
 */
object _231_PowerOfTwo {

    @JvmStatic
    fun main(args: Array<String>) {

        for (i in 0..99) {
            println("i:" + i + "," + isPowerOfTwo__(i))
        }
    }

    //计算2进制的1的个数。1:true,other:false;
    private fun isPowerOfTwo(data: Int): Boolean {
        var n = data
        if (n < 0) return false
        var count = 0
        while (n > 0) {
            count += n and 1
            n = n shr 1
        }
        return count == 1
    }

    //技巧如果一个数是2的次方数的话，
    // 根据上面分析，那么它的二进数必然是最高位为1，
    // 其它都为0，那么如果此时我们减1的话，
    // 则最高位会降一位，其余为0的位现在都为变为1，
    // 那么我们把两数相与，就会得到0，用这个性质也能来解题，
    // 而且只需一行代码就可以搞定
    private fun isPowerOfTwo_(n: Int): Boolean {
        return n > 0 && n and n - 1 == 0
    }

    private fun isPowerOfTwo__(n: Int): Boolean {
        var data = n
        while (data > 0 && (data % 2 == 0)) {
            data /= 2
        }
        return data == 1
    }
}
