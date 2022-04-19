package leetcode.editor.cn;

import javax.swing.tree.TreeNode;

//Java：左叶子之和
public class P404SumOfLeftLeaves{
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
    //这题有两个点很关键
    //1.左叶子，代表是 左 加叶子
    //左这个信息是在上层节点，叶子这个信息是在当前层节点，所以只能跨层解决
    //2.跨层解决方案：对每个结点判断如果他左节点是叶子，那么就加上它左节点的值
    //这个逻辑可以处理所有节点，就不用进行额外处理，但是要注意指针不为空
    //而这个方案导致了，这题虽然要判断叶子结点，但是是在叶子结点的上一层判断，所以不用叶子结点的基底解决放
    //而是优先保证这个跨层方案不为空
    //重点tips1：不是每个递归都要添加process
    //重点tips2：以叶子结点为基底的处理方案，都需要process，因为需要在本来的原生函数上加一句 if(root == null)
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        int num = 0;
        if (root.left != null && root.left.left == null && root.left.right == null)
            num = root.left.val;
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right) + num;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

