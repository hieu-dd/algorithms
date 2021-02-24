package model
// https://leetcode.com/problems/add-two-numbers/

class ListNode(var `val`: Int) : Cloneable {
    var next: ListNode? = null
    override fun clone(): ListNode {
        return super.clone() as ListNode
    }
}

fun pushTop(a: ListNode?, `val`: Int): ListNode = ListNode(`val`).apply { next = a }
fun pushBottom(a: ListNode?, `val`: Int): ListNode {
    val bottom = ListNode(`val`)
    if (a == null) return bottom
    else {
        var x = a.next
        if (x == null) a.next = bottom
        else {
            while (x!!.next != null) {
                x = x.next
            }
            x.next = bottom
        }
        return a
    }
}