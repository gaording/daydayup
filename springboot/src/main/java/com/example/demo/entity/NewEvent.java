package com.example.demo.entity;

import org.springframework.context.ApplicationEvent;

/**
 *
 * @program: daydayup
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-05-23 10:23
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-05-23 gaorunding v1.0.0 修改原因
 */
public class NewEvent extends ApplicationEvent {
    public NewEvent(Object source) {
        super(source);
    }
}
