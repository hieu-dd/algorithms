// https://leetcode.com/problems/longest-palindromic-substring/
fun longestPalindrome(s: String): String {
    if (s.isBlank()) return s
    var data = s.toCharArray()
    var palindrome: String = data[0].toString()
    var max = 1
    for (i in 1 until data.size) {
        var isEven = true
        var y = 1
        while (isEven && i - y >= 0 && i + y <= data.size && data[i + y - 1] == data[i - y]) {
            if (y * 2 > max) {
                max = y * 2
                palindrome = s.substring(i - y, i + y)
            }
            y++
        }
        y = 1
        isEven = false
        while (i - y >= 0 && i + y < data.size && data[i - y] == data[i + y]) {
            if (y * 2 + 1 > max) {
                max = y * 2 + 1
                palindrome = s.substring(i - y, i + y + 1)
            }
            y++

        }
    }
    return palindrome
}
fun main(args: Array<String>) {
    val data = "cbbd"
    val result = longestPalindrome(data)
    print(result)
}