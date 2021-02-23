import model.ListNode
import model.pushBottom
import model.pushTop
// https://leetcode.com/problems/merge-two-sorted-lists/

fun main() {
    var a = ListNode(15)
    a = pushTop(a, 10)
    a = pushTop(a, 5)
    var b = ListNode(20)
    b = pushTop(b, 15)
    b = pushTop(b, 2)
    val result = mergeTwoLists(a, b)
    print(result)

}

fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    var result: ListNode? = null
    var temp1 = list1
    var temp2 = list2
    while (temp1 != null || temp2 != null) {
        if (temp1 == null) {
            result = pushBottom(result, temp2!!.`val`)
            temp2 = temp2.next
        } else if (temp2 == null) {
            result = pushBottom(result, temp1!!.`val`)
            temp1 = temp1.next
        } else {
            if (temp1.`val` < temp2.`val`) {
                result = pushBottom(result, temp1.`val`)
                temp1 = temp1.next
            } else {
                result = pushBottom(result, temp2.`val`)
                temp2 = temp2.next
            }
        }
    }
    return result
}