package jvm.waitNotify;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @program: daydayup
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-05-26 11:24
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-05-26 gaorunding v1.0.0 修改原因
 */
public class ThreeConditionCommunicationTest {
    public static void main(String[] args) {
        final Business business = new Business();
        new Thread(business::main).start();
        new Thread(business::sub2).start();
        new Thread(business::sub3).start();
    }

    static class Business {
        Lock lock = new ReentrantLock();
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();
        Condition condition3 = lock.newCondition();
        private int shouldSub = 1;

        public void sub2() {
            lock.lock();
            try {
                for (int j = 2; j <= 100; j += 3) {
                    while (shouldSub != 2) {
                        condition2.await();
                    }
                    System.out.println(Thread.currentThread().getName() + ":" + j);
                    shouldSub = 3;
                    condition3.signal();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public void sub3() {
            lock.lock();
            try {
                for (int j = 3; j <= 100; j += 3) {
                    while (shouldSub != 3) {
                        condition3.await();
                    }
                    System.out.println(Thread.currentThread().getName() + ":" + j);
                    shouldSub = 1;
                    condition1.signal();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public void main() {
            lock.lock();
            try {
                for (int j = 1; j <= 100; j += 3) {
                    while (shouldSub != 1) {
                        condition1.await();
                    }
                    System.out.println(Thread.currentThread().getName() + ":" + j);
                    shouldSub = 2;
                    condition2.signal();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }


    }
}
