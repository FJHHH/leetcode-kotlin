package `495`

//Our hero Teemo is attacking an enemy Ashe with poison attacks! When Teemo
//attacks Ashe, Ashe gets poisoned for a exactly duration seconds. More formally, an 
//attack at second t will mean Ashe is poisoned during the inclusive time interval 
//[t, t + duration - 1]. If Teemo attacks again before the poison effect ends, 
//the timer for it is reset, and the poison effect will end duration seconds after 
//the new attack. 
//
// You are given a non-decreasing integer array timeSeries, where timeSeries[i] 
//denotes that Teemo attacks Ashe at second timeSeries[i], and an integer 
//duration. 
//
// Return the total number of seconds that Ashe is poisoned. 
//
// 
// Example 1: 
//
// 
//Input: timeSeries = [1,4], duration = 2
//Output: 4
//Explanation: Teemo's attacks on Ashe go as follows:
//- At second 1, Teemo attacks, and Ashe is poisoned for seconds 1 and 2.
//- At second 4, Teemo attacks, and Ashe is poisoned for seconds 4 and 5.
//Ashe is poisoned for seconds 1, 2, 4, and 5, which is 4 seconds in total.
// 
//
// Example 2: 
//
// 
//Input: timeSeries = [1,2], duration = 2
//Output: 3
//Explanation: Teemo's attacks on Ashe go as follows:
//- At second 1, Teemo attacks, and Ashe is poisoned for seconds 1 and 2.
//- At second 2 however, Teemo attacks again and resets the poison timer. Ashe 
//is poisoned for seconds 2 and 3.
//Ashe is poisoned for seconds 1, 2, and 3, which is 3 seconds in total. 
//
// 
// Constraints: 
//
// 
// 1 <= timeSeries.length <= 10⁴ 
// 0 <= timeSeries[i], duration <= 10⁷ 
// timeSeries is sorted in non-decreasing order. 
// 
// Related Topics 数组 模拟 👍 174 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun findPoisonedDuration(timeSeries: IntArray, duration: Int): Int {
        if (timeSeries.isEmpty()) {
            return 0
        }
        var total = 0
        // 中毒的最后一秒
        // 攻击会从 0 秒开始， 因此在攻击开始前，中毒的最后一秒初始化为-1
        var final = -1

        timeSeries.forEach {
            total += duration
            if (it <= final) {
                total -= final - it + 1
            }
            final = it + duration - 1
        }
        return total
    }
}

fun main() {
    println(Solution().findPoisonedDuration(intArrayOf(1, 4), 2) == 4)
    println(Solution().findPoisonedDuration(intArrayOf(1, 2), 2) == 3)
    println(Solution().findPoisonedDuration((0..500).toList().toIntArray(), 1) == 501)
    println(Solution().findPoisonedDuration((0..1).toList().toIntArray(), 2) == 3)
}
//leetcode submit region end(Prohibit modification and deletion)
