package leetcode.editor.cn;

import javax.swing.tree.TreeNode;

//Java：路径总和
public class P112PathSum{
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
    //递归回溯问题
    //如果有某一个值需要回溯，例如这题的curSum
    //方法1:选择栈做poll 在每次遍历之后
    //方法2:做值传递，不做引用传递，这样就在函数里下层函数里更改该变量就不影响上层
//    public boolean hasPathSum(TreeNode root, int targetSum) {
//        if (root == null) return false;
//        return process(root, targetSum, 0);
//    }
//    public boolean process(TreeNode root, int target, int curSum) {
//        curSum += root.val;
//        if (root.left == null && root.right == null) {
//            return curSum == target;
//            //if (curSum == target) return true;
//            //return false;由这个简化
//            //这个简化思想可以学习
//            //进入这个条件就一定要return结果的才适合
//        }
//        if (root.left != null && root.right != null) {
//            return process(root.left, target, curSum) || process(root.right, target, curSum);
//        }
//        if (root.left != null)
//            return process(root.left, target, curSum);
//        else
//            return process(root.right, target, curSum);
//    }
    //精简 加转化为减
//    public boolean hasPathSum(TreeNode root, int targetSum) {
//        if (root == null) return false;
//        return process(root, targetSum);
//    }
//    public boolean process(TreeNode root, int target) {
//        target -= root.val;
//        if (root.left == null && root.right == null) {
//            return target == 0;
//            //if (curSum == target) return true;
//            //return false;由这个简化
//            //这个简化思想可以学习
//            //进入这个条件就一定要return结果的才适合
//        }
//        if (root.left != null && root.right != null) {
//            return process(root.left, target) || process(root.right, target);
//        }
//        if (root.left != null)
//            return process(root.left, target);
//        else
//            return process(root.right, target);
//    }
    //再次精简
    public boolean hasPathSum(TreeNode root, int targetSum) {
        //这一句和第三句结合，解决为空问题后就可以直接套用递归而不用判断
        if (root == null) return false; // 为空退出

        // 叶子节点判断是否符合
        if (root.left == null && root.right == null) return root.val == targetSum;

        // 求两侧分支的路径和
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

