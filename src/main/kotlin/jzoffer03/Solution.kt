package jzoffer03
//English description is not available for the problem. Please switch to
//Chinese.
// Related Topics 数组 哈希表 排序 👍 785 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun findRepeatNumber(nums: IntArray): Int {
        val intSet = hashSetOf<Int>()
        for (num in nums) {
            if (!intSet.add(num)) {
                return num
            }
        }
        return -1
    }
}
//leetcode submit region end(Prohibit modification and deletion)
