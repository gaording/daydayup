package crazyjava.file;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @program: daydayup
 * @description: 读取process子进程中的输入流
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-06-26 15:25
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-06-26 gaorunding v1.0.0 修改原因
 */
public class ReadFromProcess {
    public static void main(String[] args) throws IOException {
        Process p = Runtime.getRuntime().exec("javac");
        try (
                var br = new BufferedReader(new InputStreamReader(p.getInputStream()));
        ) {
            String buff = null;
            while ((buff = br.readLine()) != null) {
                System.out.println(buff);
            }
        }
    }
}
