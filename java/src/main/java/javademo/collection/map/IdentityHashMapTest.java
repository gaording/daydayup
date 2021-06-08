package javademo.collection.map;

import java.util.IdentityHashMap;

/**
 * Copyright: Copyright (c) 2021 IWhaleCloud
 *
 * @program: forOffer
 * @description: 通过严格的==判断key是否相等
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-06-03 09:50
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-06-03 gaorunding v1.0.0 修改原因
 */
public class IdentityHashMapTest {
    public static void main(String[] args) {
        var ihm = new IdentityHashMap<>();
        ihm.put(new String("语文"), 89);
        ihm.put(new String("语文"), 78);
        ihm.put("Java", 93);
        ihm.put("Java", 98);
        System.out.println(ihm);
    }
}
