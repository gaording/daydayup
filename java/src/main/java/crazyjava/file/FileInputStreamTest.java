package crazyjava.file;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Copyright: Copyright (c) 2021 IWhaleCloud
 *
 * @program: forOffer
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-06-25 17:37
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-06-25 gaorunding v1.0.0 修改原因
 */
public class FileInputStreamTest {
    public static void main(String[] args) throws IOException {
        var fis = new FileInputStream("java/src/main/java/crazyjava/file/FileInputStreamTest.java");
        var buf = new byte[1024];
        var hasRead = 0;
        while ((hasRead = fis.read(buf)) > 0) {
            System.out.println(new String(buf, 0, hasRead));
        }
        fis.close();
    }
}
