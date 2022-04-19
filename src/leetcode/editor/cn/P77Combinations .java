package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//Java：组合
public class P77Combinations{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    //LinkedList中有额外的接口，比如removeLast这题要使用的等等一系列处理Last和First节点的接口
    LinkedList<Integer> curPath = new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
        backtracking(n, k, 1);
        return result;
    }
    public void backtracking(int n, int k, int startIndex) {
        //这个代码的直观思路在于，确定每个递归步骤都该干什么
        //想象成卡尔哥画的图,那么
        //1. 每个节点的任务就是处理完当前的集合，例如 2， 3， 4，添加到path，并在添加之后继续完成后序的递归
        //2. 判断curPath是否拉满，如果满了就添加到curPath

        //所以在每个结点都要用一个循环处理完当前节点的值,并且在循环中的每一步又会进行下一步的递归

        //设立返回情况，递归基这个也有一个小点
        //在于其位于循环之外，这样比如上一步添加了一个数，满了，那么到下一步的递归中，只会执行一次，而不是在循环中执行，执行多次，浪费时间

        if(curPath.size() == k) {
            //这里add添加的是对象不是基础数据类型，所以添加的是引用
            //所以如果直接店家curPath，后面的操作会对result里的结果也造成影响
            //所以要重新建立对象并添加
            result.add(new ArrayList<Integer>(curPath));
            return;
        }
        // 剪枝之前for (int i = startInde; i <= n; i++)
        // 剪枝思路: 根据当前curPath的size，确定还需要几个，根据i确定后面还有几个
        // 后面还有几个的数量 要大于等于 需要几个
        // 故而可以确定i的范围
        for(int i = startIndex; i <= n - (k - curPath.size()) + 1; i++) {
            //这里的思路，回溯的每一步都添加，在添加的基础上进行下一步，进行完成之后，删除添加
            //那么效果就是，每一步的添加都在下一步中起效果，而在上一步中不起效果
            //简单的说就是因为 下一步的代码在add和remove之间，而返回上一步在remove后面（也就是add和reove之外）
            curPath.add(i);
            backtracking(n, k, i + 1);
            curPath.removeLast();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

