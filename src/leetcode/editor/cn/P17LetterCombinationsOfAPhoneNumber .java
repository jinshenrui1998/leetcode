package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

//Java：电话号码的字母组合
public class P17LetterCombinationsOfAPhoneNumber{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<String> result = new LinkedList<>();
    StringBuilder sb = new StringBuilder();
    //本来想建立一个num到char的关系式，但是这样会很麻烦，因为7和9有4个字母
    String[] numMap = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        if (digits != null && digits.length() != 0)
            backTracking(digits, 0);
        return result;
    }
    public void backTracking(String digits, int curIndex) {
        if (curIndex == digits.length()) {
            result.add(new String(sb));
            return;
        }
        //宽度深度总结
        String stringMap = numMap[digits.charAt(curIndex) - 48];
        for (int i = 0; i < stringMap.length(); i++){
            sb.append(stringMap.charAt(i));
            backTracking(digits, curIndex + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

