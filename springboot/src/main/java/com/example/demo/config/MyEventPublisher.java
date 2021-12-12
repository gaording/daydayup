package com.example.demo.config;

import com.example.demo.entity.MyEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

/**
 *
 * @program: daydayup
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-05-22 15:26
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-05-22 gaorunding v1.0.0 修改原因
 */
@Component
public class MyEventPublisher implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void publishEvent(Object source) {
        applicationEventPublisher.publishEvent(new MyEvent(source));
    }
}
