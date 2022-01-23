package com.example.jvmdemo.activeuse;

import java.util.Random;

/**
 *
 * @program: daydayup
 * @description: 类初始化的几种触发方式
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-06-09 14:49
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-06-09 gaorunding v1.0.0 修改原因
 * 第一种是调用new、clone、反序列化等方式，不做展示
 * 第二种调用静态方法
 * 第三种调用静态变量（非常量）
 * 第四种反射调用类
 * 第五种初始化子类时先调用父类的初始化方法，但父接口并不会初始化
 * 第六种methodHandle方法的调用，其实还是反射调用
 * 第七中interface中的default方法调用时，接口会初始化
 * 第八种main方法调用时，main方法对应的类会初始化
 */
public class ActiveUse3 {
    public static void main(String[] args) throws ClassNotFoundException {
//        System.out.println(User.num);  //类初始化
//        System.out.println(User.num2); //不会初始化
//        System.out.println(User.num3); //会初始化
        Class.forName("com.example.jvmdemo.activeuse.User"); //会初始化
        System.out.println(Son.num); //Son和User都会初始化,run不会初始化，除非声明了default方法

    }
}

class User {
    static {
        System.out.println("User类的初始化过程");
    }

    public static int num = 1;
    public static final int num2 = 1;
    public static final int num3 = new Random().nextInt();
}

interface run {
    Thread t = new Thread() {
        {
            System.out.println("run...");
        }
    };

    default void test() {

    }


}

class Son extends User implements run {
    static {
        System.out.println("Son类的初始化过程");
    }

    public static int num = 1;
}

interface CompareA {
    Thread t = new Thread() {
        {
            System.out.println("compareA初始化");
        }
    };

    int NUM1 = 1;
}
