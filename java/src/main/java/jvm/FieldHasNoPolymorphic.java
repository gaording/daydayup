package jvm;

/**
 *
 * @program: daydayup
 * @description: 虚方法调用
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-05-29 11:03
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-05-29 gaorunding v1.0.0 修改原因
 */
public class FieldHasNoPolymorphic {
    static class Father {
        public int money = 1;

        public Father() {
            money = 2;
            showMoney();
        }

        public void showMoney() {
            System.out.println("i am father,i have $" + money);
        }
    }

    static class Son extends Father {
        public int money = 3;

        public Son() {
            money = 4;
            showMoney();
        }

        @Override
        public void showMoney() {
            System.out.println("i am son,i have $" + money);
        }
    }

    public static void main(String[] args) {
        Father son = new Son();
        System.out.println("i am a guy,i have $" + son.money);
    }
}
