package jvm;

/**
 *
 * @program: daydayup
 * @description: 静态分派
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-05-29 10:29
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-05-29 gaorunding v1.0.0 修改原因
 */
public class StaticDispatch {
    static class Human {

    }

    static class Man extends Human {

    }

    static class Woman extends Human {

    }

    public static void sayHello(Human human) {
        System.out.println("hello guys!");
    }

    public static void sayHello(Man man) {
        System.out.println("hello gentleman!");
    }

    public static void sayHello(Woman woman) {
        System.out.println("hellp ladys!");
    }

    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();
        sayHello(man);
        sayHello(woman);
    }
}
