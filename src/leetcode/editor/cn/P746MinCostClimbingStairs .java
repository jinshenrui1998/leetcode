package leetcode.editor.cn;
//Java：使用最小花费爬楼梯
public class P746MinCostClimbingStairs{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    public int minCostClimbingStairs(int[] cost) {
//        //dp[i]表示到i层的最低花费
//        //dp[i] = min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2])
//        //dp[0] = 0 dp[1] = 0
//
//        int[] dp = new int[cost.length + 1];
//        dp[0] = 0;
//        dp[1] = 0;
//        for (int i = 2; i <= cost.length; i++) {
//            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
//        }
//        return dp[cost.length];
//    }
    //状态压缩
    public int minCostClimbingStairs(int[] cost) {
        if (cost.length <= 1) return 0;
        int a = 0, b = 0;
        int c = 0;
        for (int i = 2; i <= cost.length; i++) {
            c = Math.min(b + cost[i - 1], a + cost[i - 2]);
            a = b;
            b = c;
        }
        return c;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

