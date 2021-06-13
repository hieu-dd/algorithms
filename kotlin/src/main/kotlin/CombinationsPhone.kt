// https://leetcode.com/problems/letter-combinations-of-a-phone-number/

val hashLetters = hashMapOf(
    Pair("2", listOf("a", "b", "c")),
    Pair("3", listOf("d", "e", "f")),
    Pair("4", listOf("g", "h", "i")),
    Pair("5", listOf("j", "k", "l")),
    Pair("6", listOf("m", "n", "o")),
    Pair("7", listOf("p", "q", "r", "s")),
    Pair("8", listOf("t", "u", "v")),
    Pair("9", listOf("w", "x", "y", "z"))
)

fun letterCombinations(digits: String): List<String> {
    var s = digits
    if (s.isNotBlank()) {
        var first = s.substring(0, 1)
        val result = mutableListOf<String>()
        val letters = hashLetters[first]
        letters!!.forEach { letter ->
            val con = letterCombinations(s.substring(1, s.length))
            if (con.isEmpty()) {
                result.addAll(listOf(letter))
            } else {
                con.forEach {

                    result.add(
                        letter + it
                    )
                }
            }
        }
        return result
    } else return emptyList()
}

fun main() {
    val a = letterCombinations("234")
    print(a)
}