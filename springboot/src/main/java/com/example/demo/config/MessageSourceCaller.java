package com.example.demo.config;

import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.stereotype.Component;

/**
 *
 * @program: daydayup
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-05-22 13:51
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-05-22 gaorunding v1.0.0 修改原因
 */
@Component
public class MessageSourceCaller implements MessageSourceAware {
    @Override
    public void setMessageSource(MessageSource messageSource) {

    }
}
