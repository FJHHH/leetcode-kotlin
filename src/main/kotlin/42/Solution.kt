package `42`

// https://leetcode-cn.com/problems/trapping-rain-water/

class Solution {
    fun trap(height: IntArray): Int {
        if (height.isEmpty()) {
            return 0
        }
        var l = 0
        var r = height.lastIndex


        while (height[l] == 0 && l < r) {
            ++l
        }

        while (height[r] == 0 && r > l) {
            --r
        }

        var maxL = height[l]
        var maxR = height[r]

        var sum = 0

        while(l < r) {
            if (height[l] <= height[r]) {
                sum += maxL - height[l]
                l++
                if (height[l] > maxL) {
                    maxL = height[l]
                }
            } else {
                sum += maxR - height[r]
                r--
                if (height[r] > maxR) {
                    maxR = height[r]
                }
            }
        }

        return sum
    }
}