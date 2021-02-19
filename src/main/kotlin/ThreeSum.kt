fun threeSum(a: IntArray): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    val nums = a.sortedBy { it }
    var i = 0
    var j = 0
    while (i > -1 && i <= nums.size - 2 && j <= nums.size - 2) {
        j++
        if (nums[i] == 0 && nums[j] == 0 && j < nums.size - 1) {
            if (nums[j + 1] == 0) result.add(listOf(0, 0, 0))
            i = nums.indexOfLast { it == 0 }
            j = i
        } else if (nums[i] == nums[j] && nums[i] != 0) {
            nums.find { it == 0 - nums[i] * 2 }?.let {
                result.add(listOf(nums[i], nums[i], it))
            }
            i = nums.indexOfLast { it == nums[i] }
            j = i
        } else if (nums[i] != nums[j]) {
            nums.find { it > nums[j] && it == 0 - nums[i] - nums[j] }?.let {
                result.add(listOf(nums[i], nums[j], it))
            }
            j = nums.indexOfLast { it == nums[j] }
            if (j >= nums.size - 2) {
                i = nums.indexOfLast { it == nums[i] } + 1
                j = i
            }
        }
    }
    return result
}

// can update

fun main() {
    val data = intArrayOf(-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6)
    print(threeSum(data))
}