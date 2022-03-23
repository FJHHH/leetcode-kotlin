package `415`
//Given two non-negative integers, num1 and num2 represented as string, return
//the sum of num1 and num2 as a string.
//
// You must solve the problem without using any built-in library for handling
//large integers (such as BigInteger). You must also not convert the inputs to
//integers directly.
//
//
// Example 1:
//
//
//Input: num1 = "11", num2 = "123"
//Output: "134"
//
//
// Example 2:
//
//
//Input: num1 = "456", num2 = "77"
//Output: "533"
//
//
// Example 3:
//
//
//Input: num1 = "0", num2 = "0"
//Output: "0"
//
//
//
// Constraints:
//
//
// 1 <= num1.length, num2.length <= 10⁴
// num1 and num2 consist of only digits.
// num1 and num2 don't have any leading zeros except for the zero itself.
//
// Related Topics 数学 字符串 模拟 👍 528 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun addStrings(num1: String, num2: String): String {
        val reversed1 = num1.reversed()
        val reversed2 = num2.reversed()

        var i1 = 0
        var i2 = 0
        var carry = 0
        val sb = StringBuilder()
        while (i1 < reversed1.length && i2 < reversed2.length) {
            val n1 = Integer.valueOf(reversed1[i1].toString())
            val n2 = Integer.valueOf(reversed2[i2].toString())
            var value = n1 + n2 + carry
            carry = value / 10
            value %= 10
            sb.append(value)
            i1++
            i2++
        }

        if (i1 < reversed1.length) {
            while (i1 < reversed1.length) {
                val n1 = Integer.valueOf(reversed1[i1].toString())
                var value = n1 + carry
                carry = value / 10
                value %= 10
                sb.append(value)
                i1++
            }
        }
        if (i2 < reversed2.length) {
            while (i2 < reversed2.length) {
                val n1 = Integer.valueOf(reversed2[i2].toString())
                var value = n1 + carry
                carry = value / 10
                value %= 10
                sb.append(value)
                i2++
            }
        }
        if (carry != 0) {
            sb.append(carry)
        }
        return sb.reversed().toString()
    }
}
//leetcode submit region end(Prohibit modification and deletion)
