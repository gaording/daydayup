package com.example.javademo.homework;

/**
 * @program: daydayup
 * @description:
 * @author: gaorunding
 * @create: 2021-05-31 14:13
 */
@FunctionalInterface
public interface FunctionInstance {
    void run();
}

class FunctionTest {
    public static void execute(FunctionInstance functionInstance) {
        functionInstance.run();
    }

    public static void main(String[] args) {
        FunctionTest.execute(() -> System.out.println(1));
        ;

    }
}
