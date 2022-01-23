package com.example.jvmdemo;

/**
 *
 * @program: daydayup
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-05-28 21:53
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-05-28 gaorunding v1.0.0 修改原因
 */
public class ClassLoaderTest {
    public static void main(String[] args) {
//        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
//        System.out.println(systemClassLoader);
//
//        ClassLoader extClassLoader = systemClassLoader.getParent();
//        System.out.println(extClassLoader);
//
//        ClassLoader bootClassLoader = extClassLoader.getParent();
//        System.out.println(bootClassLoader);

        System.out.println(String.class.getClassLoader());
        ClassLoaderTest[] s1 = new ClassLoaderTest[10];
        System.out.println(s1.getClass().getClassLoader());
        int[] arr = new int[2];
        System.out.println(arr.getClass().getClassLoader());

    }
}
