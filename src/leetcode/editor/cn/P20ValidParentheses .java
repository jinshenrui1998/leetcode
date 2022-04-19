package leetcode.editor.cn;

import java.util.Stack;

//Java：有效的括号
public class P20ValidParentheses{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
//括号匹配 是 用栈解决的经典问题(先进后匹配）
// 思路：根据左括号情况，设置一个辅助栈存储正确右括号
// 重点：在这样一个括号串中，在前面串确定的情况下，当前位置如果为右括号，
// 那么右括号有唯一确定合法值
// 例如: ({[{(  的 后一个位置 如果是右括号 那么必须是 ) ，如果是其它的则不合法
// 所以算法思路为左括号入栈，右括号匹配辅助栈
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //碰到左括号，对应右括号入辅助栈
            if (c == '[') stack.push(']');
            else if (c == '(') stack.push(')');
            else if (c == '{') stack.push('}');
            //再碰到右括号时，
            //1. 如果当前栈空（则右括号多了)
            //2. 或者右括号不匹配
            //则不合法
            else if (stack.isEmpty() || c != stack.pop()) {
                return false;
            }
        }
        //3. 如果当前栈不为空，则左括号多了，则不合法。
        //否则合法
        return stack.isEmpty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

