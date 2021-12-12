package offer;

/**
 *
 * @program: daydayup
 * @description: 字符串转成整数
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-05-06 18:15
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-05-06 gaorunding v1.0.0 修改原因
 */
public class Day050606 {
    public int strToInt(String str){
        if (str==null||str.length()==0){
            return 0;
        }
        int mark=0;
        int number=0;
        char[] chars=str.toCharArray();
        if (chars[0]=='-'){
            mark=1;
        }
        for (int i = mark; i < chars.length; i++) {
            if (chars[i]=='+'){
                continue;
            }
            if (chars[i]<48||chars[i]>57){
                return 0;
            }
            number=number*10+chars[i]-48;
        }
        return mark==0?number:-number;
    }
}
