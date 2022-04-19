package leetcode.editor.cn;

import javax.swing.tree.TreeNode;

//Java：从前序与中序遍历序列构造二叉树
public class P105ConstructBinaryTreeFromPreorderAndInorderTraversal{
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null) return null;
        return travel(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    public TreeNode travel(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight) {
        if (preLeft > preRight) return null;
        TreeNode curNode  = new TreeNode(preorder[preLeft]);
        int i;
        for(i = inLeft; i <= inRight; i++){
            if(inorder[i] == curNode.val) break;
        }

        curNode.left = travel(preorder, preLeft + 1, preLeft + (i - inLeft), inorder, inLeft, i - 1);

        curNode.right = travel(preorder, preRight - (inRight - i - 1), preRight, inorder, i + 1, inRight);

        return curNode;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

