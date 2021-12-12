package crazyjava.file;

import java.io.File;
import java.io.IOException;

/**
 *
 * @program: daydayup
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-06-25 17:00
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-06-25 gaorunding v1.0.0 修改原因
 */
public class FileTest {
    public static void main(String[] args) throws IOException {
        //以当前路径来创建一个File对象
        var file = new File(".");
        System.out.println(file.getName());
        System.out.println(file.getParent());
        System.out.println(file.getAbsoluteFile());
        System.out.println(file.getAbsoluteFile().getParent());
        File tempfile = File.createTempFile("aaa", ".txt", file);
        //当jvm退出时删除该文件
        tempfile.deleteOnExit();
        var newFile = new File(System.currentTimeMillis() + "");
        System.out.println("new File对象是否存在：" + newFile.exists());
        newFile.createNewFile();
        //返回false，因为newFile已存在
        newFile.mkdir();
        //使用list方法列出当前路径下的所有文件和路径
        String[] fileList = file.list();
        System.out.println("当前路径下所有文件和路径如下");
        for (String s : fileList) {
            System.out.println(s);
        }
        //列出磁盘所有根路径
        File[] roots = File.listRoots();
        System.out.println("系统所有根路径如下");
        for (File root : roots) {
            System.out.println(root);
        }
    }
}
