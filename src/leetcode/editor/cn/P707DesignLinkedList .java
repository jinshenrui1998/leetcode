package leetcode.editor.cn;
//Java：设计链表
public class P707DesignLinkedList{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
/*
* 链表类型与节点类型不同
* 链表类型中有头结点（不存储值的那种）
* 头结点为节点类型，可以设置节点为链表类型的内部类*/
class MyLinkedList {
    int size;
    ListNode head;
    public MyLinkedList() {
        this.head = new ListNode(0);
        this.size = 0;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode tmp = head;
        for (int i = 0; i <= index; i++) {
            tmp = tmp.next;
        }
        return tmp.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
            return;
        }
        ListNode tmp = head;
        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }
        tmp.next = new ListNode(val, tmp.next);
        this.size += 1;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        ListNode tmp = head;
        for (int i = 0; i <= index - 1; i++) {
            tmp = tmp.next;
        }
        tmp.next = tmp.next.next;
        this.size -= 1;
    }

    class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return val + "";
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
//leetcode submit region end(Prohibit modification and deletion)

