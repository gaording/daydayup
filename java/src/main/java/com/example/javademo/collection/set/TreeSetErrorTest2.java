package com.example.javademo.collection.set;

import java.util.Date;
import java.util.TreeSet;

/**
 *
 * @program: daydayup
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-06-01 16:18
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-06-01 gaorunding v1.0.0 修改原因
 */
public class TreeSetErrorTest2 {
    public static void main(String[] args) {
        var ts = new TreeSet<>();
        ts.add(new String("疯狂java讲义"));
        ts.add(new Date());
    }
}
