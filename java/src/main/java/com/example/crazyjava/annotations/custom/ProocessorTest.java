package com.example.crazyjava.annotations.custom;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 *
 * @program: daydayup
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-06-23 07:24
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-06-23 gaorunding v1.0.0 修改原因
 */
public class ProocessorTest {
    public static void process(String clazz) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        int passed = 0;
        int failed = 0;
        for (Method m : Class.forName(clazz).getMethods()) {
            if (m.isAnnotationPresent(Testable.class)) {
                m.invoke(null);
                passed++;
            } else {
                failed++;
            }
        }
        System.out.println(passed + ":" + failed);
    }
}
