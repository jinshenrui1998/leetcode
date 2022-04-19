package leetcode.editor.cn;
//Java：目标和
public class P494TargetSum{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //初见思考
    //类比之前两题
    //这题可以考虑将数组根据正负分成两个部分，所有正数之和为a，所有负数之和为b
    //可以得到 a - b = sum  a + b = target
    //那么 a = (sum + target) / 2
    //我们考虑用背包装所有正数，那么背包容量就是 (sum + target) / 2
    //
    //tips:这种动态规划，在重量j的维度上，相当于也反应了价值，这就是为什么要设置两个维度
    //为什么dp[j]中的数字没有必要传递价值信息，可以设置为true or false或者像这题设置成数字
    //因为j就反应了价值
    //状态转移方程（数量）
    //dp[j] = dp[j] + dp[j - nums[i]]
    //初始化：第一行 ： dp[nums[0]] = 1 其它都是0
    //       第一列 :  if（nums[i] == 0） dp[0] = 1
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        //如果(sum + target) % 2 == 1 那么背包容量也就是要求正数之和为小数，那么肯定没有答案
        if (Math.abs(target) > sum || (sum + target) % 2 == 1) return 0;
        //此时-sum <= target < sum 即sum + target >= 0
        int[] dp = new int[(sum + target) / 2 + 1];
        //初始化 第一行就dp[0] = 1 只用初始化这一个数，后面从第一行开始计算
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = dp.length - 1; j >= nums[i]; j--) {
                dp[j] = dp[j] + dp[j - nums[i]];
            }
        }
        return dp[dp.length - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

