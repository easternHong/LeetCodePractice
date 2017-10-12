import java.util.HashMap

/**
 * Created by hds on 17-9-27.
 */
object TwoSum {

    @JvmStatic
    fun main(args: Array<String>) {
        val nums = intArrayOf(1, 3, 5, 7, 9)

        val r = twoSum(nums, 16)
        println(r[0].toString() + "," + r[1])
    }

    fun twoSum(nums: IntArray, target: Int): IntArray {
        val result = IntArray(2)
        val map = HashMap<Int, Int>()
        for (i in nums.indices) {
            if (map.containsKey(target - nums[i])) {
                result[1] = i
                result[0] = map.get(target - nums[i])!!
                break
            } else
                map.put(nums[i], i)
        }
        return result
    }
}
