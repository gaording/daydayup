package com.grd.common;

import com.grd.common.bean.Car;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * Copyright: Copyright (c) 2021 IWhaleCloud
 *
 * @program: forOffer
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-06-28 10:48
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-06-28 gaorunding v1.0.0 修改原因
 */
public class AppStarter {
    public static void main(String[] args) {
//        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("application-context.xml");
//        final Custom custom = classPathXmlApplicationContext.getBean("test", Custom.class);
//        System.out.println(custom);
        Resource classPathResource = new ClassPathResource("application-context.xml");
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(factory);
        xmlBeanDefinitionReader.loadBeanDefinitions(classPathResource);
        Car test = factory.getBean("car", Car.class);
        System.out.println(test);


    }
}
