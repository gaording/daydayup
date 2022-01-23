package com.example.jvmdemo;

import java.util.Random;

/**
 *
 * @program: daydayup
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-06-09 09:49
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-06-09 gaorunding v1.0.0 修改原因
 */
public class InitializationTest {

    public static int a = 1; //类初始化阶段赋值
    public static final int INT_CONSTANT = 10; //链接阶段的准备阶段赋值

    public static final Integer INTEGER_CONSTANT1 = Integer.valueOf(100); //链接阶段的准备阶段赋值
    public static Integer INTEGER_CONSTANT2 = Integer.valueOf(1000); //链接阶段的准备阶段赋值

    public static final String s0 = "hello"; //类初始化阶段赋值
    public static final String s1 = new String("hello1");//链接阶段的准备阶段赋值

    public static String s2 = "hello2";//链接阶段的准备阶段赋值

    public static final int NUM1 = new Random().nextInt(10);//链接阶段的准备阶段赋值
}
