package javademo;

import java.util.HashSet;

/**
 * Copyright: Copyright (c) 2021 IWhaleCloud
 *
 * @program: forOffer
 * @description: 集合遍历时的问题
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-06-01 10:59
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-06-01 gaorunding v1.0.0 修改原因
 */
public class IteratorErrorTest {
    public static void main(String[] args) {
        var books = new HashSet<>();
        books.add("轻量级Java EE企业应用实战");
        books.add("疯狂java讲义");
        books.add("疯狂Android讲义");
        var it = books.iterator();
        it.forEachRemaining(System.out::println);
        while (it.hasNext()) {
            var book = it.next();
            System.out.println(book);
            if (book.equals("疯狂Android讲义")) {
                //使用Iterator迭代过程中，不可修改集合元素
//                books.remove(book);

                //这个是可以的
                it.remove();
            }
        }
    }
}
