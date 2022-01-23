package com.example.crazyjava.annotations.custom;

import java.lang.annotation.Annotation;

/**
 *
 * @program: daydayup
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-06-23 07:03
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-06-23 gaorunding v1.0.0 修改原因
 */
public class AnnotationHandler {
    public static void main(String[] args) {
        Annotation[] annotations = MyClass.class.getAnnotations();
        System.out.println(annotations.length);
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
            if (annotation instanceof MyTag) {
                System.out.println(((MyTag) annotation).age());
                System.out.println(((MyTag) annotation).name());
            }
        }
    }
}
