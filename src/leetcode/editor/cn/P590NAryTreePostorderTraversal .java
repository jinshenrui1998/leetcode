package leetcode.editor.cn;

import com.sun.org.apache.bcel.internal.generic.NEW;

import javax.xml.soap.Node;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//Java：N 叉树的后序遍历
public class P590NAryTreePostorderTraversal{
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
    public List<Integer> postorder(Node root) {
        List<Integer> resList = new ArrayList<>();
        if (root == null) return resList;
        Stack<Node> stk = new Stack<>();
        stk.push(root);

        while (!stk.isEmpty()) {
            Node curNode = stk.pop();
            if (curNode != null) {
                stk.push(curNode);
                stk.push(null);
                if (curNode.children != null) {
                    for (int i = 0; i < curNode.children.size(); i++) {
                        stk.push(curNode.children.get(curNode.children.size() - 1 - i));
                    }
                }
            } else {
                Node tmp = stk.pop();
                resList.add(tmp.val);
            }
        }
        return resList;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

