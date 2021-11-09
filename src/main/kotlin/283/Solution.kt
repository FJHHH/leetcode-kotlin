package `283`

//Given an integer array nums, move all 0's to the end of it while maintaining
//the relative order of the non-zero elements. 
//
// Note that you must do this in-place without making a copy of the array. 
//
// 
// Example 1: 
// Input: nums = [0,1,0,3,12]
//Output: [1,3,12,0,0]
// Example 2: 
// Input: nums = [0]
//Output: [0]
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁴ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 
//
// 
//Follow up: Could you minimize the total number of operations done? Related 
//Topics 数组 双指针 👍 1291 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun moveZeroes(nums: IntArray): Unit {
        var count = 0

        nums.forEachIndexed { index, num ->
            if (num == 0) {
                count++
            } else {
                nums[index - count] = num
            }

        }

        while(count > 0) {
            nums[nums.size - count] = 0
            count--
        }
    }


    fun moveZeroes2(nums: IntArray): Unit {
        var l = 0
        while (l < nums.size) {
            // 找一个0
            if (nums[l] != 0) {
                l++
                continue
            }

            // 找一个非0
            var r = l + 1

            while (r < nums.size && nums[r] == 0) {
                r++
            }

            if (r >= nums.size) {
                break
            }

            // 非0位移到左侧的0位
            nums[l] = nums[r]
            nums[r] = 0

            l++
        }
    }
}

fun main() {
    val nums = intArrayOf(0, 1, 0, 3, 12)
    Solution().moveZeroes(nums)
    println(nums.joinToString())
}
//leetcode submit region end(Prohibit modification and deletion)
