package com.example.javademo;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 *
 * @program: daydayup
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-05-31 21:36
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-05-31 gaorunding v1.0.0 修改原因
 */
public class MethodHandleTest {
    private static void hello() {
        System.out.println("Hello World!");
    }

    private String hello(String name) {
        System.out.println("执行带参数的hello" + name);
        return name + ",您好";
    }

    public static void main(String[] args) throws Throwable {
        var type = MethodType.methodType(void.class);
        var mtd = MethodHandles.lookup().findStatic(MethodHandleTest.class, "hello", type);
        mtd.invoke();
        var mtd2 = MethodHandles.lookup().findVirtual(MethodHandleTest.class, "hello", MethodType.methodType(String.class, String.class));
        System.out.println(mtd2.invoke(new MethodHandleTest(), "孙悟空"));

    }
}
