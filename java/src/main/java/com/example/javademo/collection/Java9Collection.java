package com.example.javademo.collection;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @program: daydayup
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-06-03 18:34
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-06-03 gaorunding v1.0.0 修改原因
 */
public class Java9Collection {
    public static void main(String[] args) {
        var set = Set.of("Java", "Kootlin", "Go", "Swift");
        System.out.println(set);
//        set.add("Ruby");
        var list = List.of(34, -25, 67, 231);
        System.out.println(list);
        var map = Map.of("语文", 89, "数学", 92, "英语", 92);
        System.out.println(map);
        var map2 = Map.ofEntries(Map.entry("语文", 89), Map.entry("数学", 82), Map.entry("英语", 92));
        System.out.println(map2);
    }
}
