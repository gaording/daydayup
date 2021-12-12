package com.grd.common;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @program: daydayup
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-06-28 10:48
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-06-28 gaorunding v1.0.0 修改原因
 */
public class AppStarter {
    private static final String APPLICATIOON_CONTEXT = "application-context.xml";
    public static void main(String[] args) {
//        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("application-context.xml");
//        final Custom custom = classPathXmlApplicationContext.getBean("test", Custom.class);
//        System.out.println(custom);

//        Resource classPathResource = new ClassPathResource("application-context.xml");
//        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
//        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(factory);
//        xmlBeanDefinitionReader.loadBeanDefinitions(classPathResource);
//        Car test = factory.getBean("car", Car.class);
//        System.out.println(test);

        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(APPLICATIOON_CONTEXT);
        Object user = classPathXmlApplicationContext.getBean("simpleBean");
        System.out.println(user);
        Object car = classPathXmlApplicationContext.getBean("car");
        System.out.println(car);
    }
}
