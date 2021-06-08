package javademo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Copyright: Copyright (c) 2021 IWhaleCloud
 *
 * @program: forOffer
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-06-01 10:40
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-06-01 gaorunding v1.0.0 修改原因
 */
public class NewFormatterParse {
    public static void main(String[] args) {
        var str1 = "2014==04==12 01时06分09秒";
        var formatter1 = DateTimeFormatter.ofPattern("yyyy==MM==dd HH时mm分ss秒");
        var dt1 = LocalDateTime.parse(str1, formatter1);
        System.out.println(dt1);
        var str2 = "2014$$4月$$$13 20小时";
        var formatter2 = DateTimeFormatter.ofPattern("yyyy$$MMM$$$dd HH小时");
        var dt2 = LocalDateTime.parse(str2, formatter2);
        System.out.println(dt2);
    }
}
