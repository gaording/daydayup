package offer;

import java.util.Stack;

/**
 *
 * @program: daydayup
 * @description: 定义一个有min函数的栈
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-04-30 14:11
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-04-30 gaorunding v1.0.0 修改原因
 *题目描述：定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 * 思路：定义两个栈，一个存放入的值。另一个存最小值。
 * pop的时候有疑问
 */
public class Day043002 {

    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public void push(int node) {
        stack1.push(node);
        if (stack2.isEmpty()){
            stack2.push(node);
        }else {
            if (stack2.peek()>node){
                stack2.push(node);
            }else {
                Stack<Integer> tmp=new Stack<>();
                tmp.push(stack2.pop());
                while (!stack2.isEmpty()&&stack2.peek()>node){
                    tmp.push(stack2.pop());
                }
                stack2.push(node);
                while (!tmp.isEmpty()){
                    stack2.push(tmp.pop());
                }
            }
        }
    }

    public void pop(){
        //不等于时候咋办，pop之后最小值就可能不对了
        if (stack1.pop()==stack2.peek()){
            stack2.pop();
        }
    }

    public int top(){
        return stack1.peek();
    }

    public int min(){
        return stack2.peek();
    }
}
