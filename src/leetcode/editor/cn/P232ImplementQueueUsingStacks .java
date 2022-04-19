package leetcode.editor.cn;

import java.util.Stack;

//Java：用栈实现队列
public class P232ImplementQueueUsingStacks{
    public static void main(String[] args) {
        Solution solution = new Solution();

        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class MyQueue {
    Stack<Integer> mainStk;
    Stack<Integer> helpStk;
    public MyQueue() {
        this.mainStk = new Stack<>();
        this.helpStk = new Stack<>();
    }
    
    public void push(int x) {
        while (!mainStk.isEmpty()) {
            helpStk.push(mainStk.pop());
        }
        helpStk.push(x);
        while (!helpStk.isEmpty()) {
            mainStk.push(helpStk.pop());
        }
    }
    
    public int pop() {
        return this.mainStk.pop();
    }
    
    public int peek() {
        return this.mainStk.peek();
    }
    
    public boolean empty() {
        return this.mainStk.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
//leetcode submit region end(Prohibit modification and deletion)

