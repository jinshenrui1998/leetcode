package leetcode.editor.cn;

//Java：移除链表元素
public class P203RemoveLinkedListElements {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
//*
// * Definition for singly-linked list.
//class ListNode {
//    int val;
//    ListNode next;
//
//    ListNode() {
//    }
//
//    ListNode(int val) {
//        this.val = val;
//    }
//
//    ListNode(int val, ListNode next) {
//        this.val = val;
//        this.next = next;
//    }
//}

class Solution {
    //plan1 不设置虚拟节点
    //删除head的方式和删除其它节点的方式不一样
    //1.删除head结点，head = head.next
    //2.删除其它节点, pre.next = cur.next
//    public ListNode removeElements(ListNode head, int val) {
//        //1.排除前面等于val值的节点
//        while (head != null && head.val == val) {
//            head = head.next;
//        }
//        //2.排除之后，检查节点是否为空
//        if (head == null) {
//            return null;
//        }
//        //3.当前处理的head节点一定不为空且值也不等于val
//        ListNode pre = head;
//        ListNode cur = head.next;
//        while (cur != null) {
//            if (cur.val == val) {
//                pre.next = cur.next;
//            } else {
//                pre = cur;
//            }
//            cur = cur.next;
//        }
//        return head;
//    }
    //planb 设置虚拟节点
    //以便于统一处理头结点和其它节点
    //优点，逻辑更简单，缺点消耗内存多一点点
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy;
        while (head != null) {
            if (head.val == val) {
                pre.next = head.next;
            } else {
                pre = head;
            }
            head = head.next;
        }
        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

