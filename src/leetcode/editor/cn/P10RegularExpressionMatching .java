package leetcode.editor.cn;
//Java：正则表达式匹配
public class P10RegularExpressionMatching{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isMatch(String s, String p) {
        //思路：首先先实现一个字符串匹配
        //对于#*进行分类讨论
        //分别对应#*匹配0字符，匹配1个或多个字符

        //dp[i][j]表示长度为i和j的能否匹配
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        //"" 和p的匹配关系初始化，a*a*a*a*a*这种能够匹配空串，其他的是都是false。
        //  奇数位不管什么字符都是false，偶数位为* 时则: dp[0][i] = dp[0][i - 2]
        for (int i = 2; i <= p.length(); i+= 2) {
            if (p.charAt(i - 1) == '*' && dp[0][i-2]) {
                dp[0][i] = true;
            } else {
                break;
            }
        }
        //初始化  dp[0][0] = true 而其它为false
        //1.理解为空字符串直接可以匹配，而非空字符串和空字符串不能匹配
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.') {
                    dp[i][j] = dp[i-1][j-1];
                } else if (p.charAt(j-1) == '*'){
                    //1.j-2和i-1不能匹配 此时只能匹配0个
                    if (p.charAt(j-2) == s.charAt(i-1) || p.charAt(j-2) == '.') {
                        //此时可以匹配0个也可以不匹配
                        //如何理解这个匹配0个
                        //s : aaa  p:aa*aa
                        //这种情况下前一个可以匹配，但是我们也可以选择不匹配，这样才符合可以匹配0个这个定义
                        dp[i][j] = dp[i][j - 2] || dp[i-1][j];
                    }
                    else {
                        //此时只能匹配0个
                        dp[i][j] = dp[i][j-2];
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

