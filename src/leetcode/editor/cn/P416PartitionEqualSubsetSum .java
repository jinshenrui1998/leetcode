package leetcode.editor.cn;
//Java：分割等和子集
public class P416PartitionEqualSubsetSum{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //dp 01背包
    //这里需要深入理解 dp 背包中的重量和价值
    //先定义：dp就是找到组合最优解
    //"重量"： 组合的某个属性，这个属性大于某值，这个组合就不能要了
    //"价值":  组合的另一个属性，这个属性决定了最后，选择组合的结果
    //从代码上看：价值就是dp[j]（一维） 重量就是限制 而j就是重量

    //回到这题
    //这题的组合 就是数字之间的组合，组合要求，组合的和大于sum/2就不能要了
    //所以组合的和 是 重量
    //组合最后的结果 要求和等于sum/2 所以组合的和 也是 价值

    //所以这里循环i中的dp[j]代表的含义就是，考虑前i+1个数时，在负重为j的情况下的最大价值

    //卡鸽
    //背包的体积为sum / 2
    //背包要放入的商品（集合里的元素）重量为 元素的数值，价值也为元素的数值
    //背包如果正好装满，说明找到了总和为 sum / 2 的子集。
    //背包中每一个元素是不可重复放入。

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0)
            return false;
        sum /= 2;

        int[] dp = new int[sum + 1];
        for (int i = nums[0]; i < dp.length; i++) dp[i] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            for (int j = sum; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }

        return dp[sum] == sum;
    }
//    public boolean canPartition(int[] nums) {
//        int sum = 0;
//        for (int i = 0; i < nums.length; i++) {
//            sum += nums[i];
//        }
//        if (sum % 2 != 0)
//            return false;
//        sum /= 2;
//
//        boolean[] dp = new boolean[sum + 1];
//        //这时的dp[0]代表：考虑0号物品时，物品总价值能否等于背包容量（也即总和的一半)
//        dp[nums[0]] = true;
//
//        for (int i = 1; i < nums.length; i++) {
//            for (int j = sum; j >= nums[i]; j--) {
//                dp[j] = dp[j] || dp[j - nums[i]];
//            }
//        }
//
//        return dp[sum];
//    }

}
//leetcode submit region end(Prohibit modification and deletion)

