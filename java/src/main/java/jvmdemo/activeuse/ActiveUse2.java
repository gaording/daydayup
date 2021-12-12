package jvmdemo.activeuse;

import java.io.Serializable;

/**
 *
 * @program: daydayup
 * @description: 类初始化方法触发
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-06-09 15:03
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-06-09 gaorunding v1.0.0 修改原因
 * 调用类的静态方法会触发类初始化，也即使用了invokestatic指令
 */
public class ActiveUse2 {

    public static void main(String[] args) {
        Order.method();
    }
}

class Order implements Serializable {
    static {
        System.out.println("order类的初始化过程");
    }

    public static void method() {
        System.out.println("Order method()...");
    }
}
