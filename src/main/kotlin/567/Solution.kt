package `567`

//Given two strings s1 and s2, return true if s2 contains a permutation of s1,
//or false otherwise. 
//
// In other words, return true if one of s1's permutations is the substring of 
//s2. 
//
// 
// Example 1: 
//
// 
//Input: s1 = "ab", s2 = "eidbaooo"
//Output: true
//Explanation: s2 contains one permutation of s1 ("ba").
// 
//
// Example 2: 
//
// 
//Input: s1 = "ab", s2 = "eidboaoo"
//Output: false
// 
//
// 
// Constraints: 
//
// 
// 1 <= s1.length, s2.length <= 10⁴ 
// s1 and s2 consist of lowercase English letters. 
// 
// Related Topics 哈希表 双指针 字符串 滑动窗口 👍 486 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun checkInclusion(s1: String, s2: String): Boolean {
        if (s2.length < s1.length) {
            return false
        }

        val size = s1.length
        var l = 0
        var r = l + size
        val expectSet = s1.toList().sorted()

        while (r <= s2.length) {
            // leetcode 的 kotlin版本不够新
//            val set = s2.toCharArray(l, r).toHashSet()
            val set = s2.substring(l, r).toList().sorted()
            if (expectSet == set) {
                return true
            }
            l++
            r++
        }
        return false
    }
}

fun main() {
    println(Solution().checkInclusion("ab", "eidbaooo"))
    println(Solution().checkInclusion("ab", "eidboaoo"))
    println(Solution().checkInclusion("adc", "dcda"))
    println(Solution().checkInclusion("hello", "ooolleoooleh"))
}
//leetcode submit region end(Prohibit modification and deletion)
