package leetcode.editor.cn;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import javax.swing.tree.TreeNode;
import javax.xml.soap.Node;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Java：N 叉树的层序遍历
public class P429NAryTreeLevelOrderTraversal{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> resList = new ArrayList<>();
        if (root == null) return resList;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int num = queue.size();
            List<Integer> curList = new ArrayList<>();
            for (int i = 0; i < num; i++) {
                Node curNode = queue.poll();
                if (curNode.children != null) {
                    for (Node childNode : curNode.children) {
                        queue.add(childNode);
                    }
                }
                curList.add(curNode.val);
            }
            resList.add(curList);
        }
        return resList;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

