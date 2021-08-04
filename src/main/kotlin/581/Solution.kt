package `581`

// https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/
class Solution {
    fun findUnsortedSubarray(nums: IntArray): Int {
        var maxNumber = Int.MIN_VALUE
        var l = -1
        var r = -1
        var minNumber = Int.MAX_VALUE
        for ((index, num) in nums.withIndex()) {
            if (num < maxNumber) {
                r = index
            } else {
                maxNumber = Math.max(maxNumber, num)
            }
            if (l != -1) {
                minNumber = Math.min(minNumber, num)
            }
        }

        // 向左，直到找到小于或等于 minNumber 的
        if (l != -1) {
            while(l > 0 && nums[l-1] > minNumber) {
                l--
            }
        }
        return if (r == l) 0 else r - l + 1
    }
}