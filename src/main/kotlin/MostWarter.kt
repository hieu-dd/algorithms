//https://leetcode.com/problems/container-with-most-water/
fun maxArea(height: IntArray): Int {
    // max of max(a[i],a[j])*(j-i)
    var max = 0
    for (i in 0 until height.size - 1) {
        for (j in i + 1 until height.size) {
            max = maxOf(max, minOf(height[i], height[j]) * (j - i))
        }
    }
    return max

}