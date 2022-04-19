package leetcode.editor.cn;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//Java：二叉树的中序遍历
public class P94BinaryTreeInorderTraversal{
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorderUnify(root, res);
//        inorderUnrecur(root, res);
        return res;
    }
//    public void inorder(TreeNode root, List<Integer> res) {
//        if (root == null) return;
//        inorder(root.left, res);
//        res.add(root.val);
//        inorder(root.right, res);
//    }
//    public void inorderUnrecur(TreeNode root, List<Integer> res) {
//        Stack<TreeNode> stk = new Stack<>();
//        while (!stk.isEmpty() || root != null) {
//            while (root.left != null) {
//                stk.push(root.left);
//            }
//            res.add(root.val);
//            if (root.right != null) {
//                stk.push(root.right);
//            }
//            root = stk.pop();
//        }
//    }

    //前中后序遍历统一写法
    public void inorderUnify(TreeNode root, List<Integer> res) {
        Stack<TreeNode> stk = new Stack<>();
        if (root != null) stk.add(root);
        while (!stk.isEmpty()) {
            TreeNode cur = stk.pop();
            if (cur != null) {
                if (cur.right != null) stk.push(cur.right);
                stk.push(cur);
                stk.push(null);
                if (cur.left != null) stk.push(cur.left);
            } else {
                cur = stk.pop();
                res.add(cur.val);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

