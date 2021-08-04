package `146`

class LRUCache(val capacity: Int) {
    private var size = 0
    private var map = HashMap<Int, CacheNode>(capacity)
    private val head: CacheNode = CacheNode(-1, -1, null, null)
    private val tail: CacheNode = CacheNode(-1, -1, head, null)

    init {
        head.next = tail
    }

    fun get(key: Int): Int {
        if (size == 0) {
            return -1
        }
        val cacheNode = map[key] ?: return -1
        moveToTop(cacheNode)
        return cacheNode.value
    }

    fun put(key: Int, value: Int) {
        var cacheNode = map[key]
        if (cacheNode != null) {
            cacheNode.value = value
            moveToTop(cacheNode)
            return
        }

        cacheNode = CacheNode(key, value, head, head.next)
        head.next = cacheNode
        cacheNode.next?.pre = cacheNode
        map[key] = cacheNode
        size++

        if (size > capacity) {
            // 移除最后一个
            val lastCache = tail.pre!!
            lastCache.pre!!.next = tail
            tail.pre = lastCache.pre
            map.remove(lastCache.key)
            size--
        }
    }


    private fun moveToTop(cacheNode: CacheNode) {
        val preHead = head.next
        val next = cacheNode.next
        val pre = cacheNode.pre

        if (head.next != cacheNode) {
            // 不在第一个，放到第一位
            head.next = cacheNode
            cacheNode.next = preHead
            cacheNode.pre = head
            if (preHead != null) {
                preHead.pre = cacheNode
            }

            next?.pre = pre
            pre?.next = next
        }
    }

}


class CacheNode(val key: Int, var value: Int, var pre: CacheNode?, var next: CacheNode?)

/**
 * Your LRUCache object will be instantiated and called as such:
 * var obj = LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */