// https://leetcode.com/problems/integer-to-roman/

class IntegerToRoman {
    fun intToRoman(num: Int): String {
        val stringBuilder = StringBuilder()
        var n = num
        while (n > 0) {
            when {
                n >= 1000 -> {
                    stringBuilder.append("M")
                    n -= 1000
                }
                n >= 900 -> {
                    stringBuilder.append("CM")
                    n -= 900
                }
                n >= 500 -> {
                    stringBuilder.append("D")
                    n -= 500
                }
                n >= 400 -> {
                    stringBuilder.append("CD")
                    n -= 400
                }
                n >= 100 -> {
                    stringBuilder.append("C")
                    n -= 100
                }
                n >= 90 -> {
                    stringBuilder.append("XC")
                    n -= 90
                }
                n >= 50 -> {
                    stringBuilder.append("L")
                    n -= 50
                }
                n >= 40 -> {
                    stringBuilder.append("XL")
                    n -= 40
                }
                n >= 10 -> {
                    stringBuilder.append("X")
                    n -= 10
                }
                n >= 9 -> {
                    stringBuilder.append("IX")
                    n -= 9
                }
                n >= 5 -> {
                    stringBuilder.append("V")
                    n -= 5
                }
                n >= 4 -> {
                    stringBuilder.append("IV")
                    n -= 4
                }
                n >= 1 -> {
                    stringBuilder.append("I")
                    n -= 1
                }
            }
        }
        return stringBuilder.toString()
    }
}