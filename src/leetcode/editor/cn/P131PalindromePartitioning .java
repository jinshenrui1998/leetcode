package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//Java：分割回文串
public class P131PalindromePartitioning{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<String>> result = new ArrayList<>();
    LinkedList<String> path = new LinkedList<>();
    public List<List<String>> partition(String s) {
        if (s != null && s.length() != 0) backTracing(s, 0);
        return result;
    }
    public void backTracing (String s, int startIndex) {
        if (startIndex == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }
        //循环保证找到从startIndex一个回文子串(多次)，把后面的交给回溯
        for (int i = startIndex; i < s.length(); i++) {
            if (!judgePrString(s, startIndex, i)) {
                continue;
            }
            path.add(s.substring(startIndex, i + 1));
            backTracing(s, i + 1);
            path.removeLast();
        }
    }
    public boolean judgePrString(String s, int startIndex, int i) {
        while (startIndex <= i) {
            if (s.charAt(startIndex++) != s.charAt(i--)) return false;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

