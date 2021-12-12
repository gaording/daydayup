package offer;

import java.util.Arrays;

/**
 *
 * @program: daydayup
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-05-06 17:16
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-05-06 gaorunding v1.0.0 修改原因
 */
public class Day050602 {
    public boolean isContinuous(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return false;
        }
        int count = 0;
        int diff = 0;
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] == 0) {
                count++;
                continue;
            }
            if (numbers[i] == numbers[i + 1]) {
                return false;
            }
            diff += numbers[i + 1] - numbers[i] - 1;
        }
        return diff<=count;
    }
}
