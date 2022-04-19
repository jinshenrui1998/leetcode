package leetcode.editor.cn;
//Java：重复的子字符串
public class P459RepeatedSubstringPattern{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        //这题需要记录加上最后一个字母的字符串，而我
        if (s.length() <= 1) return false;

        int[] next = new int[s.length() + 1];
        getNext(next, s);

        if (next[s.length()] > 0 && s.length() % (s.length() - next[s.length()]) == 0)
            return true;
        return false;
    }

    public void getNext(int[] next, String s) {
        next[0] = -1;
        int j = 0;

        for (int i = 2; i < s.length() + 1; i++) {
            while (j > 0 && s.charAt(i - 1) != s.charAt(j)) {
                j = next[j];
            }
            if (s.charAt(i - 1) == s.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

