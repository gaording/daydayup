package com.grd.common.parser;

import com.grd.common.bean.Custom;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

/**
 * Copyright: Copyright (c) 2021 IWhaleCloud
 *
 * @program: forOffer
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-06-28 10:49
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-06-28 gaorunding v1.0.0 修改原因
 */
public class CustomBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {
    @Override
    protected Class<?> getBeanClass(Element element) {
        return Custom.class;
    }

    @Override
    protected void doParse(Element element, BeanDefinitionBuilder builder) {
        final String id = element.getAttribute("id");
        final String name = element.getAttribute("name");
        final String remark = element.getAttribute("remark");
        if (StringUtils.hasText(id)) {
            builder.addPropertyValue("id", id);
        }
        if (StringUtils.hasText(name)) {
            builder.addPropertyValue("name", name);
        }
        if (StringUtils.hasText(remark)) {
            builder.addPropertyValue("remark", remark);
        }

    }


}
