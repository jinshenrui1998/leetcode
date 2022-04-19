package leetcode.editor.cn;
//Java：螺旋矩阵 II
public class P59SpiralMatrixIi{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //
    public int[][] generateMatrix(int n) {
        //结果数组
        int[][] num = new int[n][n];
        //控制方向
        int[][] derection = {{0, 1}, {1, 0},{0, -1}, {-1, 0}};
        int derectionIndex = 0;
        //控制当前赋值，和终止
        int maxNum = n * n;
        int curNum = 1;
        //控制赋值位置
        int row = 0;
        int column = 0;
        //主要流程
        while (curNum <= maxNum) {
            num[row][column] = curNum++;
            int nextRow = row + derection[derectionIndex][0];
            int nextColumn = column + derection[derectionIndex][1];
            //遇到一下情况，则掉头，换方向
            if (nextRow < 0 || nextColumn < 0 || nextRow > n - 1 || nextColumn > n - 1 || num[nextRow][nextColumn] != 0) {
                derectionIndex = (derectionIndex + 1) % 4;
            }
            row += derection[derectionIndex][0];
            column += derection[derectionIndex][1];
        }
        return num;
    }
    //plan1
    //链接：https://leetcode-cn.com/problems/spiral-matrix-ii/solution/spiral-matrix-ii-mo-ni-fa-she-ding-bian-jie-qing-x/
/*    public int[][] generateMatrix(int n) {
        int l = 0, r = n - 1, t = 0, b = n - 1;
        int[][] mat = new int[n][n];
        int num = 1, tar = n * n;
        while(num <= tar){
            for(int i = l; i <= r; i++) mat[t][i] = num++; // left to right.
            t++;
            for(int i = t; i <= b; i++) mat[i][r] = num++; // top to bottom.
            r--;
            for(int i = r; i >= l; i--) mat[b][i] = num++; // right to left.
            b--;
            for(int i = b; i >= t; i--) mat[i][l] = num++; // bottom to top.
            l++;
        }
        return mat;
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)

