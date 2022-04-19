package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

//Java：螺旋矩阵
public class P54SpiralMatrix{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //plan1 撞墙法 更好
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new LinkedList<Integer>();
        //总行数n，列数m
        int n = matrix.length;
        int m = matrix[0].length;
        int maxNum = n * m;
        int curNum = 1;
        int row = 0;
        int column = 0;
        int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directionIndex = 0;
        while (curNum <= maxNum) {
            ans.add(matrix[row][column]);
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
    //边界法 建议用上面一种，消耗空间更小更好理解
/*    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new LinkedList<>();
        int top = 0;
        int left = 0;
        int bottom = matrix.length - 1;
        int right = matrix[0].length - 1;
        while (true) {
            for (int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }
            if (++top > bottom) break;
            for (int i = top; i <= bottom; i++) {
                list.add(matrix[i][right]);
            }
            if (--right < left) break;
            for (int i = right; i >= left ; i--) {
                list.add(matrix[bottom][i]);
            }
            if (--bottom < top) break;
            for (int i = bottom; i >= top; i--) {
                list.add(matrix[i][left]);
            }
            if (++left > right) break;
        }
        return list;
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)

