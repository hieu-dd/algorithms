// https://leetcode.com/problems/3sum

fun threeSum(a: IntArray): List<List<Int>> {
    var result = mutableListOf<List<Int>>()
    val hash: HashMap<Int, Int> = hashMapOf()
    a.forEach {
        if (hash[it] == null) hash[it] = 1
        else hash[it] = hash[it]!!.plus(1)
    }

    val keys = hash.keys.toList().sorted()

    for (i in 0 until keys.size) {
        var j = i + 1
        val key = keys[i]
        val value: Int = hash[key]!!
        if (value >= 3 && key == 0) {
            result.add(listOf(0, 0, 0))
        }
        if (key != 0 && value >= 2 && (hash[0 - key * 2] ?: 0 >= 1)) {
            result.add(listOf(key, key, 0 - key * 2))
        }
        while (j <= keys.size - 1) {
            val target = 0 - key - keys[j]
            if (target > keys[j] && hash[target] ?: 0 >= 1) {
                result.add(listOf(key, keys[j], target))
            }
            j++
        }
    }
    return result
}