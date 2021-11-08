package `35`

//Given a sorted array of distinct integers and a target value, return the
//index if the target is found. If not, return the index where it would be if it were 
//inserted in order. 
//
// You must write an algorithm with O(log n) runtime complexity. 
//
// 
// Example 1: 
// Input: nums = [1,3,5,6], target = 5
//Output: 2
// Example 2: 
// Input: nums = [1,3,5,6], target = 2
//Output: 1
// Example 3: 
// Input: nums = [1,3,5,6], target = 7
//Output: 4
// Example 4: 
// Input: nums = [1,3,5,6], target = 0
//Output: 0
// Example 5: 
// Input: nums = [1], target = 0
//Output: 0
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// nums contains distinct values sorted in ascending order. 
// -10⁴ <= target <= 10⁴ 
// 
// Related Topics 数组 二分查找 👍 1161 👎 0


class Solution {
    fun searchInsert(nums: IntArray, target: Int): Int {
        var l = 0
        var r = nums.lastIndex

        while (l < r) {
            val mid = (l + r) / 2
            if (nums[mid] == target) {
                return mid
            }

            if (nums[mid] > target) {
                r = mid - 1
            } else {
                l = mid + 1
            }
        }
        return if (nums[l] >= target) l else l + 1
    }
}


fun main() {
    println(Solution().searchInsert(intArrayOf(1, 3, 5, 6), 2) == 1)
    println(Solution().searchInsert(intArrayOf(1, 3, 5, 6), 0) == 0)
    println(Solution().searchInsert(intArrayOf(1, 3, 5, 6), 5) == 2)
    println(Solution().searchInsert(intArrayOf(1), 1) == 0)
}
