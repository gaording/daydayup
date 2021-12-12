package com.example.demo.entity;

/**
 *
 * @program: daydayup
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-05-23 10:11
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-05-23 gaorunding v1.0.0 修改原因
 */
public class TestJobFunction {
    public static void main(String[] args) {
        testJobExecute(() -> System.out.println(1));
    }

    private static void testJobExecute(JobFunction jobFunction) {
        jobFunction.execute();
    }
}
