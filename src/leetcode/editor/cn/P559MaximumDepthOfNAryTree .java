package leetcode.editor.cn;

import javax.xml.soap.Node;
import java.util.LinkedList;
import java.util.Queue;

//Java：N 叉树的最大深度
public class P559MaximumDepthOfNAryTree{
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
    public int maxDepth(Node root) {
        if (root == null) return 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int levelCount = 0;
        while (!queue.isEmpty()) {
            int num = queue.size();
            for (int i = 0; i < num; i++) {
                Node curNode = queue.poll();
                if (curNode.children != null) queue.addAll(curNode.children);
            }
            levelCount++;
        }
        return levelCount;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

