package leetcode.editor.cn;

import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

//Java：另一棵树的子树
public class P572SubtreeOfAnotherTree{
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
    //自己想的 思路是 根据两个树的高差，找到root中可能成为subRoot头结点的那一层
    //进行剪枝，如果根节点值相同，进行sameTree判断
//    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
//        int rootDepth = getDepth(root);
//        int subRootDepth = getDepth(subRoot);
//        int dVlue = rootDepth - subRootDepth;
//        Queue<TreeNode> que = new LinkedList<>();
//        que.add(root);
//        for (int k = 0; k < dVlue; k++) {
//            int queSize = que.size();
//            for (int i = 0; i < queSize; i++) {
//                TreeNode tmp = que.poll();
//                if (tmp.left != null) que.add(tmp.left);
//                if (tmp.right != null) que.add(tmp.right);
//            }
//        }
//        for (TreeNode curNode : que) {
//            if (curNode.val == subRoot.val && isSame(curNode, subRoot)) {
//                return true;
//            }
//        }
//        return false;
//    }
//    public int getDepth(TreeNode curNode) {
//        if (curNode == null) return 0;
//        return Math.max(getDepth(curNode.left), getDepth(curNode.right)) + 1;
//    }
//    public boolean isSame(TreeNode curNode, TreeNode subNode) {
//        if (curNode == null && subNode == null) return true;
//        if (curNode == null || subNode == null || curNode.val != subNode.val) return false;
//        return isSame(curNode.left, subNode.left) && isSame(curNode.right, subNode.right);
//    }


    //B数是A数的子树的三种情况：(拆分为基本情况和其它子树情况（其它也为子树情况就可以用递归解决）)
    //1.B数与A树相同
    //2.B数是A数左子树的子树
    //3.B树是A树右子树的子树
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) return true;
        if (root == null) return false;
        return travelTree(root, subRoot);
    }
    public boolean travelTree(TreeNode root, TreeNode subRoot) {
        if (root == null)  return false;
        return isSameTree(root, subRoot) || travelTree(root.left, subRoot) || travelTree(root.right, subRoot);
    }
    public boolean isSameTree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null || root1.val != root2.val) return false;
        return isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

