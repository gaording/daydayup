package com.example.jvmdemo;

import java.lang.reflect.Array;

/**
 *
 * @program: daydayup
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-05-28 22:04
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-05-28 gaorunding v1.0.0 修改原因
 */
public class ClassLoaderTest1 {
    public static void main(String[] args) throws NoSuchFieldException {
        System.out.println(Array.class.getDeclaredField("a"));
    }
}
