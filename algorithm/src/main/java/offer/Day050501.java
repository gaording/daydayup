package offer;

/**
 * Copyright: Copyright (c) 2021 IWhaleCloud
 *
 * @program: forOffer
 * @description: 获取丑数
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-05-05 15:31
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-05-05 gaorunding v1.0.0 修改原因
 * 题目描述：求从小到大的第N个丑数。丑数是只包含因子2、3和5的数，习惯上我们把1当做是第一个丑数。
 * 思路：乘2或3或5，之后比较取最小值。
 */
public class Day050501 {
    public int getUglyNumber(int n){
        if (n<=0){
            return 0;
        }
        int[] arr=new int[n];
        arr[0]=1;
        int multiply2=0;
        int multiply3=0;
        int multiply5=0;
        for (int i = 1; i < n; i++) {
            int min=Math.min(arr[multiply2]*2,Math.min(arr[multiply3]*3,arr[multiply5]*5));
            arr[i]=min;
            if (arr[multiply2]*2==min){
                multiply2++;
            }
            if (arr[multiply3]*3==min){
                multiply3++;
            }
            if (arr[multiply5]*5==min){
                multiply5++;
            }
        }
        return arr[n-1];
    }
}
