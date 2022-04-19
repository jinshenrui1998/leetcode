package leetcode.editor.cn;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

//Java：二叉搜索树中的众数
public class P501FindModeInBinarySearchTree{
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
    //这题的思路并不难，难点在于要维护的变量众多，需要一个清晰的思路
    //思路就是先处理preNode和curNode变量，再根据这两个变量的关系去管理result
    List<Integer> result = new ArrayList<>();
    int maxFre = 0;
    int curFre = 0;
    TreeNode preNode;
    public int[] findMode(TreeNode root) {
        travel(root);
        int[] res = new int[result.size()];
        for(int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;
    }
    public void travel(TreeNode curNode) {
        if (curNode == null) return;
        travel(curNode.left);
        //优先维护curFre和maxFre
        if (preNode == null || preNode.val != curNode.val) {
            curFre = 1;
        } else {
            curFre++;
        }
        //维护preNode,
        preNode = curNode;

        //再根据curFre和maxFre维护result
        if (curFre > maxFre) {
            result.clear();
            result.add(curNode.val);
            maxFre = curFre;
        } else if (curFre == maxFre) {
            result.add(curNode.val);
        }
        travel(curNode.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

