package offer;

/**
 * Copyright: Copyright (c) 2021 IWhaleCloud
 *
 * @program: forOffer
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-04-30 13:54
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-04-30 gaorunding v1.0.0 修改原因
 */
public class Day043001 {

    /**
     * 题目描述：输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
     * 例如，如果输入如下4X4矩阵：12345678910111213141516则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
     *
     * @param arr
     */
    public void spiralOrder(int[][] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int rowStart = 0;
        int colStart = 0;
        int rowEnd = arr.length;
        int colEnd = arr[0].length;
        while (rowEnd > rowStart && colEnd > colStart) {
            print(arr, rowStart, colStart, rowEnd, colEnd);
            rowStart++;
            rowEnd--;
            colStart++;
            colEnd--;
        }

    }

    private void print(int[][] arr, int rowStart, int colStart, int rowEnd, int colEnd) {
        int i = rowStart;
        int j = colStart;
        while (j < colEnd) {
            System.out.println(arr[i][j]);
            j++;
        }
        while (i < rowEnd) {
            System.out.println(arr[i][j]);
            i++;
        }
        j--;
        while (j >= colStart) {
            System.out.println(arr[i][j]);
            j--;
        }
        i--;
        while (i > colStart) {
            System.out.println(arr[i][j]);
            i--;
        }
    }
}
