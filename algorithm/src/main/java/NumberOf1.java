/**
 * Copyright: Copyright (c) 2021 IWhaleCloud
 *
 * @program: forOffer
 * @description: 二进制中一的个数
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-04-25 17:14
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-04-25 gaorunding v1.0.0 修改原因
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 *
 */
public class NumberOf1 {
    /**
     * a&(a-1)的结果会将a最右边的1变为0，直到a=0，还可以先将a&1!=0，然后右移1位，但不能计算负数的值，
     * @param n
     * @return
     */
    public int NumberOf1(int n){
        int count=0;
        while (n!=0){
            count++;
            n=(n-1)&n;
        }
        return count;
    }
}
