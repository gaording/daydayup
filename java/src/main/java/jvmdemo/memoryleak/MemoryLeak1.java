package jvmdemo.memoryleak;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright: Copyright (c) 2021 IWhaleCloud
 *
 * @program: forOffer
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-06-16 12:01
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-06-16 gaorunding v1.0.0 修改原因
 * 1.静态变量导致内存泄露
 * 2.单例模式导致内存泄露
 * 3.外部类中的内部类对象被引用也会导致外部类对象无法被回收
 * 4.各种连接，数据库连接、网络连接、IO连接等未被关闭
 * 5.变量不合理的作用域
 * 6.改变哈希值，hashset、hashmap的问题
 * 7.缓存泄露。比如加载表的数据到缓存中，生产环境数据比开发环境数据大很多
 * 8.监听器和回调：客户端注册了回调却没有取消
 * 9.ThreadLocal的内存泄露
 * 自己写element的pop操作时，不要直接返回成员变量数组的值，然后更改索引。应该新建一个局部变量接收数组的值，然后数组的对应值置空
 */
public class MemoryLeak1 {
    static List list = new ArrayList();

    public void oomTest() {
        Object o = new Object();
        list.add(o);
    }
}
