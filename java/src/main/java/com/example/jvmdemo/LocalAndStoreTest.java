package com.example.jvmdemo;

import java.util.Date;

/**
 *
 * @program: daydayup
 * @description: 字节码的指令流测试
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-06-08 10:27
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-06-08 gaorunding v1.0.0 修改原因
 */
public class LocalAndStoreTest {
    public void putConstLdc() {
        int a = -1;
        int b = 5;
        int c = 127;
        int d = 128;
        int e = 32767;
        int f = 32768;
    }

    public void constLdc() {
        long a1 = 1;
        long a2 = 2;
        float b1 = 2;
        float b2 = 3;
        double c1 = 1;
        double c2 = 2;
        Date d = null;
    }

    //3.出栈装入局部变量表指令
    public void store(int k, double d) {
        int m = k + 2;
        long l = 12;
        String str = "gaord";
        float f = 10.0F;
        d = 10;
    }

    public void foo(long l, float f) {

        {
            int i = 0;
        }
        {
            String s = "Hello,World!";
        }
    }
}
