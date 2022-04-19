package leetcode.editor.cn;

import javax.swing.tree.TreeNode;

//Java：平衡二叉树
public class P110BalancedBinaryTree{
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
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        if (travelNode(root) == -1) {
            return false;
        }
        return true;
    }
    //这里的返回值并不好设置，因为这里需要两个信息
    //1.当前节点的高度
    //2.左右差是否满足条件
    //这两个信息都需要被递归返回上层 所以设个-1标记不满足条件
    public int travelNode(TreeNode root) {
        //遍历到空开始产生层数
        if (root == null) return 0;
        int leftLevel = travelNode(root.left);
        int rightLevel = travelNode(root.right);
        //先判断下面就不平衡的情况
        if (leftLevel == -1 || rightLevel == -1) return -1;
        //再判断当前是否平衡
        if (Math.abs(leftLevel - rightLevel) > 1) return -1;
        //到这里，下面和当前都平衡，那么就返回高度
        return Math.max(leftLevel, rightLevel) + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

