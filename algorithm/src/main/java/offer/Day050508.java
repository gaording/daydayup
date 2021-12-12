package offer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @program: daydayup
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-05-05 21:24
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-05-05 gaorunding v1.0.0 修改原因
 *
 * 题目描述：输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 * 思路：定义两个指针，分别递增，寻找和为s的序列。
 */
public class Day050508 {
    public List<List<Integer>> findContinuousSequence(int sum){
        List<List<Integer>> list=new ArrayList<>();
        if (sum<3){
            return list;
        }
        for (int i = 0; i < (sum+1)/2; i++) {
            int s=0;
            for (int j = i; j < sum; j++) {
                s+=j;
                if (s>sum){
                    break;
                }
                if (s==sum){
                    List<Integer> singleList=new ArrayList<>();
                    for (int k = i; k < j; k++) {
                        singleList.add(k);
                    }
                    list.add(singleList);
                }
            }
        }
        return list;

    }
}
