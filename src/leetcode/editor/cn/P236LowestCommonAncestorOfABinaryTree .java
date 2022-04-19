package leetcode.editor.cn;

import javax.swing.tree.TreeNode;

//Java：二叉树的最近公共祖先
public class P236LowestCommonAncestorOfABinaryTree{
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //这题难，难在中间处理流程的简化，模糊了子树查找到了什么节点，也利用一定有这个祖先节点模糊了左右侧查找处理情况
        //左右都有，则该节点是最近公共祖先
        //左右都没有，两个节点都还未出现过
        //左右一侧有，可能是两个节点只出现过一个，也可能是两个节点在同一侧出现过，但是处理逻辑都一样，不论是那种情况，向上返回这个就行
        if (root == null || root == p || root == q) return root;

        TreeNode curLeft = lowestCommonAncestor(root.left, p, q);
        TreeNode curRight = lowestCommonAncestor(root.right, p, q);

        if (curLeft != null && curRight != null) return root;
        if (curLeft != null) return curLeft;
        if (curRight != null) return curRight;
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

