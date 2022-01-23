package com.example.crazyjava.annotations.custom;

import java.lang.reflect.InvocationTargetException;

/**
 *
 * @program: daydayup
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-06-23 07:29
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-06-23 gaorunding v1.0.0 修改原因
 */
public class RunTests {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        System.out.println(MyClass.class.getPackageName());
        System.out.println(MyClass.class.getName());
    }
}
