package leetcode.editor.cn;

import java.util.Arrays;

//Java：不同路径
public class P62UniquePaths{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
//    public int uniquePaths(int m, int n) {
//        //dp[i][j]代表到i，j的路径
//        //dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
//        //dp[0][All] = 1 dp[ALL][0] = 1
//        //遍历顺序，每行的从左往右
//        if (m == 1 || n == 1) return 1;
//        int[][] dp = new int[m][n];
//        Arrays.fill(dp[0], 1);
//        for (int i = 0; i < m; i++) {
//            dp[i][0] = 1;
//        }
//        for (int i = 1; i < m; i++) {
//            for (int j = 1; j < n; j++) {
//                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
//            }
//        }
//        return dp[m - 1][n - 1];
//    }
//}

//滚动数组，重复利用一维数组达到二维数组的效果（也是只存储有用信息的表现）
class Solution {
    public int uniquePaths(int m, int n) {
        //dp[i][j]代表到i，j的路径
        //dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
        //dp[0][All] = 1 dp[ALL][0] = 1
        //遍历顺序，每行的从左往右
        if (m == 1 || n == 1) return 1;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }
        return dp[n - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

