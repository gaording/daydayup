package com.example.javademo;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @program: daydayup
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-05-31 22:28
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-05-31 gaorunding v1.0.0 修改原因
 */
public class LoggerTest {
    public static void main(String[] args) throws IOException {

        var rb = ResourceBundle.getBundle("logMess", Locale.getDefault(Locale.Category.FORMAT));

        var logger = System.getLogger("fkjava", rb);
        Logger.getLogger("fkjava").setLevel(Level.FINE);
        Logger.getLogger("fkjava").addHandler(new FileHandler("a.xml"));
        logger.log(System.Logger.Level.DEBUG, "debug信息");
        logger.log(System.Logger.Level.INFO, "info信息");
        logger.log(System.Logger.Level.ERROR, "error信息");
    }
}
