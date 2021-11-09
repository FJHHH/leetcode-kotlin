package `344`

//Write a function that reverses a string. The input string is given as an
//array of characters s. 
//
// 
// Example 1: 
// Input: s = ["h","e","l","l","o"]
//Output: ["o","l","l","e","h"]
// Example 2: 
// Input: s = ["H","a","n","n","a","h"]
//Output: ["h","a","n","n","a","H"]
// 
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10⁵ 
// s[i] is a printable ascii character. 
// 
//
// 
// Follow up: Do not allocate extra space for another array. You must do this 
//by modifying the input array in-place with O(1) extra memory. 
// Related Topics 递归 双指针 字符串 👍 480 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun reverseString(s: CharArray): Unit {
        if (s.isEmpty()) {
            return
        }
        var l = 0
        var r = s.lastIndex

        while (l < r) {
            val tmp = s[l]
            s[l] = s[r]
            s[r] = tmp
            l++
            r--
        }
    }
}

fun main() {
    val chars = charArrayOf('h', 'e', 'l', 'l', 'o')
    Solution().reverseString(chars)
    println(chars)
}
//leetcode submit region end(Prohibit modification and deletion)
