package javademo.collection.map;

import java.util.HashMap;

/**
 * Copyright: Copyright (c) 2021 IWhaleCloud
 *
 * @program: forOffer
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-06-02 19:29
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-06-02 gaorunding v1.0.0 修改原因
 */
public class MapTest2 {
    public static void main(String[] args) {
        var map = new HashMap<>();
        //成对放入多个key-value对
        map.put("疯狂java讲义", 109);
        map.put("疯狂ios讲义", 99);
        map.put("疯狂Ajax讲义", 79);
        map.replace("疯狂xml讲义", 66);
        map.merge("疯狂ios讲义", 10, (oldval, param) -> (Integer) oldval + (Integer) param);
        System.out.println(map);
        map.computeIfAbsent("Java", key -> ((String) key).length());
        System.out.println(map);
        map.computeIfPresent("Java", (key, value) -> (Integer) value * (Integer) value);
        System.out.println(map);

        map.put(null, null);
        map.put("a", null);
        System.out.println(map);

    }
}
