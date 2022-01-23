package com.example.crazyjava.annotations.custom;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 *
 * @program: daydayup
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-06-23 06:56
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-06-23 gaorunding v1.0.0 修改原因
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface MyTag {
    String name() default "xx";

    int age() default 18;
}
