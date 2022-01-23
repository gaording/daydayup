package com.example.jvmdemo;

/**
 *
 * @program: daydayup
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-06-06 14:26
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-06-06 gaorunding v1.0.0 修改原因
 */
public class LocalValGC {

    public void localValGc1() {
        byte[] buffer = new byte[10 * 1024 * 1024];
        System.gc();
    }


    public void localValGc2() {
        byte[] buffer = new byte[10 * 1024 * 1024];
        buffer = null;
        System.gc();
    }


    public void localValGc3() {
        {
            byte[] buffer = new byte[10 * 1024 * 1024];

        }
        System.gc();
    }


    public void localValGc4() {
        {
            byte[] buffer = new byte[10 * 1024 * 1024];
        }
        int value = 10;
        System.gc();
    }


    public void localValGc5() {
        localValGc1();
        System.gc();
    }

    public static void main(String[] args) {
        LocalValGC localValGC = new LocalValGC();
        localValGC.localValGc5();
    }
}
