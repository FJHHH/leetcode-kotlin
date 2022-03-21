package `653`

/**
 * Example:
 * var ti = `653`.TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class `653`.TreeNode(var `val`: Int) {
 *     var left: `653`.TreeNode? = null
 *     var right: `653`.TreeNode? = null
 * }
 */
class Solution {
    fun findTarget(root: TreeNode?, k: Int): Boolean {
        val values = ArrayList<Int>()
        dfs(root, values)
        if (values.size < 2) {
            return false
        }
        println(values)

        var left = 0
        var right = values.lastIndex

        while (left < right) {
            val sum = values[left] + values[right]
            if (sum == k) {
                return true
            }
            if (sum > k) {
                right--
            } else{
                left++
            }
        }
        return false
    }

    private fun dfs(root: TreeNode?, values: ArrayList<Int>) {
        if (root == null) {
            return
        }

        dfs(root.left, values)
        values.add(root.`val`)
        dfs(root.right, values)
    }
}

fun main() {
    println(Solution().findTarget(TreeNode(5), 5))
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}