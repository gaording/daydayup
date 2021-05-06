package offer;

/**
 * Copyright: Copyright (c) 2021 IWhaleCloud
 *
 * @program: forOffer
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-05-05 22:06
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-05-05 gaorunding v1.0.0 修改原因
 *
 * 题目描述：输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变
 * 思路：先将整个字符串翻转，然后将每个单词反转
 */
public class Day050510 {
    public String revertWord(String input){
        if (input==null||input.length()==0){
            return "";
        }
        char[] result=new char[input.length()];
        char[] inputChars=input.toCharArray();
        int i=0;
        int resultI=result.length;
        for (int j = 0; j < inputChars.length; j++) {
            if (inputChars[j]==' '){
                for (int k = j; k >= i; k--) {
                    result[resultI--]=inputChars[k];
                }
            }
        }
        return String.valueOf(result);
    }
}
