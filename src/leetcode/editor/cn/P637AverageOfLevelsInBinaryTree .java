package leetcode.editor.cn;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Java：二叉树的层平均值
public class P637AverageOfLevelsInBinaryTree{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    //一个小经验：不是这题，是所有对于树的所有题。
    //如何处理null
    //如果是递归，通常在是否递归时不会处理,
    //而是在递归了之后如果为null则作为递归基return
    //如果不是递归
    //通常会在加入结构（队列或者栈）前判断是否为空，为空就不加入
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int num = queue.size();
            //这里的sum要用Double，因为这里是int型相加可能会溢出int型
            Double sum = 0.0;
            for (int i = 0; i < num; i++) {
                TreeNode curNode = queue.poll();
                sum += curNode.val;
                if (curNode.left != null) queue.add(curNode.left);
                if (curNode.right != null) queue.add(curNode.right);
            }
            res.add((1.0 * sum / num));
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

