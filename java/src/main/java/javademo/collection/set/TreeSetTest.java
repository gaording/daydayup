package javademo.collection.set;

import java.util.TreeSet;

/**
 *
 * @program: daydayup
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-06-01 16:15
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-06-01 gaorunding v1.0.0 修改原因
 */
public class TreeSetTest {
    public static void main(String[] args) {
        var nums = new TreeSet<>();
        nums.add(5);
        nums.add(2);
        nums.add(10);
        nums.add(-9);
        System.out.println(nums);
        System.out.println(nums.first());
        System.out.println(nums.last());
        System.out.println(nums.headSet(4));
        System.out.println(nums.tailSet(5));
        System.out.println(nums.subSet(-3, 4));
    }
}
