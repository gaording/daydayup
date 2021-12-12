package offer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @program: daydayup
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-05-02 19:29
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-05-02 gaorunding v1.0.0 修改原因
 * 题目描述：输入n个整数，找出其中最小的K个数。
 * 思路：先将前K个数放入数组，进行堆排序，若之后的数比它还小，则进行调整
 */
public class Day050201 {

    public ArrayList<Integer> getLeastNumbersSolution(int[] input,int k){
        ArrayList<Integer> list=new ArrayList<>();
        if (input==null||k<=0||k>input.length){
            return list;
        }
        int[] kArray= Arrays.copyOfRange(input,0,k);
        buildHeap(kArray);
        for (int i = k; i < input.length; i++) {
            if (input[i]<kArray[0]){
                kArray[0]=input[i];
                maxHeap(kArray,0);
            }
        }
        return list;
    }

    public void buildHeap(int[] input){
        for (int i = input.length/2-1; i >=0 ; i--) {
            maxHeap(input,i);
        }
    }

    private void maxHeap(int[] array, int i) {
        int left = 2 * i + 1;
        int right = left + 1;
        int largest = i;
        if (left < array.length && array[left] > array[i]) {
            largest = left;
        }
        if (right < array.length && array[right] > array[largest]) {
            largest = right;
        }
        if (largest != i) {
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;
            maxHeap(array, largest);
        }
    }


}
