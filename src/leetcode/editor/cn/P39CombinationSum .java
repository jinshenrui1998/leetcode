package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//Java：组合总和
public class P39CombinationSum{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //剪枝操作就是，先对数组进行排序，这样碰到大了的数字，后面都大了直接break
        Arrays.sort(candidates);
        backTracking(candidates, target, 0);
        return result;
    }
    public void backTracking(int[] candidates, int target, int startIndex) {
        if (target <= 0) {
            if (target == 0) result.add(new ArrayList<Integer>(path));
            return;
        }
        //如何控制每个子节点的宽度（子节点的节点数），和深度（之前控制）
        //我举过例子，如果是一个集合来求组合的话，就需要startIndex，例如：77.组合 (opens new window)，216.组合总和III (opens new window)。
        // 如果是多个集合取组合，各个集合之间相互不影响，那么就不用startIndex，例如：17.电话号码的字母组合
        for (int i = startIndex; i < candidates.length; i++) {
            if (candidates[i] > target) break;
            path.add(candidates[i]);
            backTracking(candidates, target - candidates[i], i);
            path.removeLast();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

