package leetcode.editor.cn;
//Java：环形链表 II
public class P142LinkedListCycleIi{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.*/
//class ListNode {
//    int val;
//    ListNode next;
//    ListNode(int x) {
//        val = x;
//        next = null;
//    }
//}
public class Solution {
/*
    关键细节：快慢指针相遇时，慢指针一定没走到1圈，
             快指针一定走完一圈，没走到两圈。
    原因：快指针比慢指针快一倍，如果无环，快指针跑完两遍链表
         慢指针跑一遍链表后相遇。但是由于有环，对慢指针无影响，
         而快指针到相遇前跑的路程变短，所以提前相遇，
         即快指针小于两圈就相遇。
         故慢指针跑不到一圈，而快指针跑1圈不到两圈。

    设：链表环外节点为x，快慢指针相遇前在环中的节点为y，
        快慢指针相遇后在环中的节点还剩z。
        慢指针所走路程 ：(x + y)
        快指针所走路程 ：(x + y + y + z) = (x + 2y + z)
        根据快节点比慢节点多走一倍路程列方程
        (x + y) * 2 = (x + 2y+ z)
        --->      x = z
        即环外节点数x = 环内相遇时没有走完的节点z
     即：在头结点处和快慢相遇处，重新立两个指针，这两个指针同时走，
         相遇时就走到了环入口。

*/
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            //这里循环变量没有放在最后执行，那是由于这里的特殊情况
            if (slow == fast) {
                //有环
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return fast;
            }
        }
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

