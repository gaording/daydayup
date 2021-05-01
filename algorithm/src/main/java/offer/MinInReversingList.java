package offer;

/**
 * Copyright: Copyright (c) 2021 IWhaleCloud
 *
 * @program: forOffer
 * @description: 旋转数组的最小值
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-04-25 15:57
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-04-25 gaorunding v1.0.0 修改原因
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。NOTE：给出的所有元素都大于0，若数组大小为0，请返回-1。假设数组中不存在重复元素。
 */
public class MinInReversingList {
    public static int minInReversingList(int[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] > array[mid + 1]) {
                return array[mid + 1];
            }
            if (array[mid] < array[mid - 1]) {
                return array[mid];
            }
            if (array[mid] > array[0]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public int minInReversingList2(int[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (array[mid]>array[right]){
                left=mid+1;
            }else {
                right=mid;
            }
        }
        return array[left];
    }
}
