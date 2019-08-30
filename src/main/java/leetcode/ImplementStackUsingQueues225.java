package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * description:
 * 使用队列实现栈的下列操作：
 *
 * push(x) -- 元素 x 入栈
 * pop() -- 移除栈顶元素
 * top() -- 获取栈顶元素
 * empty() -- 返回栈是否为空
 * 注意:
 *
 * 你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合法的。
 * 你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
 * 你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。
 *
 * @author 宗永飞 (yongfei.zong@ucarinc.com)
 * @version 1.0
 * @date 2019-07-02 21:46
 */
public class ImplementStackUsingQueues225 {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top());      // 2
        System.out.println(myStack.pop());      // 2
        System.out.println(myStack.empty());    // false
        System.out.println(myStack.pop());      // 1
        System.out.println(myStack.empty());    // true
    }
}

class MyStack {
    private Queue<Integer> queue1 = new LinkedList<>();
    private Queue<Integer> queue2 = new LinkedList<>();
    /** Initialize your data structure here. */
    public MyStack() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        if (!queue1.isEmpty()) {
            queue1.add(x);
        } else {
            queue2.add(x);
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if (!queue1.isEmpty()) {
            for (int i = 0, len = queue1.size() - 1; i < len; i++) {
                queue2.add(queue1.remove());
            }
            return queue1.remove();
        } else {
            for (int i = 0, len = queue2.size() - 1; i < len; i++) {
                queue1.add(queue2.remove());
            }
            return queue2.remove();
        }
    }

    /** Get the top element. */
    public int top() {
        if (!queue1.isEmpty()) {
            for (int i = 0, len = queue1.size() - 1; i < len; i++) {
                queue2.add(queue1.remove());
            }
            int res = queue1.peek();
            queue2.add(queue1.remove());
            return res;
        } else {
            for (int i = 0, len = queue2.size() - 1; i < len; i++) {
                queue1.add(queue2.remove());
            }
            int res = queue2.peek();
            queue1.add(queue2.remove());
            return res;
        }
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
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
