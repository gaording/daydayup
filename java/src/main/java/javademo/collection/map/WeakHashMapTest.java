package javademo.collection.map;

import java.util.WeakHashMap;

/**
 * Copyright: Copyright (c) 2021 IWhaleCloud
 *
 * @program: forOffer
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-06-03 09:45
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-06-03 gaorunding v1.0.0 修改原因
 */
public class WeakHashMapTest {
    public static void main(String[] args) {
        var whm = new WeakHashMap<>();
        whm.put(new String("语文"), new String("良好"));
        whm.put(new String("数学"), new String("及格"));
        whm.put(new String("英文"), new String("中等"));
        //Java是一个系统缓存的字符串对象
        whm.put("Java", new String("中等"));
        System.out.println(whm);
        System.gc();
        System.runFinalization();
        System.out.println(whm);
    }
}
