package com.example.lock;

import java.util.concurrent.TimeUnit;

/**
 *
 * @program: daydayup
 * @description: 线程阻塞时锁中断
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-07-07 16:35
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-07-07 gaorunding v1.0.0 修改原因
 * 线程阻塞时调用interrupt造成中断异常，中断状态会复位（由中断改为非中断）
 */
public class InterruptSleepThread {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    System.out.println("Interruted when Sleep");
                    boolean interrupt = this.isInterrupted();
                    System.out.println("interrupt:" + interrupt);
                }
            }
        };
        t1.start();
//        TimeUnit.SECONDS.sleep(2);
        t1.interrupt();
    }
}
