package `136`

internal class Solution {
    fun singleNumber(nums: IntArray): Int {
        var n = 0

        for (num in nums) {
            n = n xor num
        }

        return n
    }
}
