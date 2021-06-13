import model.ListNode
import model.pushTop

fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
    var left: ListNode? = head
    var right: ListNode? = head
    var count = n
    while (count > 0) {
        right = right?.next
        count--
    }
    if (right == null) {
        return head?.next
    }
    while (right?.next != null) {
        right = right.next
        left = left?.next
    }
    left?.next = left?.next?.next
    return head
}

fun main() {
    var a = ListNode(4)
    a = pushTop(a, 3)
    a = pushTop(a, 2)
    a = pushTop(a, 1)
    a = pushTop(a, 0)
    val result = removeNthFromEnd(a, 1)
    print(result)
}