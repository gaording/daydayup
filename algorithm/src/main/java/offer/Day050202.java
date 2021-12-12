package offer;

/**
 *
 * @program: daydayup
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-05-02 20:46
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-05-02 gaorunding v1.0.0 修改原因
 * 题目描述：输入一个整型数组，数组中有正数也有负数，数组中一个或连续的多个整数组成一个子数组，求连续子数组的最大和
 * 思路：若和小于0，则将最大和置为当前值，否则计算最大和。
 */
public class Day050202 {

    public int maxSubArray(int[] nums){
        if (nums==null||nums.length==0){
            return 0;
        }
        int sum=0;
        int result=nums[0];
        for (int num : nums) {
            sum=sum<0?num:sum+num;
            result=Math.max(result,sum);
        }
        return result;
    }

}
