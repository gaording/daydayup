package offer;

/**
 *
 * @program: daydayup
 * @description: 数值的整数次方
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-04-27 15:32
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-04-27 gaorunding v1.0.0 修改原因
 * 题目描述：给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。不得使用库函数，不需要考虑大数问题
 * 思路：不能用==比较两个浮点数是否相等，因为有误差。考虑输入值的多种情况。
 */
public class Power {
    public double Power(double base, int exponent) {
        double res ;
        if (equal(base, 0)) {
            return 0;
        }
        if (exponent == 0) {
            return 1.0;
        }
        if (exponent > 0) {
            res = mutiply(base, exponent);
        } else {
            res = mutiply(1 / base, -exponent);
        }
        return res;
    }

    public double mutiply(double base, int e) {
        double sum = 1;
        for (int i = 0; i < e; i++) {
            sum = sum * base;
        }
        return sum;
    }

    public boolean equal(double a, double b) {
        return a - b < 0.000001 || a - b > -0.000001;
    }
}
