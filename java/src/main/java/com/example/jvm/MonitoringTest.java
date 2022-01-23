package com.example.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @program: daydayup
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-05-08 14:30
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-05-08 gaorunding v1.0.0 修改原因
 */
public class MonitoringTest {
    static class OOMObject {
        public byte[] placeholder = new byte[64 * 1024];
        public static void fillHeap(int num) throws InterruptedException {
            List<OOMObject> list=new ArrayList<>();
            for (int i = 0; i <num ; i++) {
                Thread.sleep(500);
                list.add(new OOMObject());
            }
            System.gc();
        }

        public static void main(String[] args) throws InterruptedException {
            fillHeap(1000);
        }
    }
}
