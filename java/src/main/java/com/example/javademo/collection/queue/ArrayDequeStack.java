package com.example.javademo.collection.queue;

import java.util.ArrayDeque;

/**
 *
 * @program: daydayup
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-06-02 17:42
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-06-02 gaorunding v1.0.0 修改原因
 */
public class ArrayDequeStack {
    public static void main(String[] args) {
        var stack = new ArrayDeque<>();
        stack.push("疯狂java讲义");
        stack.push("轻量级Java EE企业应用实战");
        System.out.println(stack);
        System.out.println(stack.peek());
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack);
    }
}
