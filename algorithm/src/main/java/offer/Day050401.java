package offer;

/**
 * Copyright: Copyright (c) 2021 IWhaleCloud
 *
 * @program: forOffer
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-05-04 22:04
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-05-04 gaorunding v1.0.0 修改原因
 * 题目描述：输入一个整数n，求从1到整数n的十进制表示中1出现的次数
 * 思路：若百位上数字为0，百位上可能出现1的次数由更高位决定；若百位上数字为1，百位上可能出现1的次数不仅受更高位影响还受低位影响；
 * 若百位上数字大于1，则百位上出现1的情况仅由更高位决定
 */
public class Day050401 {
    public int numberOf1Between1AndN(int n) {
        int count = 0;
        int i = 1;
        int current = 0, after = 0, before = 0;
        while (n / i != 0) {
            before = n / (i * 10);
            current = (n / i) % 10;
            after = n % i;
            if (current == 0) {
                //如果为0，出现1的次数由高位决定，等于高位数字*当前数字
                count = count + before * i;
            } else if (current == 1) {
                //如果为1，出现1的次数由高位和低位决定，高位*当前位+低位+1
                count = count + before * i + after + 1;
            }else if (current>1){
                //如果大于1，出现1的次数由高位决定，（高位数字+1）*当前位数
                count=count+(before+1)*i;
            }
            i=i*10;
        }
        return count;
    }
}
