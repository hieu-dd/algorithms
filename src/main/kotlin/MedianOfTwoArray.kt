fun main(args: Array<String>) {
    val a: IntArray = intArrayOf(6,8)
    val b: IntArray = intArrayOf(1,2,3,4,5,7)
    if (b.isEmpty() || (a.isNotEmpty() &&a[a.lastIndex] > b[b.lastIndex])) {
        test(b,a)
    } else {
        test(a,b)
    }
    val result = test(a, b)
    print(result)
}

fun test(nums1: IntArray, nums2: IntArray): Double {
    var median: Double
    val m = nums1.size
    val n = nums2.size
    val half = (m + n + 1) / 2
    val isEven = (m + n) % 2 == 1
    var l1 = 0
    var l2 = 0
    var r1 = (m + 1) / 2 - 1
    var r2 = minOf(maxOf(-1, half - (r1 - l1 + 1) - 1), n - 1)
    var maxR = m
    test@ while ((r1 < m && r1 > -1 && r2 < n - 1 && nums1[r1] > nums2[r2 + 1]) || (r2 < n && r2 > -1 && r1 < m - 1 && nums2[r2] > nums1[r1 + 1])) {
        if (r1 > -1 && r2 < n - 1 && nums1[r1] > nums2[r2 + 1]) {
            maxR = r1
            r1 = if (r1 == 0) -1 else r1 / 2
        } else if (r2 > -1 && r1 < m - 1 && nums2[r2] > nums1[r1 + 1]) {
            r1 = (maxR - r1) / 2 + r1
        }
        r2 = minOf(maxOf(-1, half - (r1 - l1 + 1) - 1), n - 1)
    }

    if (isEven) {
        median = when {
            r1 >= half - 1 -> nums1[half - 1].toDouble()
            r2 >= half - 1 -> nums2[r2].toDouble()
            else -> maxOf(nums1[r1], nums2[r2]).toDouble()
        }
    } else {
        median = when {
            r2 < 0 && r1 < m - 1 -> {
                val min = if (n == 0) nums1[half] else minOf(
                    nums1[half],
                    nums2[r2 + 1]
                )
                (nums1[half-1] + min).toDouble() / 2
            }
            r2 < 0 && r1 == m - 1 -> (nums1[r1] + nums2[0]).toDouble() / 2
            r1 < 0 && r2 < n - 1 -> {
                val min = if (m == 0) nums2[r2 + 1] else minOf(
                    nums1[r1 + 1],
                    nums2[r2 + 1]
                )
                (nums2[r2] + min).toDouble() / 2
            }
            r1 < 0 && r2 == n - 1 -> (nums2[r2] + nums1[0]).toDouble() / 2

            else -> {
                val min = if (r1 == m - 1) nums2[r2 + 1] else if (r2 == n - 1) nums1[r1 + 1] else minOf(
                    nums1[r1 + 1],
                    nums2[r2 + 1]
                )
                (maxOf(nums1[r1], nums2[r2]) + min).toDouble() / 2
            }
        }
//        median = (maxOf(nums1[r1], nums2[r2]) + minOf(nums1[r1 + 1], nums2[r2 + 1])).toDouble() / 2
    }

    return median
}