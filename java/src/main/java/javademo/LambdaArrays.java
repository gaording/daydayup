package javademo;

import java.util.Arrays;

/**
 * Copyright: Copyright (c) 2021 IWhaleCloud
 *
 * @program: forOffer
 * @description: lambda测试arrays
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-05-30 09:42
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-05-30 gaorunding v1.0.0 修改原因
 */
public class LambdaArrays {
    public static void main(String[] args) {
        var array1 = new String[]{"java", "fkava", "fkit", "ios", "android"};
        Arrays.parallelSort(array1, (o1, o2) -> o1.length() - o2.length());
        System.out.println(Arrays.toString(array1));
        var array2 = new int[]{3, -4, 25, 16, 30, 18};
        Arrays.parallelPrefix(array2, (left, right) -> left * right);
        System.out.println(Arrays.toString(array2));
        var array3 = new long[3];
        Arrays.parallelSetAll(array3, operand -> operand * 3);
        System.out.println(Arrays.toString(array3));
    }
}
