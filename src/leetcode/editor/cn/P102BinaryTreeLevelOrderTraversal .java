package leetcode.editor.cn;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Java：二叉树的层序遍历
public class P102BinaryTreeLevelOrderTraversal{
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
    //非递归版
//    public List<List<Integer>> levelOrder(TreeNode root) {
//        List<List<Integer>> lists = new ArrayList<>();
//        if(root == null) return lists;
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.add(root);
//        while (!queue.isEmpty()) {
//            int nums = queue.size();
//            List<Integer> list = new ArrayList<>();
//            for (int i = 0; i < nums; i++) {
//                TreeNode curNode = queue.poll();
//                list.add(curNode.val);
//                if (curNode.left != null) queue.add(curNode.left);
//                if (curNode.right != null) queue.add(curNode.right);
//            }
//            lists.add(list);
//        }
//        return lists;
//    }

    //递归版
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        levelOrderRecur(root, 0, lists);
        return lists;
    }

    public void levelOrderRecur(TreeNode node, Integer deep, List<List<Integer>> resList) {
        if (node == null) return;
        deep++;

        if (resList.size() < deep) {
            //当层级增加时，list的Item也增加，利用list的索引值进行层级界定
            List<Integer> item = new ArrayList<Integer>();
            resList.add(item);
        }
        resList.get(deep - 1).add(node.val);

        levelOrderRecur(node.left, deep, resList);
        levelOrderRecur(node.right, deep, resList);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

