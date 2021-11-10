package `733`

//An image is represented by an m x n integer grid image where image[i][j]
//represents the pixel value of the image. 
//
// You are also given three integers sr, sc, and newColor. You should perform a 
//flood fill on the image starting from the pixel image[sr][sc]. 
//
// To perform a flood fill, consider the starting pixel, plus any pixels 
//connected 4-directionally to the starting pixel of the same color as the starting 
//pixel, plus any pixels connected 4-directionally to those pixels (also with the same 
//color), and so on. Replace the color of all of the aforementioned pixels with 
//newColor. 
//
// Return the modified image after performing the flood fill. 
//
// 
// Example 1: 
//
// 
//Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, newColor = 2
//Output: [[2,2,2],[2,2,0],[2,0,1]]
//Explanation: From the center of the image with position (sr, sc) = (1, 1) (i.
//e., the red pixel), all pixels connected by a path of the same color as the 
//starting pixel (i.e., the blue pixels) are colored with the new color.
//Note the bottom corner is not colored 2, because it is not 4-directionally 
//connected to the starting pixel.
// 
//
// Example 2: 
//
// 
//Input: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, newColor = 2
//Output: [[2,2,2],[2,2,2]]
// 
//
// 
// Constraints: 
//
// 
// m == image.length 
// n == image[i].length 
// 1 <= m, n <= 50 
// 0 <= image[i][j], newColor < 2¹⁶ 
// 0 <= sr < m 
// 0 <= sc < n 
// 
// Related Topics 深度优先搜索 广度优先搜索 数组 矩阵 👍 234 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, newColor: Int): Array<IntArray> {
        val oldColor = image[sr][sc]
        val flags = Array(image.size) {
            BooleanArray(image[0].size)
        }

        floodFill(image, flags, sr, sc, oldColor, newColor)
        return image
    }

    private fun floodFill(
        image: Array<IntArray>, flags: Array<BooleanArray>, sr: Int,
        sc: Int, oldColor: Int, newColor: Int
    ) {
        if (flags[sr][sc]) {
            return
        }

        flags[sr][sc] = true

        if (image[sr][sc] == oldColor) {
            image[sr][sc] = newColor
        } else {
            return
        }

        if (sr - 1 >= 0) {
            floodFill(image, flags, sr - 1, sc, oldColor, newColor)
        }

        if (sr + 1 < image.size) {
            floodFill(image, flags, sr + 1, sc, oldColor, newColor)
        }

        if (sc - 1 >= 0) {
            floodFill(image, flags, sr, sc - 1, oldColor, newColor)
        }

        if (sc + 1 < image[0].size) {
            floodFill(image, flags, sr, sc + 1, oldColor, newColor)
        }
    }
}

fun main() {
    Solution().floodFill(
        arrayOf(
            intArrayOf(1, 1, 1),
            intArrayOf(1, 1, 0),
            intArrayOf(1, 0, 1)
        ), 1, 1, 2
    )
}
//leetcode submit region end(Prohibit modification and deletion)
