package leetcode.editor.cn;

import java.util.Stack;

//Java：删除字符串中的所有相邻重复项
public class P1047RemoveAllAdjacentDuplicatesInString{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
/*
* 这题只要能想到是用栈做就很简单
* */
class Solution {
//    public String removeDuplicates(String s) {
//        if (s == null || s.length() == 0)
//            return null;
//        Stack<Character> stack = new Stack<>();
//        for (int i = 0; i < s.length(); i++) {
//            char tmp = s.charAt(i);
//            if (!stack.isEmpty() && tmp == stack.peek()) {
//                stack.pop();
//            } else {
//                stack.push(tmp);
//            }
//        }
//        String res = "";
//        while (!stack.isEmpty()) {
//            res = stack.pop() + res;
//        }
//        return res;
//    }

    //将字符串作为栈，使用指针记录栈顶，比上面的方法快十倍
    public String removeDuplicates(String s) {
        // 将 res 当做栈
        StringBuffer res = new StringBuffer();
        // top为 res 的长度
        int top = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 当 top > 0,即栈中有字符时，当前字符如果和栈中字符相等，弹出栈顶字符，同时 top--
            if (top >= 0 && res.charAt(top) == c) {
                res.deleteCharAt(top);
                top--;
                // 否则，将该字符 入栈，同时top++
            } else {
                res.append(c);
                top++;
            }
        }
        return res.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

