package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

//Java：递增子序列
public class P491IncreasingSubsequences{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    //分析这题，也要所有子节点，但是要对进入的条件进行判断
    //也是给出集合有重复，但是结果要去重,也就是数层去重

    //但是这题的特殊之处在于，由于题目的特殊性，不能对其进行排序
    //所以要用另一种方式，进行同层去重
    //通过构建一个hashset确定同层以使用过的元素

    //路径，也就是树枝上，必须递增
    public List<List<Integer>> findSubsequences(int[] nums) {
        bachTracing(nums, 0);
        return result;
    }
    public void bachTracing(int[] nums, int startIndex) {
        if (path.size() > 1)
            result.add(new ArrayList<Integer>(path));
        //这里不能添加return，因为两个节点的添加了，还要添加三个节点
        //要继续执行下面的回溯
        HashSet usedSets = new HashSet<>();
        for (int i = startIndex; i < nums.length; i++) {
            if (path.size() > 0 && path.getLast() > nums[i]) continue;
            if (usedSets.contains(nums[i])) continue;
            usedSets.add(nums[i]);
            path.add(nums[i]);
            bachTracing(nums, i + 1);
            path.removeLast();
            //这里不用对usedSets进行poll，因为每个回溯中的这个不公用，会生成新的
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

