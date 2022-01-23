package com.example.crazyjava.file;

import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @program: daydayup
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-06-25 17:45
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-06-25 gaorunding v1.0.0 修改原因
 */
public class FileReaderTest {
    public static void main(String[] args) {
        try (var fr = new FileReader("java/src/main/java/crazyjava/file/FileReaderTest.java")) {
            var cbuf = new char[32];
            var hasRead = 0;
            while ((hasRead = fr.read(cbuf)) > 0) {
                System.out.print(new String(cbuf, 0, hasRead));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
