import model.ListNode
import model.pushBottom
import model.pushTop

fun main() {
    var a = ListNode(9)
    a = pushTop(a, 9)
    a = pushTop(a, 1)
    var b = ListNode(9)

    val result = addTwoNumbers(a, b)
    print(result)
}

fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    var result: ListNode? = null
    var temp1 = l1
    var temp2 = l2
    var addition = 0
    while (temp1 != null || temp2 != null || addition > 0) {
        val sum = (temp1?.`val` ?: 0) + (temp2?.`val` ?: 0) + addition
        val `val` = sum % 10
        addition = sum / 10
        result = pushBottom(result, `val`)
        temp1 = temp1?.next
        temp2 = temp2?.next
    }
    return result
}




