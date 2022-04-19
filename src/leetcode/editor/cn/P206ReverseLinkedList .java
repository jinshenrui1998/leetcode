package leetcode.editor.cn;
//Java：反转链表
public class P206ReverseLinkedList{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
//*
// * Definition for singly-linked list.
//  class ListNode {
//      int val;
//      ListNode next;
//      ListNode() {}
//      ListNode(int val) { this.val = val; }
//      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//  }

//道理很简单，但是细节不简单。
//如何调控这四条语句的顺序，写成这样而不是按照常规思想，先逆转指针，之后更新循环变量，如下
/*
* head.next = pre;
* pre = head;
* head = next;
* next = next.next;*/
//这样会导致在进入循环时，next永远在head后面，从而导致head不为空的时候next先为空，调用next = next.next报错
//首先按照循环量末尾放置原则，head的更新一定要放在末尾。
//而next的更新是随着head更新的，加上next的更新不能放在末尾，所以next就放在最前面更新
//正确思路：首先确定终止状态，确定终止变量，把终止变量放在最后更新
//而其它可能会提前导致终止的变量，应该再进入循环后再更新，确保其不会提前导致循环终止
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode next;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

