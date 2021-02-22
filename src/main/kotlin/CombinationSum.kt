fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
    var result = listOf<List<Int>>()
    for (i in candidates.indices) {
        val dataFind = candidates.toMutableList().subList(i, candidates.size).toIntArray()
        result = result + findOneCombination(dataFind, target)
    }
    return result
}

fun findOneCombination(candidates: IntArray, target: Int): List<List<Int>> {
    val first = candidates.firstOrNull()
    if (first == null) return listOf(listOf())
    else if (first > target) return listOf(listOf())
    else if (first == target) return listOf(listOf(candidates.first()))
    else {
        val result = mutableListOf<List<Int>>()
        var i = 1
        val data = mutableListOf<Int>()
        while ((i * first) <= target) {
            data.add(first)
            val newCans =
                if (candidates.size == 1) intArrayOf() else candidates.toMutableList().subList(1, candidates.size)
                    .toIntArray()
            val r = (data + findOneCombination(newCans, target - i * first))
            result.add(r as List<Int>)
            print(i)
            i++
        }
        return result
    }

}

fun main() {
    val data = intArrayOf(2, 3, 5)
    val result = combinationSum(data, 8)
    print(result)
}