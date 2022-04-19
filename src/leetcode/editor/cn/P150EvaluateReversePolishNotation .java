package leetcode.editor.cn;

import java.util.Stack;

//Java：逆波兰表达式求值
public class P150EvaluateReversePolishNotation{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
//这题只要能想到用栈，就很简单。
class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+")) {
                stack.push(stack.pop() + stack.pop());
            //细节 - 和 / 是运算 是要分先后的，先出栈的其实是运算中的后一个
            // 所以要进行记录
            } else if (tokens[i].equals("-")) {
                int tmp = stack.pop();
                stack.push(stack.pop() - tmp);
            } else if (tokens[i].equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (tokens[i].equals("/")) {
                int tmp = stack.pop();
                stack.push(stack.pop() / tmp);
            } else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

