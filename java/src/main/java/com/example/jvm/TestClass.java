package com.example.jvm;

/**
 *
 * @program: daydayup
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-05-10 22:37
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-05-10 gaorunding v1.0.0 修改原因
 * 类初始化之后实例变量加载
 * <cinit>之后调用了<init>,静态变量和代码块就都赋值了，然后实例变量再调用方法invokevirtual
 */
public class TestClass {

    private static String s1 = TestA.testB();
    private String s2 = TestA.testA();

    static {
        s1 = TestA.testC();
    }

    public TestClass() {
        s2 = TestA.testD();
    }

    public static void main(String[] args) {
        TestClass testClass = new TestClass();
    }
}
