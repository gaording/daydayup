package exception;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 *
 * @program: daydayup
 * @description: java7自动关闭资源的try语句，要求资源实现了AutoCloseable或Closeable接口
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-06-04 10:57
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-06-04 gaorunding v1.0.0 修改原因
 */
public class AutoCloseTest {
    public static void main(String[] args) throws IOException {
        try (
                var br = new BufferedReader(new FileReader("AotuCloseTest.java"));
                var ps = new PrintStream(new FileOutputStream("a.txt"));
        ) {
            System.out.println(br.readLine());
            ps.println("庄生晓梦迷蝴蝶");
        }
    }
}
