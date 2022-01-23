package com.example.jvmdemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @program: daydayup
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-06-01 19:41
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-06-01 gaorunding v1.0.0 修改原因
 */
public class HeapInstanceTest {

    byte[] bytes = new byte[new Random().nextInt(10)];

    public static void main(String[] args) {
        List<HeapInstanceTest> list = new ArrayList<>();
        while (true) {
            list.add(new HeapInstanceTest());
        }
    }
}
