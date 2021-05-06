package offer;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Copyright: Copyright (c) 2021 IWhaleCloud
 *
 * @program: forOffer
 * @description: n个骰子的点数及出现的概率
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-05-06 16:25
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-05-06 gaorunding v1.0.0 修改原因
 * <p>
 * 题目描述：把n个骰子扔在地上，所有骰子朝上一面的点数之和为s,输入n,打印出s的所有可能出现的概率
 */
public class Day050601_ {

    /**
     * 递归
     *
     * @param n
     * @param s
     * @return
     */
    public BigDecimal getResult(int n, int s) {
        if (s < n || s > n * 6) {
            return BigDecimal.valueOf(0);
        }
        if (n == 1) {
            return BigDecimal.valueOf(1 / 6);
        }
        return BigDecimal.valueOf(1 / 6).multiply(getResult(n - 1, s - 1)
                .add(getResult(n - 1, s - 2))
                .add(getResult(n - 1, s - 3))
                .add(getResult(n - 1, s - 4))
                .add(getResult(n - 1, s - 5))
        );
    }

    public Map<Integer, Double> printProbability(int number) {
        Map<Integer, Double> probabilityMap = new HashMap<>();
        if (number < 1) {
            return probabilityMap;
        }
        int g_maxvalue = 6;
        int[][] probabilities = new int[2][];
        probabilities[0] = new int[g_maxvalue * number + 1];
        probabilities[1] = new int[g_maxvalue * number + 1];
        int flag = 0;

        //当第一次掷骰子时，有6种可能，每种可能出现一次
        //第一个骰子投完的结果存到了probabilities[0]
        for (int i = 1; i <= g_maxvalue; i++) {
            probabilities[0][i] = 1;
        }

        //从第二次开始掷骰子，假设第一个数组中的第n个数字表示骰子和为n出现的次数
        for (int i = 2; i < number; i++) {
            for (int j = 0; j < i; j++) {
                probabilities[1-flag][j]=0;
            }
            for (int j = i; j <=g_maxvalue*i ; j++) {
                probabilities[1-flag][j]=0;
                for (int k = 1; k <=j&&k<=g_maxvalue ; k++) {
                    probabilities[1-flag][j]+=probabilities[flag][j-k];
                }
            }
            flag=1-flag;
        }
        double total=Math.pow(g_maxvalue,number);
        for (int sum = number; sum <=g_maxvalue*number ; sum++) {
            double ratio=probabilities[flag][sum]/total;
            probabilityMap.put(sum,ratio);
        }
        return probabilityMap;
    }


}
