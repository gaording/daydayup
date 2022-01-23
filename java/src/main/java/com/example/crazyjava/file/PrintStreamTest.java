package com.example.crazyjava.file;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 *
 * @program: daydayup
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-06-25 18:00
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-06-25 gaorunding v1.0.0 修改原因
 * printStream属于处理流，fileStream属于节点流，对节点流进行包装然后统一处理，属于装饰器模式
 */
public class PrintStreamTest {
    public static void main(String[] args) {
        try (
                var fos = new FileOutputStream("java/src/main/java/crazyjava/file/test.txt");
                var ps = new PrintStream(fos);
        ) {
            ps.println("普通字符串");
            ps.println(new PrintStreamTest());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
