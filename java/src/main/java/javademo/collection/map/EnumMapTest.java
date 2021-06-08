package javademo.collection.map;

import java.util.EnumMap;

/**
 * Copyright: Copyright (c) 2021 IWhaleCloud
 *
 * @program: forOffer
 * @description: 枚举map测试
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-06-03 09:52
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-06-03 gaorunding v1.0.0 修改原因
 */
public class EnumMapTest {
    public static void main(String[] args) {
        var enumMap = new EnumMap<>(Season.class);
        enumMap.put(Season.SUMMMER, "夏日炎炎");
        enumMap.put(Season.SPRING, "春暖花开");
        System.out.println(enumMap);
    }

    enum Season {
        SPRING, SUMMMER, FALL, WINTER
    }
}
