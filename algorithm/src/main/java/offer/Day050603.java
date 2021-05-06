package offer;

/**
 * Copyright: Copyright (c) 2021 IWhaleCloud
 *
 * @program: forOffer
 * @description: 约瑟夫环（数学问题求解）
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-05-06 17:35
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-05-06 gaorunding v1.0.0 修改原因
 */
public class Day050603 {
    public int lastRemain(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }
        int last=0;
        for (int i = 2; i <= n; i++) {
            last=(last+m)%i;
        }
        return last;
    }
}
