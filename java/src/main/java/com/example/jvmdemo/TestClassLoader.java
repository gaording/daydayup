package com.example.jvmdemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 *
 * @program: daydayup
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-06-10 17:52
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-06-10 gaorunding v1.0.0 修改原因
 */
public class TestClassLoader {

    public void print() {
        System.out.println("olddemo-->");
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, InterruptedException {
        while (true) {
            ClassLoader myClassLoader = new MyClassLoader();
            Class<?> aClass = myClassLoader.loadClass("TestClassLoader");
            Object o = aClass.getDeclaredConstructor().newInstance();
            Method print = aClass.getMethod("print");
            print.invoke(o);
            Thread.sleep(1000);
        }

    }
}

class MyClassLoader extends ClassLoader {

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        if (TestClassLoader.class.getSimpleName().equals(name)) {
            try (FileInputStream fileInputStream = new FileInputStream("/Users/gaorunding/Study/forOffer/java/src/main/java/jvmdemo/TestClassLoader.class")) {
                byte[] bytes = fileInputStream.readAllBytes();
                Class<?> aClass = this.defineClass(null, bytes, 0, bytes.length);
                return aClass;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return super.loadClass(name);
    }
}