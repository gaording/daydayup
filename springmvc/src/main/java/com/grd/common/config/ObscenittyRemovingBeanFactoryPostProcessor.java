package com.grd.common.config;

import lombok.Setter;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionVisitor;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.util.StringValueResolver;

import java.util.HashSet;
import java.util.Set;

/**
 * Copyright: Copyright (c) 2021 IWhaleCloud
 *
 * @program: forOffer
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-06-30 11:04
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-06-30 gaorunding v1.0.0 修改原因
 */
public class ObscenittyRemovingBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Setter
    private Set<String> obscenties;

    public ObscenittyRemovingBeanFactoryPostProcessor() {
        this.obscenties = new HashSet<>();
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
        StringValueResolver stringValueResolver = this::replaceObscene;
        BeanDefinitionVisitor beanDefinitionVisitor = new BeanDefinitionVisitor(stringValueResolver);
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanDefinitionName);
            beanDefinitionVisitor.visitBeanDefinition(beanDefinition);
        }
    }

    public String replaceObscene(String s) {
        String s1 = s.toLowerCase();
        for (String obscenty : obscenties) {
            if (s1.contains(obscenty)) {
                int start = s1.indexOf(obscenty);
                int end = s1.indexOf(obscenty) + obscenty.length();
                return s.replace(s.substring(start, end), "***");
            }
        }
        return s;
    }
}
