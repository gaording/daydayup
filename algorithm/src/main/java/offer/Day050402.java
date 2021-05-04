package offer;

import java.util.Arrays;

/**
 * Copyright: Copyright (c) 2021 IWhaleCloud
 *
 * @program: forOffer
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-05-04 22:44
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-05-04 gaorunding v1.0.0 修改原因
 * 题目描述：输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个
 * 思路：先将整型数组转换成String数组，然后将String数组排序，最后将排好序的字符串数组拼接出来。关键就是制定排序规则。
 * 或使用比较和快排的思想，将前面的数和最后的数比较，若小则放到最前面，最后再递归调用。
 */
public class Day050402 {
    public String printMinNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return " ";
        }
        int len=numbers.length;
        String[] str=new String[len];
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < len; i++) {
            str[i]=String.valueOf(numbers[i]);
        }
        Arrays.sort(str);
        for (int i = 0; i < len; i++) {
            sb.append(str[i]);
        }
        return sb.toString();
    }
}
