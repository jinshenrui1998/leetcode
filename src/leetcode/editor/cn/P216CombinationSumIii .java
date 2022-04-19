package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//Java：组合总和 III
public class P216CombinationSumIii{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> curPath = new LinkedList<>();
    //可以不额外设置变量记录当前总和，而通过 n 的自减，减到0就成功
    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracing(k, n, 1);
        return result;
    }
    public void backtracing(int k, int n, int startIndex) {
        if (curPath.size() == k) {
            if (n == 0) result.add(new ArrayList<Integer>(curPath));
            return;
        }
        for (int i = startIndex; i <= 10 - (k - curPath.size()) && i <= n; i++) {
            curPath.add(i);
            backtracing(k, n - i, i + 1);
            curPath.removeLast();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

