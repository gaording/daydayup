package crazyjava.file;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @program: daydayup
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-06-26 15:54
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-06-26 gaorunding v1.0.0 修改原因
 */
public class RandomAccessFileTest {
    public static void main(String[] args) {
        try (
                var raf = new RandomAccessFile("/Users/gaorunding/Study/forOffer/java/src/main/java/crazyjava/file/RandomAccessFileTest.java", "r");
        ) {
            //获取RandomAccessFile对象文件指针的位置，初始位置是0
            System.out.println("RandomAccessFile的文件指针的初始位置：" + raf.getFilePointer());
            //移动raf的文件记录指针的位置
            raf.seek(7);
            var bbuf = new byte[1024];
            //用于保存实际读取的字节数
            var hasRead = 0;
            //使用循环来重复"取水"过程
            while ((hasRead = raf.read(bbuf)) > 0) {
                System.out.println(new String(bbuf, 0, hasRead));
            }
            System.out.println();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
