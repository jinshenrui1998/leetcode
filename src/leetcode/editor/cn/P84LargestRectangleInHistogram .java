package leetcode.editor.cn;

import java.util.Stack;

//Java：柱状图中最大的矩形
public class P84LargestRectangleInHistogram{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    //首先要想明白一个最关键的问题
    //这题要找到的是，每个点 左右两边第一个比自己小的点
    //每个点只用管好自己高度的就行，别的高度有别的点来管
    //虽然当前高度也许被低高度的划分为片，但是在更低高度他们还是属于一篇

    //动归 这一题和接雨水的不同 这题的不能由i推出i+1，i的信息不够充分的推出i+1, 所以要循环，但是仍然可以利用
    //接雨水是总共求一个值
    //但这题是要分成片分开求，所以每个点不能只管自己的高度
    //所以在计算面积的时候，就要知道当前片的左右下标
    //所以动归的结果得是 左右两边第一个比这个点的值小的点的下标
    // public int largestRectangleArea(int[] heights) {
    //     int[] minLeft = new int[heights.length];
    //     int[] minRight = new int[heights.length];
    //     //下标这样处理是由于最后是算夹住的距离
    //     //所以可以是负数，也能作为距离
    //     //-1了就说明0在这片区域
    //     //这里要好好控制循环不然很容易死循环
    //     minLeft[0] = -1;
    //     for (int i = 1; i < heights.length; i++) {
    //         int t = i - 1;
    //         while(t >= 0 && heights[t] >= heights[i]) t = minLeft[t];
    //         minLeft[i] = t;
    //     }
    //     minRight[heights.length - 1] = heights.length;
    //     for (int i = heights.length - 2; i >= 0; i--) {
    //         int t = i + 1;
    //         while(t < heights.length && heights[t] >= heights[i]) t = minRight[t];
    //         minRight[i] = t;
    //     }
    //     int res = 0;
    //     for (int i = 0; i < heights.length; i++) {
    //         int area = heights[i] * (minRight[i] - minLeft[i] - 1);
    //         res =Math.max(res, area);
    //     }
    //     return res;
    // }

    //tips:单调栈一般没有相等的值

    //单调栈
    //如何确定是单调递增栈，还是递减栈
    //1.这里要找的数是 如果小了，那么就要计算面积（触发事件）
    //所以小了就不能进入，大了可以进入
    //所以这里从底到头是递增的才行
    //这样栈里前一个也是我们要找的左边比当前小的那一个
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stk = new Stack<>();
        stk.push(0);
        int res = 0;

        int [] newHeights = new int[heights.length + 2];
        newHeights[0] = 0;
        newHeights[newHeights.length - 1] = 0;
        for (int index = 0; index < heights.length; index++){
            newHeights[index + 1] = heights[index];
        }
        heights = newHeights;

        for (int i = 1; i < heights.length; i++) {
            int top = stk.peek();
            //等于的时候不要入栈，因为要取面积的最大值，也就是最左边的(也不触发事件)
            if (heights[i] > heights[top]) {
                stk.push(i);
            } else if (heights[i] < heights[top]) {
                while (!stk.isEmpty() && heights[i] < heights[top]) {
                    int curHight = heights[stk.pop()];
                    int curWeight = (i - stk.peek() - 1);
                    int area = curWeight * curHight;
                    res = Math.max(res, area);
                }
                stk.push(i);
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

