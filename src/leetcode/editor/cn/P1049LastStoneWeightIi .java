package leetcode.editor.cn;
//Java：最后一块石头的重量 II
public class P1049LastStoneWeightIi{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //1. 怎么确定这题用动态规划？
    //2. 这题怎么抽象成动态规划问题
    //动态规划问题的关键：1.抽象 两个选择 :选，或者不选,找选好还是不选好的问题
    //                  2.找到背包容量，重量和价值
    //这题等价于 将石头分为两个阵营 使两个阵营各自为了自己的阵营打架 最后生成一个最小的差值 这个差值就等于两个阵营总和的差值
    //又等价于 将石头分为两个部分，每个部分都尽可能接近sum/2
    //分析到这里 看到背包的雏形，背包就是 其中一个部分（可另其为较小部分）， 选择进或者不进该背包
    //背包容量就是sum/2
    //重量和价值都是stones[j]
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int i = 0; i < stones.length; i++) {
            sum += stones[i];
        }
        //这里选择向下取整的实际意义，就是，分为两部分，选择其中的较小部分（也可能等于）
        //dp推断到加到等于较小部分位置（意会 不可 言传）
        int[] dp = new int[sum/2 + 1];
        for (int i = stones[0]; i < dp.length; i++) dp[i] = stones[0];
        for (int i = 1; i < stones.length; i++) {
            for (int j = dp.length - 1; j >= stones[i]; j--){
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }
        return sum - 2 * dp[dp.length - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

