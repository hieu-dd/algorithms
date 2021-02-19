fun main() {
    val k = 2
    val mat: Array<IntArray> = arrayOf(
        intArrayOf(1, 0, 0, 0),
        intArrayOf(1, 1, 1, 1),
        intArrayOf(1, 0, 0, 0),
        intArrayOf(1, 0, 0, 0)
    )
    val result = kWeakestRows(mat, k)
    for (i in 0 until k) {
        println(result[i])
    }
}

fun kWeakestRows(mat: Array<IntArray>, k: Int): IntArray {
    return mat.mapIndexed { index, ints -> intArrayOf(index, ints.sumBy { i -> i }) }.sortedBy { it[1] }.subList(0, k).map { it[0] }.toIntArray()
}