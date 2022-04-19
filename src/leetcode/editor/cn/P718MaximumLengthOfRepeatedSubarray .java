package leetcode.editor.cn;
//Java：最长重复子数组
public class P718MaximumLengthOfRepeatedSubarray{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        //dp[i][j]和卡尔思路不同
        //这里：dp[i][j]表示到i-1和j-1的最长重复子数组长度
        //卡尔: dp[i][j]表示以i-1和j-1结尾的最长重复子数组长度
        int[] dp = new int[nums2.length + 1];
        int res = 0;


        //如果用dp[i][j]代表下标为i - 1,j - 1为结尾的最长公共子数组
        //由于递推公式 dp[i][j] = dp[i-1][j-1] + 1;
        //那么要给所有 dp[0][j] 和 dp[i][0] 赋值（根据实际意义）
        //这时我们可以腾出来一个没有意义的下标
        //用dp[i][j]去代表以i-1和j-1为结尾的最长公共子数组
        //这样就可以同一初始化 将多出来的一行一列通通初始化为0
        //直接就可以利用循环中的逻辑进行后续处理
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = nums2.length; j >= 1; j--) {
                //i-1和j-1位置匹配上了，那么就要找i-2和j-2位置的
                //在二维中，也就是dp[i][j] 找 dp[i-1][j-1]
                //那么在一维中，要找i-1就是找还没有被这个循环更新过的dp[j-1]
                //那么就要求遍历到dp[j]的时候dp[j-1]还没被当前循环更新，那么就要反过来遍历，就行
                if (nums1[i - 1] == nums2[j - 1]) dp[j] = dp[j-1] + 1;
                    //如果是二维就不需要下面这一步，但是如果是一维的，没匹配上了，他就代表i-1的匹配没匹配上，而不更新为0的话它代表的就是之前
                    //i-2匹配情况
                else dp[j] = 0;
                res = Math.max(res, dp[j]);
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

