package com.example.crazyjava;

/**
 * @program: daydayup
 * @description:
 * @author: gaorunding
 * @create: 2021-05-28 16:08
 */
public interface Output {
    int MAX_CACHE_LINE = 50;

    void out();

    void getData(String msg);

    default void print(String... msgs) {
        for (int i = 0; i < msgs.length; i++) {
            System.out.println(msgs[i]);
        }
    }

    default void test() {
        System.out.println("默认的test方法");
    }

    static String staticTest() {
        return "接口里的类方法";
    }

    private void foo() {
        System.out.println("foo私有方法");
    }

    private static void bar() {
        System.out.println("bar私有静态方法");
    }

}
