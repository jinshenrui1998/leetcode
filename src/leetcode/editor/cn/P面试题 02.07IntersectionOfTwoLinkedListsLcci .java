package leetcode.editor.cn;
//Java：链表相交
public class P面试题 02.07IntersectionOfTwoLinkedListsLcci{
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
//    ListNode(int x) {
//        val = x;
//        next = null;
//    }
//}
public class Solution {
    /*判断链表相交的关键在于相通一个点
      两个链表相交，那么他们的尾巴一定一样。后部分从相交的开始一定一样。
      一定呈现一个y字形，一边叉长，一边短。
      所以就用叉长的减去叉短的，之后同时向后推进，相等就是公共节点。


    * 胡思乱想：链表，一个长m，一个长n（m>=n)。
    * 那么在长链表的前m-n个结点，不可能相交。
      从m-n+1个开始判断，哪儿相等就是哪儿交的。
      过程大概描述：比如两个链表相等长度n
      先取两边的第一个节点比较，不相等。那么b链表
    * */

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = 0;
        int lengthB = 0;
        ListNode tmp = headA;
        while (tmp != null) {
            lengthA++;
            tmp = tmp.next;
        }
        tmp = headB;
        while (tmp != null) {
            lengthB++;
            tmp = tmp.next;
        }
        if (lengthA < lengthB) {
            tmp = headB;
            headB = headA;
            headA = tmp;
        }
        int dValue = lengthA > lengthB ? lengthA - lengthB : lengthB - lengthA;
        while (dValue-- > 0) {
            headA = headA.next;
        }
        while (headA != null) {
            if (headA == headB){
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

