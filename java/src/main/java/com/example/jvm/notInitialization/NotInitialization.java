package com.example.jvm.notInitialization;

/**
 *
 * @program: daydayup
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-05-13 17:17
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-05-13 gaorunding v1.0.0 修改原因
 */
public class NotInitialization {
    public static void main(String[] args) {
        System.out.println(SubClass.value);
    }
}
