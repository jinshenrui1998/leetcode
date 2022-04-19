package leetcode.editor.cn;

import javax.swing.tree.TreeNode;

//Java：监控二叉树
public class P968BinaryTreeCameras{
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

// 逻辑基点：叶子结点一定没有摄像头，向上推导上面节点的状态
// 状态 0 无覆盖
//      1 有摄像头
//      2 有覆盖

class Solution {
    int count = 0;
    public int minCameraCover(TreeNode root) {
        //这里循环的逻辑 会把下面节点的无覆盖状态，拜托给上面节点覆盖一下，
        //而root节点没有上面节点所以需要手动覆盖
        if (trval(root) == 0) count++;
        return count;
    }
    public int trval(TreeNode curNode) {
        if (curNode == null) return 2;

        int left = trval(curNode.left);
        int right = trval(curNode.right);

        if (left == 0 || right == 0) {
            count++;
            return 1;
        }
        if (left == 1 || right == 1) return 2;
        if (left == 2 && right == 2) return 0;
        //逻辑走不到这里，为了让上面的逻辑完整罢了
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

