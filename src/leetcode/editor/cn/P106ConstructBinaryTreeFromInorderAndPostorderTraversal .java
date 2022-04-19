package leetcode.editor.cn;

import javax.swing.tree.TreeNode;

//Java：从中序与后序遍历序列构造二叉树
public class P106ConstructBinaryTreeFromInorderAndPostorderTraversal{
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null) return null;
        return travel(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    public TreeNode travel(int[] inorder,int inBegin, int inEnd, int[] postorder, int poBegin, int poEnd) {
        //这里最主要的就是坚持循环不变量并且找准后序数组的切割关系
        //前序数组有明确的切割点，而后序数组没有
        //所以后序数组选择 从数组两端各取一次前序数组分割后长度来进行分割
        if (inBegin > inEnd) return null;
        TreeNode curNode = new TreeNode(postorder[poEnd]);
        int i;
        for (i = inBegin; i <= inEnd; i++) {
            if (inorder[i] == curNode.val) break;
        }
        curNode.left = travel(inorder, inBegin, i - 1, postorder, poBegin, poBegin + i - 1 - inBegin);
        curNode.right = travel(inorder, i + 1, inEnd, postorder, poEnd - (inEnd - i), poEnd - 1);
        return curNode;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

