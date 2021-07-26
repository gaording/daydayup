package com.grd.common.config;

import com.grd.common.bean.UserManager;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;

import java.util.Date;

/**
 * Copyright: Copyright (c) 2021 IWhaleCloud
 *
 * @program: forOffer
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-06-30 07:34
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-06-30 gaorunding v1.0.0 修改原因
 */
public class MyBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        System.out.println(beanName + "调用了postProcessBeforeInstantiation方法");
        return InstantiationAwareBeanPostProcessor.super.postProcessBeforeInstantiation(beanClass, beanName);
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        System.out.println(beanName + "调用了postProcessAfterInstantiation方法");
        if (bean instanceof UserManager) {
            ((UserManager) bean).setDate(new Date());
        }
        return InstantiationAwareBeanPostProcessor.super.postProcessAfterInstantiation(bean, beanName);
    }

    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        return InstantiationAwareBeanPostProcessor.super.postProcessProperties(pvs, bean, beanName);
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(beanName + "调用了postProcessBeforeInitialization方法");
        return InstantiationAwareBeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(beanName + "调用了postProcessAfterInitialization方法");
        return InstantiationAwareBeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
