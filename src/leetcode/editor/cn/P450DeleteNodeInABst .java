package leetcode.editor.cn;

import javax.swing.tree.TreeNode;

//Java：删除二叉搜索树中的节点
public class P450DeleteNodeInABst{
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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            //进行到这里就是代表要删除该节点
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            //删除结点有两个节点
            //处理策略：用右子树节点代替该节点，把左子树接到右子树的对应地方
            TreeNode tmp = root.right;
            while(tmp.left != null) {
                tmp = tmp.left;
            }
            tmp.left = root.left;
            return root.right;
        }
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

