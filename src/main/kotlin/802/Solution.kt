package `802`

// https://leetcode-cn.com/problems/find-eventual-safe-states/
/**
 * 1. 深度优先遍历，有环说明节点是不安全，否则是安全的
 * 2. 如果下一步能到达的节点都安全， 当前节点安全
 * 3. 如果下一步能到达不安全的节点， 当前节点不安全
 */
class Solution {
    fun eventualSafeNodes(graph: Array<IntArray>): List<Int> {
        // 对应位置值为 0 未判断 为 1 安全 为 -1 已在当前路径遍历过或不安全
        val nodes = IntArray(graph.size)
        return (graph.indices).filter {
            isSafe(it, graph, nodes)
        }
    }

    private fun isSafe(node: Int, graph: Array<IntArray>, nodes: IntArray): Boolean {
        if (nodes[node] == 1) {
            return true
        } else if (nodes[node] == -1) {
            return false
        }

        nodes[node] = -1
        var safe = true
        for (nextNode in graph[node]) {
            if (!isSafe(nextNode, graph, nodes)) {
                safe = false
                break
            }
        }

        if (safe) {
            nodes[node] = 1
        }

        return safe
    }
}