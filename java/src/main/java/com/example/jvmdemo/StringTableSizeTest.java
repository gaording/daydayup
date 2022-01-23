package com.example.jvmdemo;

/**
 *
 * @program: daydayup
 * @description: 字符串常量池大小设置 -XX:StringTableSize=1000  java8对其进行了范围限制，java11测试时又和java8不一样
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-06-04 15:22
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-06-04 gaorunding v1.0.0 修改原因
 */
public class StringTableSizeTest {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("测试字符串常量池设置");
        Thread.sleep(10_000_000);
    }
}
