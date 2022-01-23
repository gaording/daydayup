package com.example.jvmdemo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @program: daydayup
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-06-07 07:52
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-06-07 gaorunding v1.0.0 修改原因
 */
public class GCUseTest {
    public static void main(String[] args) throws InterruptedException {
        List<byte[]> list = new ArrayList<>();
        while (true) {
            list.add(new byte[1024]);
            Thread.sleep(1000);
            while (list.size() > 1000) {
                list.clear();
                System.gc();
            }
        }
    }
}
