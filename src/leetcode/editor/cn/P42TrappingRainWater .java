package leetcode.editor.cn;

import java.util.Stack;

//Java：接雨水
public class P42TrappingRainWater{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trap(int[] height) {
        //单调栈思路：从行方向计算，从栈底到顶为从大到小的柱子高度（无相等），利用栈顶的元素来确定雨水区域的高度
        //实际上入栈了就代表该柱子的左侧用完了，放在栈里看有没有机会用他的右侧
        //有遍历到的新柱子和栈中的前两个柱子组成一个凹形状 来蓄水
        Stack<Integer> stk = new Stack<>();
        //第一格和最后一格不蓄水,但第一格作为左柱子，最后一格可以作为右边柱子，所以还是入栈
        stk.push(0);
        int res = 0;
        for (int i = 1; i < height.length; i++) {
            int top = stk.peek();
            if (height[i] < height[top]) stk.push(i);
            else if (height[top] == height[i]) {
                //如果相等的话，作为底，这两个数是相同的，但是作为蓄水的右侧，只能用新进来的这一格
                //因为高度相同且相邻，那么前一个的右侧就废了,后面组成蓄水的都是用后一个的右侧
                stk.pop();
                stk.push(i);
            } else {
                while (!stk.isEmpty() && height[i] > stk.peek()) {
                    int bottom = stk.pop();
                    //如果这里出现stk弹了一个就为空的情况，那么这个弹出来也不能用了，因为它既不能作为底（其没有左端高柱），又不能作为右边(因为右端有更高的)
                    //所以这个弹了就弹了，如果为空，就不用放回去
                    if (!stk.isEmpty()) {
                        //作为底才会被弹出，作为右侧不会被弹出，因为可能被再用
                        int left = stk.peek();
                        int area = (Math.min(height[left], height[i]) - height[bottom]) * (i - left - 1);
                        if (area > 0) res += area;
                    }
                }
                stk.push(i);
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

