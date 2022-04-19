package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：N 皇后
public class P51NQueens{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //难点太多：难以总结，建议重刷
    //1.按照行顺序依次存储，这样可以大大的简化操作
    //2.String.copyValueOf(chess[i]) 从字符数组生成字符串 二维字符数组如何生成字符串
    //3.Arrays.fill(c, '.') 数组填充默认值，二维数组如何填充默认值
    char[][] chess;
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        chess = new char[n][n];
        for (char[] c : chess) {
            Arrays.fill(c, '.');
        }
        backTracing(n, 0);
        return result;
    }
    public void backTracing(int n, int curRow) {
        if (curRow == n) {
            result.add(array2List(chess));
            return;
        }
        for (int col = 0; col < n ; col++) {
            if(!isValid(n, curRow, col)) continue;
            chess[curRow][col] = 'Q';
            backTracing(n, curRow + 1);
            chess[curRow][col] = '.';
        }
    }
    public boolean isValid(int n, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (chess[i][col] == 'Q') return false;
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--){
            if (chess[i][j] == 'Q') return false;
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++){
            if (chess[i][j] == 'Q') return false;
        }
        return true;
    }
    public List<String> array2List(char[][] chess) {
        List<String> tmp = new ArrayList<>();
        for (int i = 0; i < chess.length; i++) {
            tmp.add(String.copyValueOf(chess[i]));
        }
        return tmp;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

