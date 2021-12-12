package javademo.collection;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @program: daydayup
 * @description: 排序测试
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-06-03 10:09
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-06-03 gaorunding v1.0.0 修改原因
 */
public class SortTest {
    public static void main(String[] args) {
        var nums = new ArrayList<Integer>();
        nums.add(2);
        nums.add(-5);
        nums.add(3);
        nums.add(0);
        System.out.println(nums);
        Collections.reverse(nums);
        System.out.println(nums);
        Collections.sort(nums);
        System.out.println(nums);
        Collections.shuffle(nums);
        System.out.println(nums);
    }
}
