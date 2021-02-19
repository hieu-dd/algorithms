import java.lang.Integer.MAX_VALUE

fun reverse(x: Int): Int {
    var a = Math.abs(x)
    var b = 0
    while (a > 0) {
        if (b <= MAX_VALUE / 10) {
            b = b * 10 + a % 10
            a /= 10
        } else {
            a = 0
            b = 0
        }
    }
    return if (x > 0) b else -b
}

fun main(args: Array<String>) {
    val data = 1534236469
    val result = reverse(data)
    print(result)
}