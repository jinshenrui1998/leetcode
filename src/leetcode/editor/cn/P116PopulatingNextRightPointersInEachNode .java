package leetcode.editor.cn;

import javax.swing.tree.TreeNode;
import javax.xml.soap.Node;
import java.util.LinkedList;
import java.util.Queue;

//Java：填充每个节点的下一个右侧节点指针
public class P116PopulatingNextRightPointersInEachNode{
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
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) return null;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int num = queue.size();
            //这里的sum要用Double，因为这里是int型相加可能会溢出int型
            for (int i = 0; i < num; i++) {
                Node curNode = queue.poll();
                if (i != num - 1) curNode.next = queue.peek();
                if (curNode.left != null) queue.add(curNode.left);
                if (curNode.right != null) queue.add(curNode.right);
            }
        }
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

