package jvmdemo;

/**
 *
 * @program: daydayup
 * @description: 同步锁字节码测试
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-06-08 23:04
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-06-08 gaorunding v1.0.0 修改原因
 */
public class SynchronizedTest {
    private int i = 0;

    public synchronized void add() {
        i++;
    }

    private Object object = new Object();

    public void subtract() {
        synchronized (object) {
            i--;
        }
    }
}
