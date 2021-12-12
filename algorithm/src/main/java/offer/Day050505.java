package offer;

/**
 *
 * @program: daydayup
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-05-05 20:33
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-05-05 gaorunding v1.0.0 修改原因
 *
 * 题目描述：统计一个数字在排序数组中出现的次数。
 * 思路：利用二分查找+递归思想，进行寻找。当目标值与中间值相等时进行判断
 */
public class Day050505 {
    public static int getNumberOfK(int[] arraySorted,int k){
        if (arraySorted==null||arraySorted.length==0){
            return 0;
        }
        int left=0;
        int right=arraySorted.length;
        int mid;
        while (left<right){
            mid=(left+right)/2;
            if (arraySorted[mid]<k){
                left=mid+1;
            }else if (arraySorted[mid]>k){
                right=mid-1;
            }else if (arraySorted[mid]==k){
                int midHead=mid-1;
                int midTail=mid+1;
                int count=1;
                while (midHead>=left&&arraySorted[midHead--]==k){
                    count++;
                }
                while (midTail<=right&&arraySorted[midTail++]==k){
                    count++;
                }
                return count;
            }
        }
        return 0;
    }
}
