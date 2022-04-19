package leetcode.editor.cn;
//Java：跳跃游戏
public class P55JumpGame{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    //贪心算法局部最优解：每次取最大跳跃步数（取最大覆盖范围），
    // 整体最优解：最后得到整体最大覆盖范围，看是否能到终点。

    //用拘泥于每次究竟跳跳几步，而是看覆盖范围，
    //覆盖范围内一定是可以跳过来的，不用管是怎么跳的。
//    public boolean canJump(int[] nums) {
//        if (nums.length == 1) {
//            return true;
//        }
//        //覆盖范围, 初始覆盖范围应该是0，因为下面的迭代是从下标0开始的
//        int coverRange = 0;
//        //重中之重 : 在覆盖范围内更新最大的覆盖范围
//        for (int i = 0; i <= coverRange; i++) {
//            coverRange = Math.max(coverRange, i + nums[i]);
//            if (coverRange >= nums.length - 1) {
//                return true;
//            }
//        }
//        return false;
//    }
    public boolean canJump(int[] nums) {
        if (nums.length < 1) return true;
        int cover = 0;
        for (int i = 0; i <= cover; i++) {
            cover = Math.max(cover, nums[i] + i);
            if (cover >= nums.length - 1) return true;
        }
        return false;
    }
}
//class Solution {
//    public boolean canJump(int[] nums) {
//        int i = 0;
//        while (i < nums.length && nums[i] > 0) {
//            int next = i + 1;
//            for (int k = i + 2; k <= i + nums[i] && k < nums.length; k++) {
//                if (k == nums.length - 1 || nums[k] + k - i > nums[next] + next - i) {
//                    next = k;
//                }
//            }
//            i = next;
//        }
//        return i >= nums.length - 1;
//    }
//}
//leetcode submit region end(Prohibit modification and deletion)

