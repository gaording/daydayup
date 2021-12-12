package offer;


import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @program: daydayup
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-05-01 15:24
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-05-01 gaorunding v1.0.0 修改原因
 * 题目描述：输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能
 * 排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 */
public class Day050102 {
    public List<String> permutation(String input) {
        if (StringUtils.isEmpty(input)) {
            return null;
        }
        List<String> result = new ArrayList<>();
        helper(result,0,input.toCharArray());
        Collections.sort(result);
        return result;

    }

    private void helper(List<String> result, int index, char[] array) {
       if (index==array.length-1){
            result.add(String.valueOf(array));
            return;
       }
        for (int i = 0; i < array.length; i++) {
            if (i==index||array[index]!=array[i]){
                swap(array,index,i);
                helper(result,index+1,array);
                swap(array,index,i);
            }
        }


    }

    private void swap(char[] c,int a,int b){
        char temp=c[a];
        c[a]=c[b];
        c[b]=temp;
    }

}
