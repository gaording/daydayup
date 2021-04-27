/**
 * Copyright: Copyright (c) 2021 IWhaleCloud
 *
 * @program: forOffer
 * @description: 将数组中奇数放到偶数前
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-04-27 17:59
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-04-27 gaorunding v1.0.0 修改原因
 * 题目描述：输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变
 * 思路：使用双指针法，或移动偶数位置
 */
public class ReOrderArray {
    public void reOrderArray(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            while (array[left] % 2 == 1) {
                left++;
            }
            while (array[right] % 2 == 0) {
                right--;
            }
            if (left < right) {
                int swap = array[left];
                array[left] = array[right];
                array[right] = swap;
            }
        }
    }
}
