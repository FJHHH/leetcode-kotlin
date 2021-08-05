package `611`

// https://leetcode-cn.com/problems/valid-triangle-number/
/**
 * a + b > c && a + c > b && b + c > a
 */
class Solution {
    fun triangleNumber(nums: IntArray): Int {
        nums.sort()
        var n = 0
        for ((l, numl) in nums.withIndex()) {
            var r = nums.lastIndex
            while (r > l) {
                var m = l + 1
                while (m in (l + 1) until r) {
                    if (valid(numl, nums[m], nums[r])) {
                        n++
                    }
                    m++
                }
                r--
            }
        }
        return n
    }

    fun valid(a: Int, b: Int, c: Int): Boolean {
        return a + b > c && a + c > b && b + c > a
    }
}