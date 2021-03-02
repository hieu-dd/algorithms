// https://leetcode.com/problems/merge-k-sorted-lists/submissions/

import model.ListNode
import model.pushBottom
import model.pushTop
import java.lang.Integer.MAX_VALUE

fun main() {
    var a = ListNode(15)
    a = pushTop(a, 10)
    a = pushTop(a, 5)
    var b = ListNode(20)
    b = pushTop(b, 15)
    b = pushTop(b, 2)
    val result = mergeKLists(arrayOf(a, b))
    print(result)
}

fun mergeKLists(lists: Array<ListNode?>): ListNode? {
    var result: ListNode? = null
    var listNotNull: MutableList<ListNode?> = lists.filterNotNull().toMutableList()
    while (listNotNull.any { it != null }) {
        var indexOnMin = 0
        var min = MAX_VALUE
        listNotNull = listNotNull.filterNotNull().toMutableList()
        listNotNull.forEachIndexed { index, listNode ->
            if (listNode!!.`val` < min) {
                min = listNode.`val`
                indexOnMin = index
            }
        }
        result = pushBottom(result, min)
        listNotNull[indexOnMin] = listNotNull[indexOnMin]!!.next
    }
    return result
}