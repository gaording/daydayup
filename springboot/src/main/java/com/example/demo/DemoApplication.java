package com.example.demo;

import com.example.demo.config.MyEventPublisher;
import com.example.demo.entity.Example;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext run = SpringApplication.run(DemoApplication.class, args);
        MyEventPublisher myEventPublisher = run.getBean(MyEventPublisher.class);
        myEventPublisher.publishEvent("123");

    }


    @Bean("messageSource")
    public ResourceBundleMessageSource init() {
        ResourceBundleMessageSource source = new ResourceBundleMessageSource();
        source.setBasenames("format", "exceptions", "windows");
        return source;
    }

    @Bean
    public Example example(MessageSource messageSource) {
        Example example = new Example();
        example.setMessageSource(messageSource);
        return example;
    }

}
