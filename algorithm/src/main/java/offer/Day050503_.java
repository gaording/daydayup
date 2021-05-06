package offer;

/**
 * Copyright: Copyright (c) 2021 IWhaleCloud
 *
 * @program: forOffer
 * @description: 数组中逆序对个数
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-05-05 20:04
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-05-05 gaorunding v1.0.0 修改原因
 * 题目描述：在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P
 * 思路：本质是归并排序，在比较时加入全局变量count进行记录逆序对的个数，若data[start]>=data[index]，则count值为mid+1-start
 *
 *
 * 排序算法通通置后处置，之后统一过一遍排序算法，再刷剑指offer
 */
public class Day050503_ {
    int count = 0;

    private void merge(int[] data, int start, int mid, int end) {
        int[] arr = new int[end - start + 1];
        int c = 0;
        int s = start;
        int index = mid + 1;
        while (start <= mid && index <= mid) {
            if (data[start] < data[index]) {
                arr[c++]=data[start++];
            }else {
                arr[c++]=data[index++];
                count+=mid+1-start;
            }
        }
    }
}
