package leetcode.editor.cn;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//Java：二叉树的后序遍历
public class P145BinaryTreePostorderTraversal{
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
//    public List<Integer> postorderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        postorder(root, res);
//        return res;
//    }
//
//    public void postorder(TreeNode root, List<Integer> res) {
//        if (root == null) return;
//        postorder(root.left, res);
//        postorder(root.right, res);
//        res.add(root.val);
//    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorderUnify(root, res);
        return res;
    }

    //前中后序遍历统一写法
    public void postorderUnify(TreeNode root, List<Integer> res) {
        Stack<TreeNode> stk = new Stack<>();
        if (root != null) stk.add(root);
        while (!stk.isEmpty()) {
            TreeNode cur = stk.pop();
            if (cur != null) {
                stk.push(cur);
                stk.push(null);
                if (cur.right != null) stk.push(cur.right);
                if (cur.left != null) stk.push(cur.left);
            } else {
                cur = stk.pop();
                res.add(cur.val);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

