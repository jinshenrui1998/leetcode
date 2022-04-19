package leetcode.editor.cn;

import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

//Java：二叉树的最小深度
public class P111MinimumDepthOfBinaryTree{
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
//    public int minDepth(TreeNode root) {
//        if (root == null) return 0;
//        int res = 0;
//
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.add(root);
//        while (!queue.isEmpty()) {
//            int num = queue.size();
//            //这里的sum要用Double，因为这里是int型相加可能会溢出int型
//            for (int i = 0; i < num; i++) {
//                TreeNode curNode = queue.poll();
//                if (curNode.left == null && curNode.right == null) {
//                    return res + 1;
//                }
//                if (curNode.left != null) queue.add(curNode.left);
//                if (curNode.right != null) queue.add(curNode.right);
//            }
//            res++;
//        }
//        return res;
//    }
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        return getMinDepth(root);
    }
    public int getMinDepth(TreeNode curNode) {
        if (curNode == null) return 0;
        if (curNode.left == null && curNode.right == null) {
            return 1;
        } else if (curNode.left == null){
            return getMinDepth(curNode.right) + 1;
        } else if (curNode.right == null) {
            return getMinDepth(curNode.left) + 1;
        } else {
            return Math.min(getMinDepth(curNode.left), getMinDepth(curNode.right)) + 1;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

