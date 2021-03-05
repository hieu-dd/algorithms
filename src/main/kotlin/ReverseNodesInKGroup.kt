import model.ListNode
import model.pushBottom
import model.pushTop

fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
    var result: ListNode? = null
    var count = 1
    var size = 0
    val hashVal = hashMapOf<Int, Int>()
    var temp = head
    while (temp != null) {
        hashVal[count] = temp.`val`
        count++
        temp = temp.next
    }
    size = count - 1
    count = 1
    while (count <= size) {
        val surplus = count % k
        if (surplus == 0) {
            result = pushBottom(result, hashVal[count - k + 1]!!)
        } else if (count - surplus + k <= size) {
            result = pushBottom(result, hashVal[count - 2 * surplus + k + 1]!!)
        } else {
            result = pushBottom(result, hashVal[count]!!)
        }
        count++
    }
    return result
}

fun main() {
    var a = ListNode(4)
    a = pushTop(a, 3)
    a = pushTop(a, 2)
    a = pushTop(a, 1)
    val result = reverseKGroup(a, 4)
    print(result)
}