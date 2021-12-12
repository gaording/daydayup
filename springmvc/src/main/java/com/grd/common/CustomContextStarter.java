package com.grd.common;

import com.grd.common.context.MyClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;

/**
 *
 * @program: daydayup
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-06-29 16:17
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-06-29 gaorunding v1.0.0 修改原因
 */
public class CustomContextStarter {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new MyClassPathXmlApplicationContext("application-context.xml");
        Object test = applicationContext.getBean("test");
        System.out.println(test);
    }
}
