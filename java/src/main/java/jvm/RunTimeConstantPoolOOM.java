package jvm;

/**
 *
 * @program: daydayup
 * @description: 运行时常量池导致的内存溢出异常
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-05-05 11:20
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-05-05 gaorunding v1.0.0 修改原因
 */
public class RunTimeConstantPoolOOM {
    public static void main(String[] args) {
        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);
        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);
    }
}
