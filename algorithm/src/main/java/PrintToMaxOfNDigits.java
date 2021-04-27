/**
 * Copyright: Copyright (c) 2021 IWhaleCloud
 *
 * @program: forOffer
 * @description: 求1到最大的n位数
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-04-27 16:36
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-04-27 gaorunding v1.0.0 修改原因
 */
public class PrintToMaxOfNDigits {
    public void printToMaxOfNDigits(int n) {
        if (n <= 0) {
            return;
        }
        int[] array = new int[n];


    }

    private void printArray(int[] array, int n) {
        for (int i = 0; i < 10; i++) {
            if (n!=array.length){
                array[n]=i;

            }
            for (int j = 0; j < n; j++) {

            }
        }
    }
}
