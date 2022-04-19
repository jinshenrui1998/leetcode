package leetcode.editor.cn;

import javax.swing.tree.TreeNode;

//Java：最大二叉树
public class P654MaximumBinaryTree{
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
    * 注意类似用数组构造二叉树的题目，每次分隔尽量不要定义新的数组，
    * 而是通过下标索引直接在原数组上操作，这样可以节约时间和空间上的开销。*/
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums == null || nums.length == 0) return null;
        return travel(nums, 0, nums.length - 1);
    }
    public TreeNode travel(int[] nums, int left, int right) {
        if (left > right) return null;
        int maxIndex = getMax(nums, left, right);
        TreeNode curNode = new TreeNode(nums[maxIndex]);
        curNode.left = travel(nums, left, maxIndex - 1);
        curNode.right = travel(nums, maxIndex + 1, right);
        return curNode;
    }
    public int getMax(int[] nums, int left, int right) {
        int max = nums[left];
        int index = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] > max) {
                index = i;
                max = nums[i];
            }
        }
        return index;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

