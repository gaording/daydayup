package lock;

/**
 *
 * @program: daydayup
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-07-11 19:39
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-07-11 gaorunding v1.0.0 修改原因
 */
public class TestSyncWait {
    public static void main(String[] args) {
        Object lock = new Object();
        Thread thread1 = new MyThread(lock);
        Thread thread2 = new MyThread(lock);
        thread1.start();
        thread2.start();
    }

    static class MyThread extends Thread {
        private Object lock;

        public MyThread(Object lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            Service service = new Service();
            service.testMethod(lock);
        }
    }
}

