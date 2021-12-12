package jvmdemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 *
 * @program: daydayup
 * @description: 异常指令流测试
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-06-08 22:22
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-06-08 gaorunding v1.0.0 修改原因
 */
public class ExceptionTest {
    public void throwZero(int i) {
        if (i == 0) {
            throw new RuntimeException("参数0");
        }
    }

    public void throwOne(int i) throws RuntimeException {
        if (i == 1) {
            throw new RuntimeException("参数1");
        }
    }

    public void throwArithmetic() {
        int i = 10;
        int j = i / 0;
        System.out.println(j);
    }

    public void tryCatch() {
        File file = new File("");
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static String func() {
        String st = "hello";
        try {
            return st;
        } finally {
            st = "grd";
        }
    }

    public static void main(String[] args) {
        System.out.println(func());
    }
}
