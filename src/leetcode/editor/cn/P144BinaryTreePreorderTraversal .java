package leetcode.editor.cn;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

//Java：二叉树的前序遍历
public class P144BinaryTreePreorderTraversal{
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
    //List是一个对象，传入方法时是作为引用传递的,
    //如果是给list重新赋值，原来list指向的list不会改变，
    //如果是改变了里面的项，那就确实变了
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        preorderUnify(root, res);
        return res;
    }
//    递归
//    public void preOrder(TreeNode root, ArrayList<Integer> res) {
//        if (root == null) return;
//        res.add(root.val);
//        preOrder(root.left, res);
//        preOrder(root.right, res);
//    }

//    非递归
//    public void preOrderUnRecur(TreeNode root, ArrayList<Integer> res) {
//        if (root == null) return;
//        Stack<TreeNode> stack = new Stack<>();
//        stack.add(root);
//        while (!stack.isEmpty()) {
//            root = stack.pop();
//            res.add(root.val);
//            if (root.right != null)
//                stack.add(root.right);
//            if (root.left != null)
//                stack.add(root.left);
//        }
//    }

    //前中后序遍历统一写法
    public void preorderUnify(TreeNode root, List<Integer> res) {
        Stack<TreeNode> stk = new Stack<>();
        if (root != null) stk.add(root);
        while (!stk.isEmpty()) {
            TreeNode cur = stk.pop();
            if (cur != null) {
                if (cur.right != null) stk.push(cur.right);
                if (cur.left != null) stk.push(cur.left);
                stk.push(cur);
                stk.push(null);
            } else {
                cur = stk.pop();
                res.add(cur.val);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

