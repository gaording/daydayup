package com.example.crazyjava.file;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @program: daydayup
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-06-26 16:01
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-06-26 gaorunding v1.0.0 修改原因
 */
public class AppendContent {
    public static void main(String[] args) {
        try (
                var raf = new RandomAccessFile("/Users/gaorunding/Study/forOffer/java/src/main/java/crazyjava/file/out.txt", "rw");
        ) {
            raf.seek(raf.length());
            raf.write("追加的内容!\r\n".getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
