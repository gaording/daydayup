package jvmdemo;

/**
 * 栈上分配测试
 * -Xmx1G -Xms1G -XX:-DoEscapeAnalysis -Xlog:gc*
 *
 * @author: gaorunding
 * @create: 2021-06-02 08:38
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-06-02 gaorunding v1.0.0 修改原因
 */
public class StackAllocation {
    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            alloc();
        }
        long end = System.currentTimeMillis();
        System.out.println("花费的时间为：" + (end - start) + "ms");
        Thread.sleep(10000000);
    }

    private static void alloc() {
        User user = new User();
    }

    static class User {

    }
}
