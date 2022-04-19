package leetcode.editor.cn;

import javax.xml.soap.Node;
import java.util.ArrayList;
import java.util.List;

//Java：N 叉树的前序遍历
public class P589NAryTreePreorderTraversal{
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
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList();
        process(root, res);
        return res;
    }

    public void process(Node root, List<Integer> res) {
        if (root == null) return;
        res.add(root.val);
        if (root.children != null) {
            for (Node childrenNode : root.children) {
                process(childrenNode, res);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

