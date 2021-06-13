//https://leetcode.com/problems/reverse-integer/

fun reverse(x: Int): Int {
    var a = Math.abs(x)
    var b = 0
    while (a > 0) {
        if (b <= Integer.MAX_VALUE / 10) {
            b = b * 10 + a % 10
            a /= 10
        } else {
            a = 0
            b = 0
        }
    }
    return if (x > 0) b else -b
}