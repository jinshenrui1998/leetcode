package leetcode.editor.cn;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

//Java：二叉搜索树的最小绝对差
public class P530MinimumAbsoluteDifferenceInBst{
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
//    这里为什么不初始化minDif 是怕测试用例中有相等的用例
//    但是这题的val范围在10^5内，所以不会出现差值等于或者大于Integer的最大值
//    所以其实不用初始化
//    递归版
//    Integer preVal;
//    Integer minDif;
//    public int getMinimumDifference(TreeNode root) {
//        travel(root);
//        return minDif;
//    }
//    public void travel(TreeNode curNode) {
//        if (curNode == null) return;
//        travel(curNode.left);
//        if (preVal != null && minDif == null) {
//            minDif = Math.abs(curNode.val - preVal);
//        } else if (preVal != null && Math.abs(curNode.val - preVal) < minDif) {
//            minDif = Math.abs(curNode.val - preVal);
//        }
//        preVal = curNode.val;
//        travel(curNode.right);
//    }
    //非递归用栈解决版
    public int getMinimumDifference(TreeNode root) {
        int minDif = Integer.MAX_VALUE;
        TreeNode pre = null;
        Stack<TreeNode> stk = new Stack<>();
        TreeNode cur = root;
        while(!stk.isEmpty() || cur != null) {
            if (cur != null) {
                stk.push(cur);
                cur = cur.left;
            }
            else {
                cur = stk.pop();
                if (pre != null) minDif = Math.min(minDif, cur.val - pre.val);
                pre = cur;
                cur = cur.right;
            }
        }
        ArrayList<String> list=new ArrayList<String>();
        return minDif;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

