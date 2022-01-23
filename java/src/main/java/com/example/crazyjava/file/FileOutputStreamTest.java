package com.example.crazyjava.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @program: daydayup
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-06-25 17:49
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-06-25 gaorunding v1.0.0 修改原因
 */
public class FileOutputStreamTest {
    public static void main(String[] args) {
        try (
                FileInputStream fileInputStream = new FileInputStream("java/src/main/java/crazyjava/file/FileOutputStreamTest.java");
                var fos = new FileOutputStream("java/src/main/java/crazyjava/file/newFile.txt");
        ) {
            var bbuf = new byte[32];
            var hasRead = 0;
            while ((hasRead = fileInputStream.read(bbuf)) > 0) {
                fos.write(bbuf, 0, hasRead);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
