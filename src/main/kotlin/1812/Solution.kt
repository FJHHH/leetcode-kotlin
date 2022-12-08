package `1812`

class Solution {
    fun squareIsWhite(coordinates: String): Boolean {
        val x = coordinates[0] - 'a';
        val y = coordinates[1] - '0';
        return (x + y) % 2 == 0
    }
}
