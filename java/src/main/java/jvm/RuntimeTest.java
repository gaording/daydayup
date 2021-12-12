package jvm;

/**
 *
 * @program: daydayup
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-06-01 12:57
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-06-01 gaorunding v1.0.0 修改原因
 */
public class RuntimeTest {
    public static void main(String[] args) throws InterruptedException {
        Runtime runtime = Runtime.getRuntime();
        System.out.println(runtime.maxMemory() / 1024 / 1024);
        System.out.println(runtime.totalMemory() / 1024 / 1024);
        Thread.sleep(1_000_000_000);
    }
}
