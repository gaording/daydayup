package com.example.jvmdemo;


import org.junit.jupiter.api.Test;

/**
 *
 * @program: daydayup
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-06-04 16:22
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-06-04 gaorunding v1.0.0 修改原因
 */
public class StringTest2 {
    @Test
    public void test1() {
        //查看class文件发现编译期常量拼接就已经优化过了
        String s1 = "a" + "b" + "c";
        String s2 = "abc";
        System.out.println(s1 == s2);
    }

    @Test
    public void test2() {
        String s1 = "javaEE";
        String s2 = "hadoop";
        String s3 = "javaEEhadoop";
        String s4 = "javaEE" + "hadoop";
        String s5 = s1 + "hadoop";
        String s6 = "javaEE" + s2;
        String s7 = s1 + s2;
        String s8 = s7.intern();
        System.out.println(s3 == s4);
        System.out.println(s3 == s5);
        System.out.println(s3 == s6);
        System.out.println(s3 == s7);
        System.out.println(s3 == s8);
        System.out.println(s5 == s6);
        System.out.println(s5 == s7);
        System.out.println(s6 == s7);
    }

    @Test
    public void test3() {
        String s1 = "a";
        String s2 = "b";
        String s3 = "ab";
        String s4 = s1 + s2;
        //输出false，s1和s2属于变量，s4内部相当于stringbuilder拼接（java8），java11就已经是makeConcatWithConstants的方法了
        System.out.println(s3 == s4);
    }

    @Test
    public void test4() {
        final String s1 = "a";
        final String s2 = "b";
        String s3 = "ab";
        String s4 = s1 + s2;
        //输出true，final修饰的变量不会修改了，所以编译期就已经优化成字符串拼接了
        System.out.println(s3 == s4);
    }

    @Test
    public void test5() {
        String s1 = "javaEEhadoop";
        String s2 = "javaEE";
        String s3 = s2 + "hadoop";
        System.out.println(s1 == s3);

        final String s4 = "javaEE";
        String s5 = s4 + "hadoop";
        System.out.println(s1 == s5);
    }

    @Test
    public void test6() {
        long start = System.currentTimeMillis();
//        stringBuilderTest(100_000);
        stringPlusTest(100_000);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }


    private String stringBuilderTest(int times) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < times; i++) {
            stringBuilder.append("a");
        }
        return stringBuilder.toString();
    }

    private String stringPlusTest(int times) {
        String res = "";
        for (int i = 0; i < times; i++) {
            res += "a";
        }
        return res;
    }
}
