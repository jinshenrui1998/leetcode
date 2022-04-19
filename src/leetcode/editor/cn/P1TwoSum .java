package leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;

//Java：两数之和
public class P1TwoSum {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer tmp = map.get(target - nums[i]);
            if (tmp != null) {
                return new int[] {tmp, i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

