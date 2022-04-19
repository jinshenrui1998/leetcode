package leetcode.editor.cn;

import javax.swing.tree.TreeNode;

//Java：修剪二叉搜索树
public class P669TrimABinarySearchTree{
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
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return null;
        if (root.val > high) {
            //那么就要删除该节点及其右子树
            //第一次写 这里返了一个错误 剖析一下
            //写的是：return root.left
            //如果这么写那么在 a 层节点return到的，就是删除下层a + 1层节点，得到a + 2层节点，并且直接接上了
            //但是没有对a + 2层节点进行判断，所以也要对接上的节点进行判断
            return trimBST(root.left, low, high);
        } else if (root.val < low) {
            //那么删除该节点及其左子树
            return trimBST(root.right, low, high);
        }
        //处理当前节点符合范围的情况
        root.left = trimBST(root.left, low, high);
        //从这里也可看出如果上面return不递归，那么就只删一次，而不能重复进行判断
        root.right = trimBST(root.right, low, high);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

