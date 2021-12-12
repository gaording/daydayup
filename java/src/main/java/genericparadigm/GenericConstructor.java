package genericparadigm;

/**
 *
 * @program: daydayup
 * @description: 显示声明泛型形参
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-06-04 10:37
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-06-04 gaorunding v1.0.0 修改原因
 */
public class GenericConstructor {
    static class Foo {
        public <T> Foo(T t) {
            System.out.println(t);
        }
    }

    public static void main(String[] args) {
        new Foo("疯狂Java讲义");
        new Foo(20);
        new <String>Foo("疯狂Java讲义");
//        new <String> Foo(12);
    }
}
