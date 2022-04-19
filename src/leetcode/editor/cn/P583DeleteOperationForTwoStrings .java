package leetcode.editor.cn;
//Java：两个字符串的删除操作
public class P583DeleteOperationForTwoStrings{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minDistance(String word1, String word2) {
        //dp[i][j] 令word1的0到i-1与word2的0到i-2相等所需的最小步数
        int[][] dp = new int[2][word2.length() + 1];
        dp[1][0] = 1;
        for (int i = 1; i <= word2.length(); i++) dp[0][i] = i;
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i % 2][j] = dp[(i-1) % 2][j-1];
                } else {
                    dp[i % 2][j] = Math.min(dp[(i-1) % 2][j], dp[i % 2][j-1]) + 1;
                }
            }
        }
        return dp[word1.length() % 2][word2.length()];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

