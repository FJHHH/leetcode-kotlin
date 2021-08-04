package `704`

// https://leetcode-cn.com/problems/binary-search/

class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var l = 0
        var r = nums.lastIndex

        while (l <= r) {
            val mid = (l + r) / 2
            val midNum = nums[mid]
            if (midNum == target) {
                return mid
            }
            if (midNum < target) {
                l = mid + 1
            } else {
                r = mid - 1
            }
        }
        if (nums[l] == target) {
            return l
        }
        if (nums[r] == target) {
            return r
        }
        return -1
    }
}

fun main() {
    println(Solution().search(intArrayOf(-1, 0, 3, 5, 9, 12), 9))
}