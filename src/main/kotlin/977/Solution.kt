package `977`

//Given an integer array nums sorted in non-decreasing order, return an array
//of the squares of each number sorted in non-decreasing order. 
//
// 
// Example 1: 
//
// 
//Input: nums = [-4,-1,0,3,10]
//Output: [0,1,9,16,100]
//Explanation: After squaring, the array becomes [16,1,0,9,100].
//After sorting, it becomes [0,1,9,16,100].
// 
//
// Example 2: 
//
// 
//Input: nums = [-7,-3,2,3,11]
//Output: [4,9,9,49,121]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// nums is sorted in non-decreasing order. 
// 
//
// 
//Follow up: Squaring each element and sorting the new array is very trivial, 
//could you find an O(n) solution using a different approach? Related Topics 数组 双指针 
//排序 👍 342 👎 0


class Solution {
    fun sortedSquares(nums: IntArray): IntArray {
        var l = 0
        var r = nums.lastIndex
        val result = IntArray(nums.size)
        var index = r

        while (l <= r) {
            val sl = nums[l] * nums[l]
            val sr = nums[r] * nums[r]
            if (sl > sr) {
                result[index] = sl
                l++
            } else {
                result[index] = sr
                r--
            }
            index--
        }

        return result
    }
}


fun main() {
    println(Solution().sortedSquares(intArrayOf(-4, -1, 0, 3, 10)).joinToString())
    println(Solution().sortedSquares(intArrayOf(1)).joinToString())
}
