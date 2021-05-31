package javademo;

import java.lang.ref.WeakReference;

/**
 * Copyright: Copyright (c) 2021 IWhaleCloud
 *
 * @program: forOffer
 * @description: 测试虚引用
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-05-30 17:13
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-05-30 gaorunding v1.0.0 修改原因
 */
public class ReferenceTest {
    public static void main(String[] args) {
        var str = new String("疯狂java讲义");
        var wr = new WeakReference<>(str);
        str = null;
        System.out.println(wr.get());
        System.gc();
        System.runFinalization();
        System.out.println(wr.get());
    }
}
