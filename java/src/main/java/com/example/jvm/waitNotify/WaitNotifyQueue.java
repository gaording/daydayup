package com.example.jvm.waitNotify;

/**
 *
 * @program: daydayup
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-05-18 17:47
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-05-18 gaorunding v1.0.0 修改原因
 */
public class WaitNotifyQueue {


    public static void main(String[] args) {
        final Object o = new Object();
        new Thread(() -> {
            for (int i = 1; i < 100; i += 3) {
                synchronized (o) {
                    System.out.println(Thread.currentThread().getName() + ":" + i);
                    o.notify();
                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        new Thread(() -> {
            for (int i = 2; i < 100; i += 3) {
                synchronized (o) {
                    System.out.println(Thread.currentThread().getName() + ":" + i);
                    o.notify();
                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    public synchronized void print() {
        for (int i = 0; i <= 100; i += 2) {
            System.out.println(i);
            this.notify();
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void print2() {
        for (int i = 1; i <= 100; i += 2) {
            System.out.println(i);
            this.notify();
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
