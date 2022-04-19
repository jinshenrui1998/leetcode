package leetcode.editor.cn;

import java.util.Stack;

//Java：每日温度
public class P739DailyTemperatures{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stk = new Stack<>();
        int[] res = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (!stk.isEmpty() && temperatures[i] < stk.peek()) {
                int tmp = stk.pop();
                res[tmp] = i;
            }
            stk.push(i);
        }
        while(!stk.isEmpty()) {
            int tmp = stk.pop();
            res[tmp] = 0;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

