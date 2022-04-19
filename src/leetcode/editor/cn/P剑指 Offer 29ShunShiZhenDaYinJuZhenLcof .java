package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

//Java：顺时针打印矩阵
public class P剑指 Offer 29ShunShiZhenDaYinJuZhenLcof{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] spiralOrder(int[][] matrix) {
            //总行数n，列数m
            int n = matrix.length;
            int m = matrix[0].length;
            int maxNum = n * m;
            int[] ans = new int[maxNum];
            int curNum = 0;
            int row = 0;
            int column = 0;
            int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
            int directionIndex = 0;
            while (curNum < maxNum) {
                ans[curNum ] = matrix[row][column];
                matrix[row][column] = 0;
                curNum++;
                int nextRow = row + direction[directionIndex][0];
                int nextColumn = column + direction[directionIndex][1];
                if (nextRow < 0 || nextColumn < 0 || nextRow > n - 1
                        || nextColumn > m - 1 || matrix[nextRow][nextColumn] == 0) {
                    directionIndex = (directionIndex + 1) % 4;
                }
                row += direction[directionIndex][0];
                column += direction[directionIndex][1];
            }
            return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

