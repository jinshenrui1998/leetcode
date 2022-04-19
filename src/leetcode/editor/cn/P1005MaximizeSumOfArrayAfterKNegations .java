package leetcode.editor.cn;

import java.util.Arrays;

//Java：K 次取反后最大化的数组和
public class P1005MaximizeSumOfArrayAfterKNegations{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //如何处理k，实现其数量超出负数部分的长度的时候的一个处理
    //这题不能吧逻辑混在一起处理，会处理不清楚，要分开，哪怕时间复杂度搞
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int index = 0 ;
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] < 0 && k > 0) {
                nums[i] = -nums[i];
                k--;
            }
            index = Math.abs(nums[i]) < Math.abs(nums[index]) ? i : index;
        }
        if (k % 2 != 0) {
            nums[index] = -nums[index];
        }
        int resSum = 0;
        for (int tmp : nums) {
            resSum += tmp;
        }
        return resSum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

