package javademo;

import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

/**
 * Copyright: Copyright (c) 2021 IWhaleCloud
 *
 * @program: forOffer
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-06-01 11:16
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-06-01 gaorunding v1.0.0 修改原因
 */
public class PredicateTest2 {
    public static void main(String[] args) {
        List books = List.of("疯狂java讲义", "疯狂Android讲义", "疯狂ios讲义", "疯狂Ajax讲义");
        System.out.println(callAll(books, ele -> ((String) ele).contains("java")));
        System.out.println(callAll(books, ele -> ((String) ele).contains("疯狂")));
        System.out.println(callAll(books, ele -> ((String) ele).length() > 10));
    }

    public static int callAll(Collection books, Predicate p) {
        int total = 0;
        for (var book : books) {
            if (p.test(book)) {
                total++;
            }
        }
        return total;
    }
}
