package leetcode.editor.cn;

import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

//Java：对称二叉树
public class P101SymmetricTree{
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
/*
* 关于何时在结构中添加null节点，何时不添加
  首先我们要知道，如果在结构中（或者递归中）选择添加（或者递归）null节点，
  那么就要在从结构中取出（或者递归到）节点的时候，进行判空。
  另一种解决方式是不在结构和递归中添加null节点，那么就要在遍历（递归）每个结点时，
  对节点的左右子节点进行判断，如果不为空则添加（递归）对应的子节点。
  以上两种解决方式称为方式一和方式二
  方式一优点：只用对当前节点进行判空，写的代码少，不像方式二要对左右节点分别判空
  方式二优点：使用结构的空间更小
  故当进行到，如镜像二叉树这种题目，
  需要将两个节点的判空情况结合起来讨论的时候，方式二讨论步骤更多，更繁琐。方式一更适用。
*/
class Solution {
//    public boolean isSymmetric(TreeNode root) {
//        if (root == null) return true;
//        Queue<TreeNode> que = new LinkedList<>();
//        que.add(root.left);
//        que.add(root.right);
//        while(!que.isEmpty()) {
//            //这里的循环不再是一层处理一次，而是一对节点处理一次，这样更符合这个问题
//            TreeNode leftMirror = que.poll();
//            TreeNode rightMirror = que.poll();
//            if (leftMirror == null && rightMirror == null) {
//                continue;
//            }
//            if (leftMirror == null || rightMirror == null || leftMirror.val != rightMirror.val) {
//                return false;
//            }
//            que.add(leftMirror.left);
//            que.add(rightMirror.right);
//            que.add(leftMirror.right);
//            que.add(rightMirror.left);
//        }
//        return true;
//    }
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return compare(root.left, root.right);
    }
    public boolean compare(TreeNode leftMirror, TreeNode rightMirror) {
        if(leftMirror == null && rightMirror == null) return true;
        if(leftMirror == null || rightMirror == null || leftMirror.val != rightMirror.val) return false;

        return compare(leftMirror.left, rightMirror.right) && compare(leftMirror.right, rightMirror.left);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

