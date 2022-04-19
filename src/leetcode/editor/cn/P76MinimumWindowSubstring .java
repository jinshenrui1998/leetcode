package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//Java：最小覆盖子串
public class P76MinimumWindowSubstring{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
//完美题解链接
//https://leetcode-cn.com/problems/minimum-window-substring/solution/tong-su-qie-xiang-xi-de-miao-shu-hua-dong-chuang-k/
//思路：
//(1)右边加到包括所有元素，左边减去多余直到最小仍包括所有需要元素。记录一次ans
//(2)左边再减一个。
//重复
class Solution {
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0) {
            return "";
        }
        //整个ASCII码表就128个
        int[] need  = new int[128];
        for (int i = 0; i < t.length(); i++) {
            need[t.charAt(i)]++;
        }
        int needCount = t.length();
        int left = 0;
        int right = 0;
        int size = Integer.MAX_VALUE;
        int start = 0;
        while (right < s.length()) {
            char cur = s.charAt(right);
            if (need[cur] > 0) {
                needCount--;
            }
            need[cur]--;
            if (needCount == 0) {
                while (left < right && need[s.charAt(left)] < 0) {
                    need[s.charAt(left)]++;
                    left++;
                }
                if (right - left + 1 < size) {
                    size = right - left + 1;
                    start = left;
                }
                need[s.charAt(left)]++;
                left++;
                needCount++;
            }
            right++;
        }
        return size == Integer.MAX_VALUE ? "" : s.substring(start, start + size);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

