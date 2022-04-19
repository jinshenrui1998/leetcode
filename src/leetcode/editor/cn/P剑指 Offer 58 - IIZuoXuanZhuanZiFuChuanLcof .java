package leetcode.editor.cn;
//Java：左旋转字符串
public class P剑指 Offer 58 - IIZuoXuanZhuanZiFuChuanLcof{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
//             abcdefg 3  -->  最终结果要求defgabc
// 全部反转     gfedcba
// 分别反转部分  defg + abc
class Solution {
    public String reverseLeftWords(String s, int n) {
        if (s == null || s.length() < 2) {
            return s;
        }
        char[] chs = s.toCharArray();

        reverse(chs, 0, n - 1);
        reverse(chs, n, chs.length - 1);
        reverse(chs, 0, chs.length - 1);

        return new String(chs);
    }

    public void reverse(char[] chs, int left, int right) {
        while (left < right) {
            char tmp = chs[left];
            chs[left++] = chs[right];
            chs[right--] = tmp;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

