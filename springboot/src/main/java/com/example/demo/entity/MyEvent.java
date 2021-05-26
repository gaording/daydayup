package com.example.demo.entity;

import org.springframework.context.ApplicationEvent;

/**
 * Copyright: Copyright (c) 2021 IWhaleCloud
 *
 * @program: forOffer
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-05-22 14:28
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-05-22 gaorunding v1.0.0 修改原因
 */
public class MyEvent extends ApplicationEvent {
    public MyEvent(Object source) {
        super(source);
    }
}
