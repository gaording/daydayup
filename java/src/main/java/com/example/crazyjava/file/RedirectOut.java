package com.example.crazyjava.file;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 *
 * @program: daydayup
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-06-26 14:49
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-06-26 gaorunding v1.0.0 修改原因
 */
public class RedirectOut {
    public static void main(String[] args) {
        try (
                var ps = new PrintStream(new FileOutputStream("java/src/main/java/crazyjava/file/out.txt"));
        ) {
            System.setOut(ps);
            System.out.println("普通字符串");
            System.out.println(new RedirectOut());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
