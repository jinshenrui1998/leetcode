package leetcode.editor.cn;
//Java：跳跃游戏 II
public class P45JumpGameIi{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //思路维护curCover和nextCover代表当前这一步和下一步的cover
    //转换的时候就代表了添加了步数
    public int jump(int[] nums) {
        if (nums.length <= 1) return 0;
        int curCover = 0;
        int nextCover = 0;
        int resStep = 0;
        //这里也可以写成 i <= nums.length 因为最后一定可以到达（题目规定)
        for (int i = 0; i <= curCover; i++) {
            nextCover = Math.max(nextCover, i + nums[i]);

            if (nextCover >= nums.length - 1) {
                resStep++;
                break;
            }

            if (i == curCover) {
                resStep++;
                curCover = nextCover;
            }
        }
        return resStep;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

