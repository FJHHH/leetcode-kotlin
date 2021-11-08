package `19`

//Given the head of a linked list, remove the nᵗʰ node from the end of the list
//and return its head. 
//
// 
// Example 1: 
//
// 
//Input: head = [1,2,3,4,5], n = 2
//Output: [1,2,3,5]
// 
//
// Example 2: 
//
// 
//Input: head = [1], n = 1
//Output: []
// 
//
// Example 3: 
//
// 
//Input: head = [1,2], n = 1
//Output: [1]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is sz. 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
//
// 
// Follow up: Could you do this in one pass? 
// Related Topics 链表 双指针 👍 1635 👎 0


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
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        if (head == null) {
            return head
        }

        var l = head
        var r = head
        // l 和 r指针之间包含的node数（包括l和r指向的node）
        var dis = 1

        while (r!!.next != null) {
            r = r.next
            // 大于是为了让l指向倒数第n个node的前一个node
            if (dis > n) {
                l = l!!.next
            } else {
                // 右侧指针先走n-1步
                dis++
            }
        }

        if (dis < n) {
            // 步数没走够，不需要删除节点
            return head
        }

        if (l == head && dis == n) {
            // 刚好是head
            return head.next
        }

        // 跳过l的下一个节点
        l!!.next = l.next?.next
        return head
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}
