package javademo;

import java.lang.invoke.MethodHandles;
import java.util.Arrays;

/**
 *
 * @program: daydayup
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-05-31 21:59
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-05-31 gaorunding v1.0.0 修改原因
 */
public class VarHandleTesr {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        var sa = new String[]{"java", "kotlin", "go"};
        var avh = MethodHandles.arrayElementVarHandle(String[].class);

        var r = avh.compareAndSet(sa, 2, "go", "lua");

        System.out.println(r);
        //看到第三个元素被替换成Lua
        System.out.println(Arrays.toString(sa));
        //获取sa数组的第二个元素
        System.out.println(avh.get(sa, 1));
        //获取并设置，返回第三个元素，并将第三个元素设为Swift
        System.out.println(avh.getAndSet(sa, 2, "Swift"));
        //看到点个元素被替换成Swift
        System.out.println(Arrays.toString(sa));

        //用findVarHandle方法获取User类中名为name、类型为String的实例变量
        var vh1 = MethodHandles.lookup().findVarHandle(User.class, "name", String.class);
        var user = new User();
        //通过varHandle获取实例变量的值，需要传入对象作为调用者
        System.out.println(vh1.get(user));
        //通过varHandle设置指定实例变量的值
        vh1.set(user, "孙悟空");
        //输出user的name实例变量的值
        System.out.println(user.name);
        //用findVarHandle方法获取user类中名为MAX_AGE，类型为Integer的类变量
        var vh2 = MethodHandles.lookup().findStaticVarHandle(User.class, "MAX_AGE", int.class);
        //通过VarHandle获取指定类变量的值
        System.out.println(vh2.get());
        //通过VarHandle设置指定类变量的值
        vh2.set(100);
        //输出User的MAX_AGE类变量
        System.out.println(User.MAX_AGE);


    }
}

class User {
    String name;
    static int MAX_AGE;
}
