package com.example.jvmdemo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @program: daydayup
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-06-06 15:25
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-06-06 gaorunding v1.0.0 修改原因
 */
public class StopTheWorldDemo {

    static List<byte[]> list = new ArrayList<>();

    public static void main(String[] args) {
        Thread worker = new Thread(() -> {
            while (true) {
                for (int i = 0; i < 1000; i++) {
                    byte[] bytes = new byte[1024];
                    list.add(bytes);
                }
                if (list.size() > 1_000_000) {
                    list.clear();
                    System.out.println("调用gc");
                    System.gc();
                }
            }
        });
        Thread timer = new Thread(() -> {
            final long startTime = System.currentTimeMillis();
            try {

                while (true) {
                    long t = System.currentTimeMillis() - startTime;
                    System.out.println(t / 1000 + "." + t % 1000);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        worker.start();
        timer.start();
    }
}
