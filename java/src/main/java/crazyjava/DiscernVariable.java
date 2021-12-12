package crazyjava;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 *
 * @program: daydayup
 * @description: 内部类测试
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-05-28 18:29
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-05-28 gaorunding v1.0.0 修改原因
 */
@NoArgsConstructor
@AllArgsConstructor
public class DiscernVariable {
    private String prop = "外部类的实例变量";

    private class InClass {
        private String prop = "内部类的实例变量";

        public void info() {
            var prop = "局部变量";
            System.out.println("外部类的实例变量值：" + DiscernVariable.this.prop);
            System.out.println("内部类的实例变量值：" + this.prop);
            System.out.println("局部变量：" + prop);
        }
    }

    public void test() {
        var in = new InClass();
        in.info();
    }

    public static void main(String[] args) {
        new DiscernVariable().test();
    }
}
