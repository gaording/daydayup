package offer;

/**
 *
 * @program: daydayup
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-04-25 16:17
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-04-25 gaorunding v1.0.0 修改原因
 */
public class Fibonacci {
    public int fibonacci(int n) {
        if (n==0){
            return 0;
        }
        if (n<=2){
            return 1;
        }
        int i = 1;
        int j = 1;
        for (int k = 2; k <= n; k++) {
            int swap = j;
            j = i + j;
            i = swap;
        }
        return j;
    }
}
