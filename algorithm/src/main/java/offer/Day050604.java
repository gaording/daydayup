package offer;

/**
 * Copyright: Copyright (c) 2021 IWhaleCloud
 *
 * @program: forOffer
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-05-06 17:58
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-05-06 gaorunding v1.0.0 修改原因
 *
 * 题目描述：求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）
 * 思路：巧用递归（返回值类型为Boolean）
 */
public class Day050604 {
    public int sumSolution(int n){
        int sum=n;
        boolean result=(n>0)&&((sum+=sumSolution(n-1))>0);
        return sum;
    }
}
