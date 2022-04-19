package leetcode.editor.cn;
//Java：不同路径 II
public class P63UniquePathsIi{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //dp[i][j] 表示到达i, j的路径数
        //dp[i][j] = dp[i][j - 1] + dp[i - 1][j]
        //dp[0][0:obstacle] = 1 dp[0][obstacle:] = 0 dp[0:obstacle][0] = 1 dp[obstacle:][0] = 0
        //从左到右，从上到下
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];

        //这里由于dp是数组，默认值就是0，所以可以在碰到障碍物之后直接不处理就可以
        for (int j = 0; j < obstacleGrid[0].length && obstacleGrid[0][j] != 1; j++) {
            dp[0][j] = 1;
        }


        for (int i = 0; i < obstacleGrid.length && obstacleGrid[i][0] != 1; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

