class RomanToInteger {
    fun romanToInt(s: String): Int {
        var roman = s
        var num = 0
        while (roman.isNotBlank()) {
            when {
                roman.startsWith("M") -> {
                    num += 1000
                    roman = roman.substring(1, roman.length)
                }
                roman.startsWith("CM") -> {
                    num += 900
                    roman = roman.substring(2, roman.length)
                }
                roman.startsWith("D") -> {
                    num += 500
                    roman = roman.substring(1, roman.length)
                }
                roman.startsWith("CD") -> {
                    num += 400
                    roman = roman.substring(2, roman.length)
                }
                roman.startsWith("C") -> {
                    num += 100
                    roman = roman.substring(1, roman.length)
                }
                roman.startsWith("XC") -> {
                    num += 90
                    roman = roman.substring(2, roman.length)
                }
                roman.startsWith("L") -> {
                    num += 50
                    roman = roman.substring(1, roman.length)
                }
                roman.startsWith("XL") -> {
                    num += 40
                    roman = roman.substring(2, roman.length)
                }
                roman.startsWith("X") -> {
                    num += 10
                    roman = roman.substring(1, roman.length)
                }
                roman.startsWith("IX") -> {
                    num += 9
                    roman = roman.substring(2, roman.length)
                }
                roman.startsWith("V") -> {
                    num += 5
                    roman = roman.substring(1, roman.length)
                }
                roman.startsWith("IV") -> {
                    num += 4
                    roman = roman.substring(2, roman.length)
                }
                roman.startsWith("I") -> {
                    num += 1
                    roman = roman.substring(1, roman.length)
                }
            }
        }
        return num
    }
}