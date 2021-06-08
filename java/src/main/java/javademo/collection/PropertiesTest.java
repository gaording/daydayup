package javademo.collection;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Copyright: Copyright (c) 2021 IWhaleCloud
 *
 * @program: forOffer
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-06-02 20:11
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-06-02 gaorunding v1.0.0 修改原因
 */
public class PropertiesTest {
    public static void main(String[] args) throws IOException {
        var props = new Properties();
        //向Properties中添加属性
        props.setProperty("username", "yeeku");
        props.setProperty("password", "123456");
        File file = new File("a.properties");
        System.out.println(file.createNewFile());
        props.store(new FileOutputStream(file), "comment line");
        var props2 = new Properties();
        props2.setProperty("gemder", "male");
        props2.load(new FileInputStream(file));
        System.out.println(props2);
    }
}
