package lock;

import java.util.concurrent.TimeUnit;

/**
 * Copyright: Copyright (c) 2021 IWhaleCloud
 *
 * @program: forOffer
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-07-07 16:42
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-07-07 gaorunding v1.0.0 修改原因
 * 非阻塞状态的线程需要手动进行中断检测并结束程序
 */
public class InterruptThread {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                while (true) {
                    if (this.isInterrupted()) {
                        System.out.println("跳出循环，线程中断");
                        break;
                    }
                    System.out.println("未被中断");
                }
                System.out.println("1111");
            }
        };
        t1.start();
        TimeUnit.SECONDS.sleep(2);
        t1.interrupt();
    }
}
