package `231`

//Given an integer n, return true if it is a power of two. Otherwise, return
//false. 
//
// An integer n is a power of two, if there exists an integer x such that n == 2
//ˣ. 
//
// 
// Example 1: 
//
// 
//Input: n = 1
//Output: true
//Explanation: 2⁰ = 1
// 
//
// Example 2: 
//
// 
//Input: n = 16
//Output: true
//Explanation: 2⁴ = 16
// 
//
// Example 3: 
//
// 
//Input: n = 3
//Output: false
// 
//
// Example 4: 
//
// 
//Input: n = 4
//Output: true
// 
//
// Example 5: 
//
// 
//Input: n = 5
//Output: false
// 
//
// 
// Constraints: 
//
// 
// -2³¹ <= n <= 2³¹ - 1 
// 
//
// 
//Follow up: Could you solve it without loops/recursion? Related Topics 位运算 递归 数
//学 👍 426 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun isPowerOfTwo(n: Int): Boolean {
        var c = 30
        var num = 1
        while (c-- > 0 && num <= n) {
            if (n xor num == 0) {
                return true
            }
            num = num shl 1
        }
        return n xor num == 0
    }
}

fun main() {
    println(Solution().isPowerOfTwo(1))
    println(!Solution().isPowerOfTwo(3))
}
//leetcode submit region end(Prohibit modification and deletion)
