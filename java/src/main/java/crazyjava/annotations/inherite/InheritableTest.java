package crazyjava.annotations.inherite;

/**
 *
 * @program: daydayup
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-06-23 06:53
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-06-23 gaorunding v1.0.0 修改原因
 */
public class InheritableTest extends Base {
    public static void main(String[] args) {
        System.out.println(InheritableTest.class.isAnnotationPresent(Inheritable.class));
    }
}
