package javademo.collection.list;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Copyright: Copyright (c) 2021 IWhaleCloud
 *
 * @program: forOffer
 * @description: 测试sort和replaceAll
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-06-02 15:10
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-06-02 gaorunding v1.0.0 修改原因
 */
public class ListTest2 {
    public static void main(String[] args) {
        var books = new ArrayList<String>();
        books.add("疯狂Java讲义");
        books.add("轻量级Java EE企业应用实战");
        books.add("疯狂Android讲义");
        books.add("疯狂ios讲义");
        books.sort((Comparator.comparingInt(String::length)));
        System.out.println(books);
        books.replaceAll(ele -> ele.length() + "");
        System.out.println(books);

        var lit = books.listIterator();
        while (lit.hasNext()) {
            System.out.println(lit.next());
            lit.add("----------");
        }
        System.out.println("=====下面开始反响迭代=======");
        while (lit.hasPrevious()) {
            System.out.println(lit.previous());
        }

    }
}
