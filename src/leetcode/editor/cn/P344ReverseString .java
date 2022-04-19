package leetcode.editor.cn;
//Java：反转字符串
public class P344ReverseString{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void reverseString(char[] s) {
        if (s == null ||s.length <= 1) {
            return;
        }
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            if (s[left] != s[right]) {
                s[left] ^= s[right];
                s[right] ^= s[left];
                s[left] ^= s[right];
            }
            left++;
            right--;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

