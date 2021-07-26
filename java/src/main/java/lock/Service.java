package lock;

/**
 * Copyright: Copyright (c) 2021 IWhaleCloud
 *
 * @program: forOffer
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-07-11 19:36
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-07-11 gaorunding v1.0.0 修改原因
 */
public class Service {
    public void testMethod(Object lock) {
        synchronized (lock) {
            System.out.println("begin wait()");
            try {
                lock.notify();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("end wait()");
            while (true) {

            }
        }
    }
}
