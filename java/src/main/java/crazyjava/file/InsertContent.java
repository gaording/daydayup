package crazyjava.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @program: daydayup
 * @description: 指定文件、指定位置追加内容
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-06-26 16:05
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-06-26 gaorunding v1.0.0 修改原因
 */
public class InsertContent {
    public static void main(String[] args) throws IOException {
        var tmp = File.createTempFile("/Users/gaorunding/Study/forOffer/java/src/main/java/crazyjava/file/tmp", null);
        //使用临时文件来保存插入点后的数据
        var tmpOut = new FileOutputStream(tmp);
        var tmpIn = new FileInputStream(tmp);
    }
}
