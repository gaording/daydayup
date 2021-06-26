package crazyjava.file;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PushbackReader;

/**
 * Copyright: Copyright (c) 2021 IWhaleCloud
 *
 * @program: forOffer
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-06-25 18:09
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-06-25 gaorunding v1.0.0 修改原因
 */
public class PushbackTest {
    public static void main(String[] args) {
        try (
                //指定退回缓冲区为64
                var pr = new PushbackReader(new FileReader("java/src/main/java/crazyjava/file/PushbackTest.java"), 64);
        ) {
            var buf = new char[32];
            //用以保存上次读取的字符串
            var lastContent = "";
            var hasRead = 0;
            //循环读取文件内容
            while ((hasRead = pr.read(buf)) > 0) {
                var content = new String(buf, 0, hasRead);
                var targetIndex = 0;
                //将上次读取的字符串和本次读取的字符串拼起来，查看是否包含目标字符串
                if ((targetIndex = (lastContent + content).indexOf("new PushbackReader")) > 0) {
                    //将本次内容和上次内容一起推回缓冲区
                    pr.unread((lastContent + content).toCharArray());
                    //重新定义一个长度为targetIndex的char数组
                    if (targetIndex > 32) {
                        buf = new char[targetIndex];
                    }
                    //再次读取指定长度的内容（就是目标字符串之前的内容）
                    pr.read(buf, 0, targetIndex);
                    //打印读取的内容
                    System.out.print(new String(buf, 0, targetIndex));
                    System.exit(0);
                } else {
                    System.out.print(lastContent);
                    lastContent = content;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
