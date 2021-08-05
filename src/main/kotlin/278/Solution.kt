package `278`

// https://leetcode-cn.com/problems/first-bad-version/
/**
 * 二分查找， 找到第一个函数返回 true 的
 * 注意溢出问题
 */
class Solution: VersionControl() {
    override fun firstBadVersion(n: Int) : Int {
        var l = 1L
        var r: Long = n.toLong()
        while (l < r) {
            val mid = (l + r) / 2
            if (isBadVersion(mid.toInt())) {
                // 为 true 时， 还可能是结果
                r = mid
            } else {
                l = mid + 1
            }
        }
        return l.toInt()
    }
}


abstract class VersionControl {
    fun isBadVersion(version: Int): Boolean {
        return version >= 2
    }

    abstract fun firstBadVersion(n: Int) : Int
}

fun main() {
    println(Solution().firstBadVersion(3))
}