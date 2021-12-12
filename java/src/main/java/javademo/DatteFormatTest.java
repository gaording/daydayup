package javademo;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @program: daydayup
 * @description: 日期格式化
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-06-01 10:08
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-06-01 gaorunding v1.0.0 修改原因
 */
public class DatteFormatTest {
    public static void main(String[] args) {
        var dt = new Date();
        Locale[] locales = {Locale.CHINA, Locale.US};
        var df = new DateFormat[16];
        for (int i = 0; i < locales.length; i++) {
            df[i * 8] = DateFormat.getDateInstance(DateFormat.SHORT, locales[i]);
            df[i * 8 + 1] = DateFormat.getDateInstance(DateFormat.MEDIUM, locales[i]);
            df[i * 8 + 2] = DateFormat.getDateInstance(DateFormat.LONG, locales[i]);
            df[i * 8 + 3] = DateFormat.getDateInstance(DateFormat.FULL, locales[i]);
            df[i * 8 + 4] = DateFormat.getTimeInstance(DateFormat.SHORT, locales[i]);
            df[i * 8 + 5] = DateFormat.getTimeInstance(DateFormat.MEDIUM, locales[i]);
            df[i * 8 + 6] = DateFormat.getTimeInstance(DateFormat.LONG, locales[i]);
            df[i * 8 + 7] = DateFormat.getTimeInstance(DateFormat.FULL, locales[i]);
        }
        for (int i = 0; i < locales.length; i++) {
            var tip = i == 0 ? "------中国日期格式------" : "------美国日期格式------";
            System.out.println(tip);
            System.out.println("SHORT格式的日期格式：" + df[i * 8].format(dt));
            System.out.println("MEDIUM格式的日期格式：" + df[i * 8 + 1].format(dt));
            System.out.println("LONG格式的日期格式：" + df[i * 8 + 2].format(dt));
            System.out.println("FULL格式的日期个是：" + df[i * 8 + 3].format(dt));
            System.out.println("SHORT格式的事件格式：" + df[i * 8 + 4].format(dt));
            System.out.println("MEDIUM格式的日期格式：" + df[i * 8 + 5].format(dt));
            System.out.println("LONG格式的日期格式：" + df[i * 8 + 6].format(dt));
            System.out.println("FULL格式的日期格式：" + df[i * 8 + 7].format(dt));
        }
    }
}
