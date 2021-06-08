package javademo.collection.queue;

import java.util.ArrayDeque;

/**
 * Copyright: Copyright (c) 2021 IWhaleCloud
 *
 * @program: forOffer
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-06-02 17:47
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-06-02 gaorunding v1.0.0 修改原因
 */
public class ArrayDequeQueue {
    public static void main(String[] args) {
        ArrayDeque queue = new ArrayDeque();
        //依次将三个元素加入队列
        queue.offer("疯狂java讲义");
        queue.offer("轻量级java EE企业应哟哦那个实战");
        queue.offer("疯狂Android讲义");
        //输出
        System.out.println(queue);
        //
        System.out.println(queue.peek());
        System.out.println(queue);
        System.out.println(queue.poll());
        System.out.println(queue);
    }
}
