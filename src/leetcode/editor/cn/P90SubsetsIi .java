package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//Java：子集 II
public class P90SubsetsIi{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        //给出集合中有重复，而结果不能重复
        //这种题去重复
        //一定要记得先排序
        Arrays.sort(nums);
        backTracing(nums, 0);
        return result;
    }
    public void backTracing(int[] nums, int startIndex){
        result.add(new ArrayList<Integer>(path));
        for (int i = startIndex; i < nums.length; i++) {
            //这里可以不写i > 0 数组下标也不会越界，
            //因为i ！= startIndex就限制了 i不会为0
            if (i != startIndex && nums[i] == nums[i - 1]) continue;
            path.add(nums[i]);
            backTracing(nums, i + 1);
            path.removeLast();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

