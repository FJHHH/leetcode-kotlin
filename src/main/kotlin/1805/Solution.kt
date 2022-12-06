package `1805`

import java.util.regex.Pattern

class Solution {
    fun numDifferentIntegers(word: String): Int {
        return word.split(Pattern.compile("[a-z]"))
            .filter {
                it.isNotEmpty()
            }.map {
                var r = it
                while (r.startsWith('0')) {
                    r = r.replaceFirst("0", "")
                }
            }.distinct()
            .size
    }
}

fun main() {
    println(Solution().numDifferentIntegers("a123bc34d8ef34"))
}
