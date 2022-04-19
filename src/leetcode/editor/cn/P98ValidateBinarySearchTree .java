package leetcode.editor.cn;

import javax.swing.tree.TreeNode;

//Java：验证二叉搜索树
public class P98ValidateBinarySearchTree{
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
    /*
    * 究极思路（不知道这个思路就做不了)
    * 要知道中序遍历下，输出的二叉搜索树节点的数值是有序序列。*/

    //这题35%通过率，意味着陷阱非常多
    /*
    * 陷阱1
      不能单纯的比较左节点小于中间节点，右节点大于中间节点就完事了。
      因为搜索二叉树是要大于小于整颗子树才行
      陷阱1.5
      搜索二叉树不存在等于，如果等于则不是搜索二叉树。（进而可以推出搜索二叉树中没有重复元素）
      陷阱2
      样例中最小节点 可能是int的最小值，如果这样使用最小的int来比较也是不行的。
      此时可以初始化比较元素为longlong的最小值。
      问题可以进一步演进：如果样例中根节点的val 可能是longlong的最小值 又要怎么办呢？
      结论：所以避免使用最小值最大值初始化，就用第一个
    */

    /* 这题在递归过程中采取了中序遍历，在中序遍历的基础上加了判断，而且陷阱众多，有点难度
    * 总思路为：在中序遍历的前提下，记录前一个节点的值，如果后一个节点的值小于等于它那就返回false*/

    Integer preVal = null;
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        boolean left = isValidBST(root.left);
        if (!left) return false;
        if (preVal != null && root.val <= preVal) return false;
        preVal = root.val;
        return isValidBST(root.right);
    }

}
//leetcode submit region end(Prohibit modification and deletion)

