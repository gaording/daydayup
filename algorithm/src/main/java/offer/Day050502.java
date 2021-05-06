package offer;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Copyright: Copyright (c) 2021 IWhaleCloud
 *
 * @program: forOffer
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-05-05 15:43
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-05-05 gaorunding v1.0.0 修改原因
 * 题目描述：在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置
 *
 */
public class Day050502 {
    public int firstNotRepeatingChar(String str){
        if (str==null||str.length()==0){
            return -1;
        }
        char[] c=str.toCharArray();
        LinkedHashMap<Character,Integer> hash=new LinkedHashMap<>();
        for (char c1 : c) {
            hash.put(c1,hash.getOrDefault(c1,0)+1);
        }
        for (Map.Entry<Character, Integer> characterIntegerEntry : hash.entrySet()) {
            if (characterIntegerEntry.getValue()==1){
                return str.indexOf(characterIntegerEntry.getKey());
            }
        }
        return -1;
    }
}
