package leetcode.editor.cn;

import java.util.Arrays;

//Java：分发饼干
public class P455AssignCookies{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int num = 0;
        int i = 0, j = 0;
        while (i < g.length && j < s.length) {
            if (g[i] <= s[j]) {
                i++;
                num++;
            }
            j++;
        }
        return num;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

