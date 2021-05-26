package com.example.demo.entity;

import org.springframework.context.MessageSource;

import java.util.Locale;

/**
 * Copyright: Copyright (c) 2021 IWhaleCloud
 *
 * @program: forOffer
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-05-22 10:39
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-05-22 gaorunding v1.0.0 修改原因
 */
public class Example {
    private MessageSource messageSource;

    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public void execute() {
        String message = this.messageSource.getMessage("argument.required", new Object[]{"userDao"}, "Required", Locale.UK);
        System.out.println(message);
    }
}
