package offer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @program: daydayup
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-05-05 21:57
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-05-05 gaorunding v1.0.0 修改原因
 *
 * 题目描述：输入一个递增排序的数组和一个数字S，在数组中查找两个数，是的他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 思路：定义两个指针，分别从前面和后面进行遍历。间隔越远乘积越小，所以是最先出现的两个数乘积最小
 *
 * 数组找两个数的时候双指针很方便的，要多参考这种的。数组、链表都可以用双指针，二叉树用递归，都是常用方法
 */
public class Day050509 {
    public List<Integer> findNumbersWithSum(int[] array,int sum){
        List<Integer> list=new ArrayList<>();
        if (array==null){
            return list;
        }
        int left=0;
        int right=array.length-1;
        while (left<right){
            int s=array[left]+array[right];
            if (s==sum){
                list.add(left);
                list.add(right);
                return list;
            }
            if (s<sum){
                left++;
            }else if (s>sum){
                right--;
            }
        }
        return list;
    }
}
