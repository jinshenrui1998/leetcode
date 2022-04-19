package leetcode.editor.cn;

import sun.reflect.generics.tree.Tree;

import javax.swing.tree.TreeNode;
import java.util.Stack;

//Java：翻转二叉树
public class P226InvertBinaryTree{
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
    //注意只要把每一个节点的左右孩子翻转一下，就可以达到整体翻转的效果
    //这道题目使用前序遍历和后序遍历都可以，唯独中序遍历不方便，
    // 因为中序遍历会把某些节点的左右孩子翻转了两次！建议拿纸画一画，就理解了
    // 中序遍历：左中右，先翻转左，再翻转中，这个时候左就变成又，右就变成左，再去翻转右
    // 实际上就是最开始的左被翻转了两次
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        Stack<TreeNode> stk = new Stack<>();
        stk.push(root);

        while (!stk.isEmpty()) {
            TreeNode curNode = stk.pop();
            if (curNode != null) {
                if (curNode.right != null) stk.push(curNode.right);
                if (curNode.left != null) stk.push(curNode.left);
                stk.push(curNode);
                stk.push(null);
            } else {
                TreeNode out = stk.pop();
                TreeNode tmp = out.left;
                out.left = out.right;
                out.right = tmp;
            }
        }
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

