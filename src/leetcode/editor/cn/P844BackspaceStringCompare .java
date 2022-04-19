package leetcode.editor.cn;

//Java：比较含退格的字符串
public class P844BackspaceStringCompare {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //空间复杂度O(1)
    public boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() - 1;
        int sSkip = 0;
        int tSkip = 0;
        //这里是 || 不是 && ,一个大于一个小于出循环应该是false，应该进循环
        //变成false
        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (s.charAt(i) == '#') {
                    sSkip++;
                    i--;
                } else if (sSkip > 0){
                    sSkip--;
                    i--;
                } else break;
            }
            while (j >= 0) {
                if (t.charAt(j) == '#') {
                    tSkip++;
                    j--;
                } else if (tSkip > 0){
                    tSkip--;
                    j--;
                } else break;
            }
            if (i >= 0 && j >= 0) {
                if (s.charAt(i) != t.charAt(j)) {
                    return false;
                }
            } else if (i >= 0 || j >= 0) {
                return false;
            }
            i--;
            j--;
        }
        return true;
    }
    //双指针算法 空间复杂度O(n) 时间复杂度O(1) 比较好想的方法
/*    public boolean backspaceCompare(String s, String t) {
        char[] sLegal = s.toCharArray();
        char[] tLegal = t.toCharArray();
        int len1 = isLegal(sLegal);
        int len2 = isLegal(tLegal);
        if (len1 != len2) {
            return false;
        }
        for (int i = 0 ; i < len1; i++) {
            if (sLegal[i] != tLegal[i]) {
                return false;
            }
        }
        return true;
    }

    public int isLegal(char[] t) {
        int left = 0;
        for (int right = 0; right < t.length; right++) {
            if (t[right] != '#') {
                t[left] = t[right];
                left++;
            } else if (left > 0){
                left--;
            }
        }
        return left;
    }*/


}
//leetcode submit region end(Prohibit modification and deletion)

