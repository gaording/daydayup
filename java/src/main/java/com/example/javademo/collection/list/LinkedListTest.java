package com.example.javademo.collection.list;

import java.util.LinkedList;

/**
 *
 * @program: daydayup
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-06-02 17:54
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-06-02 gaorunding v1.0.0 修改原因
 */
public class LinkedListTest {
    public static void main(String[] args) {
        var books = new LinkedList<>();
        //将字符串元素加入队列的尾部
        books.offer("疯狂java讲义");
        //将字符串元素加入到栈的顶部
        books.push("轻量级java ee企业应用实战");
        //将字符串元素添加到队列的头部
        books.offerFirst("疯狂Android讲义");
        for (int i = 0; i < books.size(); i++) {
            System.out.println("遍历中：" + books.get(i));
        }
        //访问并不删除栈顶的元素
        System.out.println(books.peekFirst());
        //访问并不删除队列的最后一个元素
        System.out.println(books.peekLast());
        //将栈顶的元素弹出"栈"
        System.out.println(books.pop());
        //下面输出将看到队列中第一个元素被删除
        System.out.println(books);
        //访问并删除队列的最后一个元素
        System.out.println(books.pollLast());
        //下面输出
        System.out.println(books);
    }
}
