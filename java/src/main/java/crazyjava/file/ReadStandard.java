package crazyjava.file;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class ReadStandard {
    public static void main(String[] args) {
        try (
                var sc = new Scanner(System.in);
                var ps = new PrintStream(new FileOutputStream("/Users/gaorunding/Study/forOffer/java/src/main/java/crazyjava/file/out.txt"));
        ) {
            sc.useDelimiter("\n");
            while (sc.hasNext()) {
                ps.println("键盘输入的内容是:" + sc.next());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}