//https://leetcode.com/problems/longest-substring-without-repeating-characters/

fun lengthOfLongestSubstring(s: String): Int {
    var chars = s.toCharArray()
    val maxLength = chars.size
    var max = 0
    var right = 0
    var left = 0
    val mapData = hashMapOf<Char, Int>()
    while (right < maxLength ) {
        when {
            mapData.getOrDefault(chars[right], 0) == 0 -> {
                max = max.coerceAtLeast(right - left + 1)
                mapData[chars[right]] = 1
                right++
            }
            chars[left] == chars[right] -> {
                left++
                right++
            }
            else -> {
                mapData[chars[left]] = 0
                left++
            }
        }
    }
    return max
}

fun main(args: Array<String>) {
    val input = "tmmzuxt"
    val result = lengthOfLongestSubstring(input)
    println(result)
}