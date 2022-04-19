package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//Java：组合总和 II
public class P40CombinationSumIi{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    //本题的难点在于区别2中：集合（数组candidates）有重复元素，但还不能有重复的组合。
    //即例如 1 1 6 会取两次 1 6
    //这个去重为什么很难理解呢，所谓去重，其实就是使用过的元素不能重复选取。 这么一说好像很简单！
    //都知道组合问题可以抽象为树形结构，那么“使用过”在这个树形结构上是有两个维度的，
    //一个维度是同一树枝上使用过，一个维度是同一树层上使用过。没有理解这两个层面上的“使用过”
    //是造成大家没有彻底理解去重的根本原因。
    //那么问题来了，我们是要同一树层上使用过，还是同一树枝上使用过呢？
    //回看一下题目，元素在同一个组合内是可以重复的，怎么重复都没事，但两个组合不能相同。
    //所以我们要去重的是同一树层上的“使用过”，同一树枝上的都是一个组合里的元素，不用去重。

    //这里的去重存在一个陷阱，如果直接在candidates[i] == candidates[i - 1]就continue，
    //那么在同一数枝上也会被跳过，而我们要实现的是在同一树层上跳过

    //两种方式，第一种好理解一点，定义一个额外的used数组，层遍历的深遍历的次序，回溯这个数组，实现记录层或者广
    //          第二种，利用startIndex
    //          由于深遍历时，每次都会更新startIndex而层遍历不会
    //          利用这一点，在i = startIndex 代表了上一步是深遍历，那么这个值就可以取，不去重
    //          如果i != startIndex代表了上一步是层遍历，要去重
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backTracing(candidates, target, 0);
        return result;
    }
    public void backTracing(int[] candidates, int target, int startIndex) {
        if (target == 0) {
            result.add(new ArrayList<Integer>(path));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            if (i > 0 && i != startIndex && candidates[i] == candidates[i - 1]) continue;
            if (candidates[i] > target) break;
            path.add(candidates[i]);
            backTracing(candidates, target - candidates[i], i + 1);
            path.removeLast();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

