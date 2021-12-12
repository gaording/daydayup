package offer;

/**
 *
 * @program: daydayup
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-05-01 16:53
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-05-01 gaorunding v1.0.0 修改原因
 * 题目描述：数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。如果不存在则输出0。
 * 思路：将首次出现的数count+1，与之后的数进行比较，相等则+1，否则—1，最后进行校验是否超过长度的一半
 */
public class Day050103 {
    public int moreThanHalfNum(int[] nums){
        int count=0;
        int candidate=0;
        for (int num:nums) {
            if (count==0){
                candidate=num;
            }
            count+=(num==candidate)?1:-1;
        }
        count=0;
        for (int num : nums) {
            if (num==candidate){
                count++;
            }
        }
        return count*2>nums.length?candidate:0;
    }
}
