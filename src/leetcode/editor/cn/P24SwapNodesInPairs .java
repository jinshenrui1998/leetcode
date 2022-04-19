package leetcode.editor.cn;
//Java：两两交换链表中的节点
public class P24SwapNodesInPairs{
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
    public ListNode swapPairs(ListNode head) {
        //设置虚拟头结点辅助
        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy;
        while (head != null && head.next != null) {
            //链表优先保存前指针
            //这里主要的思路是：
            //1.先画图
            //2.后根据需求改变指针
            //3.如果在改变直接的时候丢失了一个节点指不到了，就在前面的合适的位置定义一个
            //4.根据整理后的指针情况，画图
            //5.最后根据当前指针情况，把遍历指针++
            ListNode tmp = head.next.next;
            pre.next = head.next;
            head.next.next = head;
            head.next = tmp;
            pre = head;
            head = head.next;
        }
        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

