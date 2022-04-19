
package leetcode.editor.cn;
//Java：整数拆分
public class P343IntegerBreak{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int integerBreak(int n) {
        //这题有一个歧义细节处理点
        //如果把dp[i]定义为i拆分后的最大乘积 会出现一个问题
        //dp[2] 应该定义为1，因为拆分最大乘积为1，但是如果2作为一个因子，它本身就是2
        //所以dp[2](还有dp[3])在作为因子时，未必代表最大拆分方式

        //所以接下来就用两种处理方式
        //1.对于dp[2] 和 dp[3] 本身不作为结果返回，额外处理其结果
        //2.就按照最大因子的方式 令dp[2] = 2 dp[3] = 3 (dp[1] = 1)
        //即dp[i]数组的定义变成，i拆分后的乘积与其自身的最大值
        //在i <= 3 时 dp[i] = i 大于3时 dp[i]代表拆分后的最多乘积

        //另一种处理方式就是
        //如果把dp[i]定义为i拆分后的最大乘积,
        //在作为因子加载dp[i]的时候对其进行判断,判断dp[i],i的最大值作为因子
        //在作为结果时，正常返回dp[i]

        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            //这里为什么要从1遍历到i - 1，为什么要拆成了1 和 i - 1
            //还要拆成i - 1 和 1
            //因为1 和 i - 1代表1 拆 i - 1不拆，
            //而i-1和1代表，i - 1拆 1 不拆
            for (int j = 1; j < i; j++) {
                //dp[0]与dp[1]在里结果会被直接舍去，因为小
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

