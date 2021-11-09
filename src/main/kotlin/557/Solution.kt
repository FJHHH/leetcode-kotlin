package `557`

//Given a string s, reverse the order of characters in each word within a
//sentence while still preserving whitespace and initial word order. 
//
// 
// Example 1: 
// Input: s = "Let's take LeetCode contest"
//Output: "s'teL ekat edoCteeL tsetnoc"
// Example 2: 
// Input: s = "God Ding"
//Output: "doG gniD"
// 
// 
// Constraints: 
//
// 
// 1 <= s.length <= 5 * 10⁴ 
// s contains printable ASCII characters. 
// s does not contain any leading or trailing spaces. 
// There is at least one word in s. 
// All the words in s are separated by a single space. 
// 
// Related Topics 双指针 字符串 👍 358 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun reverseWords(s: String): String {
        if (s.isBlank()) {
            return s
        }
        val chars = s.toCharArray()
        var l = 0
        while (l < chars.size) {
            if (chars[l] == ' ') {
                l++
                continue
            }

            var r = l + 1
            while (r < chars.size && chars[r] != ' ') {
                r++
            }

            reverseWords(chars, l , if (r < chars.size) r - 1 else chars.lastIndex)
            l = r + 1
        }
        return String(chars)
    }

    private fun reverseWords(chars: CharArray, l: Int, r: Int) {
        var ll = l
        var rr = r
        while (ll < rr) {
            val tmp = chars[ll]
            chars[ll] = chars[rr]
            chars[rr] = tmp
            ll++
            rr--
        }
    }
}

fun main() {
    println(Solution().reverseWords("Let's take LeetCode contest") == "s'teL ekat edoCteeL tsetnoc")
    println(Solution().reverseWords("God Ding") == "doG gniD")
    println(Solution().reverseWords("") == "")
}
//leetcode submit region end(Prohibit modification and deletion)
