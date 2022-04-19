package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

//Java：用队列实现栈
public class P225ImplementStackUsingQueues{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class MyStack {
    Queue<Integer> mainQue;
    Queue<Integer> helpQue;

    public MyStack() {
        this.mainQue = new LinkedList<>();
        this.helpQue = new LinkedList<>();
    }
    
    public void push(int x) {
        mainQue.add(x);
        for (int i = 0; i < mainQue.size() - 1; i++) {
            mainQue.add(mainQue.poll());
        }
    }
    
    public int pop() {
        return mainQue.poll();
    }
    
    public int top() {
        return mainQue.peek();
    }

    public boolean empty() {
        return mainQue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
//leetcode submit region end(Prohibit modification and deletion)

