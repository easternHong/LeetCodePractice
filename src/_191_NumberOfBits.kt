/**
 * Created by eastern on 2017/10/12.
 */


//计算一个二进制数中的1的个数。
//大量解法：https://www.cnblogs.com/graphics/archive/2010/06/21/1752421.html
object _191_NumberOfBits{


    @JvmStatic
    fun main(args:Array<String>){
        println(hammingWeight(16))
        println(Integer.toBinaryString(16))
    }

    //时间复杂度  O(32),空间复杂度O(1)
    fun hammingWeight(n: Int): Int {
        var n = n
        var cnt = 0
        while (n > 0) {
            cnt += n and 1
            n = n shr 1
        }
        return cnt
    }
}
