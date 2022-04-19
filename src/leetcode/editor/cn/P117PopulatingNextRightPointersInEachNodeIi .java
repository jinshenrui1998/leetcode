package leetcode.editor.cn;
//Java：填充每个节点的下一个右侧节点指针 II
public class P117PopulatingNextRightPointersInEachNodeIi{
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
/*
* 因为必须处理树上的所有节点，所以无法降低时间复杂度，但是可以尝试降低空间复杂度。
  在方法一中，因为对树的结构一无所知，所以使用队列保证有序访问同一层的所有节点，
* 并建立它们之间的连接。然而不难发现：一旦在某层的节点之间建立了
* next 指针，那这层节点实际上形成了一个链表。
* 因此，如果先去建立某一层的 next 指针，再去遍历这一层，就无需再使用队列了。
基于该想法，提出降低空间复杂度的思路：如果第 ii 层节点之间已经建立 next 指针，
* 就可以通过 next 指针访问该层的所有节点，同时对于每个第 ii 层的节点，我们又可以通过它的
* left 和 right 指针知道其第 i+1
* i+1 层的孩子节点是什么，所以遍历过程中就能够按顺序为第i+1 层节点建立next 指针。

具体来说：
从根节点开始。因为第 0 层只有一个节点，不需要处理。可以在上一层为下一层建立
* next 指针。该方法最重要的一点是：位于第x层时为第x+1 层建立next 指针。
* 一旦完成这些连接操作，移至第x+1 层为第x+2 层建立next 指针。
当遍历到某层节点时，该层节点的next指针已经建立。
* 这样就不需要队列从而节省空间。每次只要知道下一层的最左边的节点，
* 就可以从该节点开始，像遍历链表一样遍历该层的所有节点。
*/

/*
* */
class Solution {
    //维护两个全局变量实现算法
    //last指针代表当前节点的上个节点，nextStart指针代表的是下一层的第一个结点
    Node last, nextStart;
    public Node connect(Node root) {
        if (root == null) return null;
        Node start = root;
        while (start != null) { //遍历每层
            //每层都把指针重新初始化
            last = null;
            nextStart = null;
            for (Node cur = start; cur != null; cur = cur.next) { //遍历层内每个结点
                if (cur.left != null) handle(cur.left);
                if (cur.right != null) handle(cur.right);
            }
            start = nextStart;
        }
        return root;
    }
    //使用handle函数来维护指针
    public void handle(Node p) {
        if (nextStart == null) {
            nextStart = p;
        }
        if (last != null) {
            last.next = p;
        }
        last = p;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

