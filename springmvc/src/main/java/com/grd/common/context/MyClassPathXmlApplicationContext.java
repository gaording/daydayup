package com.grd.common.context;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Copyright: Copyright (c) 2021 IWhaleCloud
 *
 * @program: forOffer
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-06-29 15:31
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-06-29 gaorunding v1.0.0 修改原因
 */
public class MyClassPathXmlApplicationContext extends ClassPathXmlApplicationContext {
    public MyClassPathXmlApplicationContext() {
    }

    public MyClassPathXmlApplicationContext(ApplicationContext parent) {
        super(parent);
    }

    public MyClassPathXmlApplicationContext(String configLocation) throws BeansException {
        super(configLocation);
    }

    public MyClassPathXmlApplicationContext(String... configLocations) throws BeansException {
        super(configLocations);
    }

    public MyClassPathXmlApplicationContext(String[] configLocations, ApplicationContext parent) throws BeansException {
        super(configLocations, parent);
    }

    public MyClassPathXmlApplicationContext(String[] configLocations, boolean refresh) throws BeansException {
        super(configLocations, refresh);
    }

    public MyClassPathXmlApplicationContext(String[] configLocations, boolean refresh, ApplicationContext parent) throws BeansException {
        super(configLocations, refresh, parent);
    }

    public MyClassPathXmlApplicationContext(String path, Class<?> clazz) throws BeansException {
        super(path, clazz);
    }

    public MyClassPathXmlApplicationContext(String[] paths, Class<?> clazz) throws BeansException {
        super(paths, clazz);
    }

    public MyClassPathXmlApplicationContext(String[] paths, Class<?> clazz, ApplicationContext parent) throws BeansException {
        super(paths, clazz, parent);
    }

    @Override
    protected void initPropertySources() {
        getEnvironment().setRequiredProperties("var");
    }

    /**
     * 定制化factory
     *
     * @param beanFactory
     */
    @Override
    protected void customizeBeanFactory(DefaultListableBeanFactory beanFactory) {
        setAllowBeanDefinitionOverriding(true);
        setAllowCircularReferences(true);
        super.customizeBeanFactory(beanFactory);
    }


}
