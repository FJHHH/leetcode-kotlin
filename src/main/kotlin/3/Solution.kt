package `3`

// https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/

class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        if (s.length <= 1) {
            return s.length
        }

        var l = 0

        val lastIndex = s.lastIndex

        while(l < lastIndex && s[l] == s[l + 1]) l++

        val set = HashSet<Char>()
        set.add(s[l])
        var r = l + 1
        var maxSize = 1
        while (r <= lastIndex) {
            if (set.contains(s[r])) {
                while (l < r && set.contains(s[r])) {
                    set.remove(s[l++])
                }
            } else {
                set.add(s[r++]);
            }
            maxSize = Math.max(maxSize, set.size)
        }
        return maxSize
    }
}