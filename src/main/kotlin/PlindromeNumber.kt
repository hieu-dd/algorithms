// https://leetcode.com/problems/palindrome-number/
fun isPalindrome(x: Int): Boolean {
    if (x < 0) return false
    else {
        var chars = x.toString().toCharArray()
        var i = 0
        var j = chars.size - 1
        var result = true
        while (i <= j) {
            if (chars[i] == chars[j]) {
                i++
                j--
            } else {
                result = false
                break
            }
        }
        return result
    }
}