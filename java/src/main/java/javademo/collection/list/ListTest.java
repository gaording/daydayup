package javademo.collection.list;


import java.util.ArrayList;

/**
 * Copyright: Copyright (c) 2021 IWhaleCloud
 *
 * @program: forOffer
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-06-02 14:59
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-06-02 gaorunding v1.0.0 修改原因
 */
public class ListTest {
    public static void main(String[] args) {
        var books = new ArrayList<>();
        //向books集合中添加三个元素
        books.add("轻量级Java EE企业应用实战");
        books.add("疯狂Java讲义");
        books.add("疯狂Android讲义");
        books.remove(new A());
        System.out.println(books);
    }
}

class A {
    @Override
    public boolean equals(Object o) {
        return true;
    }
}
