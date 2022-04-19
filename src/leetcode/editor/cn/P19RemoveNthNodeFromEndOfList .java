package leetcode.editor.cn;
//Java：删除链表的倒数第 N 个结点
public class P19RemoveNthNodeFromEndOfList{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        ListNode left = dummy;
        ListNode right = dummy;
        //right先向右走n+1步，方便左指针停在删除的前一个
        while (n-- >= 0) {
            right = right.next;
        }
        while (right != null) {
            left = left.next;
            right = right.next;
        }
        //此时情况，left指针停在了要删除结点的前面，由于n值是合法的，所以left.next也就是要删除结点一定不为空
        //所以可以用left.next.next
        //又由于用了虚拟头结点，所以left一定存在，哪怕删除的是头结点，前一节点也存在
        left.next = left.next.next;
        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

