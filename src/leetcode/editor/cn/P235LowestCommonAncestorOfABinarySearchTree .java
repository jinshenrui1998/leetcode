package leetcode.editor.cn;

import javax.swing.tree.TreeNode;

//Java：二叉搜索树的最近公共祖先
public class P235LowestCommonAncestorOfABinarySearchTree{
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
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    //想清楚如何利用搜索二叉树的性质就可以
    //自己的
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int min = Math.min(p.val, q.val);
        int max = Math.max(p.val, q.val);
        return travel(root, min, max);
    }
    public TreeNode travel(TreeNode curNode, int min, int max){
        if (curNode.val < min) {
            return travel(curNode.right, min, max);
        } else if(curNode.val > max) {
            return travel(curNode.left, min, max);
        }
        return curNode;
    }
//        卡尔的方法
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        if (root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left, p, q);
//        if (root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right, p, q);
//        return root;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

