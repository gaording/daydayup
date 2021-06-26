package crazyjava.file;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Copyright: Copyright (c) 2021 IWhaleCloud
 *
 * @program: forOffer
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-06-25 17:54
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-06-25 gaorunding v1.0.0 修改原因
 */
public class FileWriterTest {
    public static void main(String[] args) {
        try (
                var fw = new FileWriter("java/src/main/java/crazyjava/file/poem.txt");
        ) {
            fw.write("琴瑟和谐\r\n");
            fw.write("万物共生\r\n");
            fw.write("人与自然\r\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
