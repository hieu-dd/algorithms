// https://leetcode.com/problems/two-sum/

fun twoSum(nums: IntArray, target: Int): IntArray {
    var result = intArrayOf(0, 0)
    test@ for (i in 0 until nums.size - 1) {
        for (j in i + 1 until nums.size) {
            if (nums[i] + nums[j] == target) {
                result = intArrayOf(i, j)
                break@test
            }
        }
    }
    return result

}

fun main() {
    val data = intArrayOf(3, 3)
    val result = twoSum(data, 6)
    print(result)
}