package javademo.collection;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @program: daydayup
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-06-03 12:37
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-06-03 gaorunding v1.0.0 修改原因
 */
public class SearchTest {
    public static void main(String[] args) {
        var nums = new ArrayList<Integer>();
        nums.add(2);
        nums.add(-5);
        nums.add(3);
        nums.add(0);
        System.out.println(nums);
        //最大
        System.out.println(Collections.max(nums));
        //最小
        System.out.println(Collections.min(nums));
        //替换
        Collections.replaceAll(nums, 0, 1);
        System.out.println(nums);
        //查找出现次数
        System.out.println(Collections.frequency(nums, -5));
        //排序
        Collections.sort(nums);
        System.out.println(nums);
        //排序后才能二分查找
        System.out.println(Collections.binarySearch(nums, 3));

    }
}
