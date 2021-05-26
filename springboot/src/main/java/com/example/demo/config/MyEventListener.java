package com.example.demo.config;

import com.example.demo.entity.MyEvent;
import com.example.demo.entity.NewEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Copyright: Copyright (c) 2021 IWhaleCloud
 *
 * @program: forOffer
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-05-22 14:31
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-05-22 gaorunding v1.0.0 修改原因
 */
@Component
public class MyEventListener {

    @EventListener(condition = "#myEvent.source=='123'")
    public NewEvent onApplicationEvent(MyEvent myEvent) {
        System.out.println("监听到了,事件为:" + myEvent);
        return new NewEvent("myEvent:" + myEvent.getSource());
    }

    @EventListener
    public void onNewEvent(NewEvent newEvent) {
        System.out.println("监听到了newEvent:" + newEvent);
    }

    @EventListener({ContextStartedEvent.class, ContextRefreshedEvent.class})
    public void handleContextStart() {
        System.out.println("监听到了start和refresh事件");
    }
}
