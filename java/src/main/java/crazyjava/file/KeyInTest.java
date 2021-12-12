package crazyjava.file;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @program: daydayup
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-06-25 18:05
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-06-25 gaorunding v1.0.0 修改原因
 */
public class KeyInTest {
    public static void main(String[] args) {
        try (
                var reader = new InputStreamReader(System.in);
                var br = new BufferedReader(reader);
        ) {
            String line = null;
            while ((line = br.readLine()) != null) {
                if (line.equals("exit")) {
                    System.exit(1);
                }
                System.out.println("输入内容为:" + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
