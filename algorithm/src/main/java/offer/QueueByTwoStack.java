package offer;

import java.util.Stack;

/**
 *
 * @program: daydayup
 * @description: 两个栈实现队列操作
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-04-25 15:48
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-04-25 gaorunding v1.0.0 修改原因
 */
public class QueueByTwoStack {
    private Stack<Integer> stack1 = new Stack();
    private Stack<Integer> stack2 = new Stack();

    public void push(int node) {
        stack1.push(node);
    }

    public Integer pop() {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            throw new RuntimeException("栈为空");
        }
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
