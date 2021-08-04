package `25`

// https://leetcode-cn.com/problems/reverse-nodes-in-k-group/

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        if (k == 1 || head == null) return head
        var newHead: ListNode? = null
        var lPre: ListNode? = null
        var l: ListNode? = head
        var r = l
        var c = 1
        while (r?.next != null) {
            r = r.next
            c++
            if (c >= k) {
                // 翻转 l 到 r 的 k 个节点

                if (lPre == null) {
                    newHead = r
                } else {
                    lPre.next = r
                }

                val tmpRNext = r!!.next

                reverse(l!!, r)

                l.next = tmpRNext

                lPre = l
                l = l.next
                r = l
                c = 1
            }
        }

        return newHead
    }

    fun reverse(head: ListNode, tail: ListNode) {
        var newH: ListNode = head
        var newHeader = head
        newH = newH.next!!
        while (newH != tail) {
            val next = newH.next!!
            newH.next = newHeader
            newHeader = newH
            newH = next
        }
        tail.next = newHeader
    }
}

class ListNode(var `val`: Int) { var next: ListNode? = null }