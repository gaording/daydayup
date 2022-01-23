package com.example.crazyjava.file;

import java.io.IOException;
import java.io.PrintStream;

/**
 *
 * @program: daydayup
 * @description: 写出流到子进程
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-06-26 15:34
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-06-26 gaorunding v1.0.0 修改原因
 */
public class WriteToProcess {
    public static void main(String[] args) throws IOException {
        Process p = Runtime.getRuntime().exec("java /Users/gaorunding/Study/forOffer/java/src/main/java/crazyjava/file/ReadStandard.java");
        try (
                var ps = new PrintStream(p.getOutputStream());
        ) {
            ps.println("普通字符串");
            ps.println(new WriteToProcess());
        }
    }
}
