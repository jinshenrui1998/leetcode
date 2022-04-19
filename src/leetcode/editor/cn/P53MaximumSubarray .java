package leetcode.editor.cn;
//Java：最大子数组和
public class P53MaximumSubarray{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //贪心策略
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;
        int count = 0;
        //贪心的思路为局部最优：当前“连续和”为负数的时候立刻放弃，
        // 从下一个元素重新计算“连续和”，因为负数加上下一个元素 “连续和”只会越来越小。
        // 从而推出全局最优：选取最大“连续和”

        //这个贪心策略看起来简单，实际很难
        //1.不详细记录最长数组区间，只记录数组区间之和，保存更新
        //2.不详细记录数组区间，通过更新count的方式，来更新区间的起始位置(i负责fast指针)
        //具体思路：
        //遍历到每个新数的时候，先把新数加上，看看是不是最大的。
        //再拿这个和判断，如果小于0，则代表前面这一串，对后面的和是没有贡献的，
        //所以就要更新区间起始位置，令count = 0
        //
        //这样维护的count会有一个性质，
        //count[0] > 0  count[0] + count[1] > 0 count[0] + count[1] + count[2] > 0 ~~~~
        //这个性质相当于保证了，加上count从0开始任意长度的子串一定大于0，加上之后一定是赚的
        //而且一定是从 0 开始加到 i - 1 是最赚的， 越往前加越赚，加到0最赚
        //正好契合了，你要是想加0，就必须把1 到 i - 1 都加上判断。

        //也就是对从 i - 1 向左取各种长度的子串中，找到一个最赚的,加在i上

        //这里消除双循环利用的性质就是，一次更新左区间之后，代表当前这个值加上就负了，但是后面的值
        //如果要加左子串，就必须加上当前值，所以对于后面的值来说，前面就都不能要了，也不能重复取
        for (int i = 0; i < nums.length; i++) {
            count += nums[i];
            res = Math.max(count, res);
            if (count < 0) {
                count = 0;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

