package leetcode.editor.cn;

import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

//Java：找树左下角的值
public class P513FindBottomLeftTreeValue{
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
    //这题简单，层序简单
//    public int findBottomLeftValue(TreeNode root) {
//        Queue<TreeNode> que = new LinkedList<>();
//        que.add(root);
//        int leftValue = root.val;
//        while(!que.isEmpty()) {
//            int curSize = que.size();
//            for(int i = 0;i < curSize;i++){
//                TreeNode curNode = que.poll();
//                if (i == 0) {
//                    leftValue = curNode.val;
//                }
//                if (curNode.left != null) que.add(curNode.left);
//                if (curNode.right != null) que.add(curNode.right);
//            }
//        }
//        return leftValue;
//    }
    int resultLeftValue = 0;
    int maxDeepth = 0;
    public int findBottomLeftValue(TreeNode root) {
        travel(root, 1);
        return resultLeftValue;
    }
    //思路：到了叶子结点才更新值。
    //优先记录深度最大的节点，同等深度的节点由于是前序 左>右，所以左边优先。右边的就不进入判断
    public void travel(TreeNode curNode, int deepth) {
        if (curNode.left == null && curNode.right == null) {
            if (deepth > maxDeepth) {
                resultLeftValue = curNode.val;
                maxDeepth = deepth;
            }
            return;
        }
        //递归之中，藏着回溯
        if (curNode.left != null) travel(curNode.left, deepth + 1);
        if (curNode.right != null) travel(curNode.right, deepth + 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

