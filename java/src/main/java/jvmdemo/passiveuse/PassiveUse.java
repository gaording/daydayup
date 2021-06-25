package jvmdemo.passiveuse;

/**
 * Copyright: Copyright (c) 2021 IWhaleCloud
 *
 * @program: forOffer
 * @description: 类不初始化的调用方式
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-06-09 15:27
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-06-09 gaorunding v1.0.0 修改原因
 * 第一种调用父类的静态变量时只会初始化父类不会初始化子类
 * 第二种数组形式调用时，没有new对象时就不会初始化对应类
 * 第三种引用常量时不会触发此类或接口的初始化
 * 第四种ClassLoader的loadClass方法时不会触发其初始化
 */
public class PassiveUse {
    public static void main(String[] args) {
        System.out.println(Son.num1); //只初始化了Parent
        System.out.println(new Parent[5].length); //没有初始化Parent
    }
}

class Parent {
    static {
        System.out.println("Parent初始化调用。。。");
    }

    public static int num1 = 1;
}

class Son extends Parent {
    static {
        System.out.println("Son初始化调用...");
    }
}
