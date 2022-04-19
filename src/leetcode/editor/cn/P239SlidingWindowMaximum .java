package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

//Java：滑动窗口最大值
public class P239SlidingWindowMaximum{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //思路：遍历数组，将 数 存放在双向队列中，
    // 并用 L,R 来标记窗口的左边界和右边界。队列中保存的并不是真的数，
    // 而是该数值对应的数组下标位置，并且数组中的数要从大到小排序。
    // 如果当前遍历的数比队尾的值大，则需要弹出队尾值，
    // 直到队列重新满足从大到小的要求。
    // 刚开始遍历时，L 和 R 都为 0，有一个形成窗口的过程，
    // 此过程没有最大值，L 不动，R 向右移。
    // 当窗口大小形成时，L 和 R 一起向右移，每次移动时，
    // 判断队首的值的数组下标是否在 [L,R] 中，
    // 如果不在则需要弹出队首的值，当前窗口的最大值即为队首的数。


    public int[] maxSlidingWindow(int[] nums, int k) {
        //Deque 双向队列 addFirst, addLast, pollFirst, peekFirst
        Deque<Integer> deque = new LinkedList<>();
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            //维护这个单调递减队列
            //在碰到新的nums[i]数时，把比这个数小的数，全部踢出队列
            //由于是单调递减队列，所以每次都和最后面的比较
            //理由：因为队列中所有下标都比当前值旧，只要值比当前值小，
            // 那么这个值就成为无效值
            // 不会成为任意一个滑动窗口的最大值
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            //由于当前值无论如何都是下标最新的值，所以一定在当前位置有效，是有效值，入队
            //和上一个操作结合，维护出来的一定是单调递减队列
            deque.add(i);
            //First处一定是最大值，所以First存的下标满足当前滑动窗口，
            //那么就是当前滑动窗口的最大值
            //如果不合法，那就poll
            //由于当前值的下标一定合法，所以这里最少会有一个当前值，不会无效
            while (deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }
            //这里就是把队列维护的值取出来，放到对应的结果数组的位置上
            if (i >= k - 1) {
                result[i-k+1] = nums[deque.peekFirst()];
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

