package exception;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Copyright: Copyright (c) 2021 IWhaleCloud
 *
 * @program: forOffer
 * @description: java9甚至不要求在try之后的圆括号中声明并创建资源(要求变量是final或者是有效的final （ effectively final ）)
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-06-04 11:02
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-06-04 gaorunding v1.0.0 修改原因
 */
public class AutoCloseTest2 {
    public static void main(String[] args) throws IOException {
        final var br = new BufferedReader(new FileReader("AutoCloseTest2.java"));
        var ps = new PrintStream(new FileOutputStream("a.txt"));
        try (br; ps) {
            System.out.println(br.readLine());
            ps.println("庄生晓梦迷蝴蝶");
        }
    }
}
