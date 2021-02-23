// https://leetcode.com/problems/zigzag-conversion/
fun convert(s: String, numRows: Int): String {
    if (numRows == 1) return s
    var chars = s.toCharArray()
    val size = chars.size
    val calCol = (size / (2*numRows - 2)+1) * (numRows - 1)
    val data = mutableListOf<MutableList<String>>()

    for (j in 0 until numRows) {
        val rows = mutableListOf<String>()
        for (i in 0 until calCol) {
            rows.add("")
        }
        data.add(rows)
    }
    var i = 0
    var j = 0
    var index = 0
    var positive = true
    while (index < size) {
        data[j][i] = chars[index].toString()
        index++
        if (i % (numRows - 1) == 0 && j == 0) {
            positive = true
            j++
        } else if (i % (numRows - 1) == 0 && j < numRows-1) {
            j++
        } else if (i % (numRows - 1) == 0 && j == numRows-1) {
            positive = false
            i++
            j--
        } else {
            if (positive) {
                i++
                j++
            } else {
                i++
                j--
            }
        }
    }
    return data.map { it.filter { it.isNotBlank() }.joinToString("") }.joinToString("")
}

fun main() {
    val test = "ABCDE"
    print(convert(test,4))
}

//https://leetcode.com/problems/zigzag-conversion/