package crazyjava.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @program: daydayup
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-06-26 14:51
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-06-26 gaorunding v1.0.0 修改原因
 * 重定向标准输入
 */
public class RedirectIn {
    public static void main(String[] args) {
        try (
                var fis = new FileInputStream("java/src/main/java/crazyjava/file/RedirectIn.java");
        ) {
            System.setIn(fis);
            var sc = new Scanner(System.in);
            sc.useDelimiter("\n");
            while (sc.hasNext()) {
                System.out.println("键盘输入的内容是：" + sc.next());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
