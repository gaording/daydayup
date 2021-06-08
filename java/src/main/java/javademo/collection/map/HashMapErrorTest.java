package javademo.collection.map;

import java.util.HashMap;

/**
 * Copyright: Copyright (c) 2021 IWhaleCloud
 *
 * @program: forOffer
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-06-02 19:59
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-06-02 gaorunding v1.0.0 修改原因
 */
public class HashMapErrorTest {
    public static void main(String[] args) {
        var ht = new HashMap<HashtableTest.A, String>();
        ht.put(new HashtableTest.A(6000), "疯狂java讲义");
        ht.put(new HashtableTest.A(87563), "轻量级java ee企业应用实战");
        var it = ht.keySet().iterator();
        //取出map中第一个key，并修改它的count值
        var first = it.next();
        first.count = 87563;
        System.out.println(ht);
        //只能删除没有被修改过的key所对应的key-value对
        ht.remove(new HashtableTest.A(87563));
        System.out.println(ht);
        //无法获取剩下的value，下面两行代码都将输出null
        System.out.println(ht.get(new HashtableTest.A(87563)));
        System.out.println(ht.get(new HashtableTest.A(6000)));

    }
}
