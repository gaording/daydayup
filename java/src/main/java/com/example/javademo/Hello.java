package com.example.javademo;

import java.text.MessageFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @program: daydayup
 * @description: 资源国际化
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-05-31 22:22
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-05-31 gaorunding v1.0.0 修改原因
 */
public class Hello {
    public static void main(String[] args) {
        var myLocale = Locale.getDefault(Locale.Category.FORMAT);
        var bundle = ResourceBundle.getBundle("mess", myLocale);
        System.out.println(MessageFormat.format(bundle.getString("msg"), "高润丁", new Date()));
    }
}
