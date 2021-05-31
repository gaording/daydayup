package javademo;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 * Copyright: Copyright (c) 2021 IWhaleCloud
 *
 * @program: forOffer
 * @description: 虚引用队列测试
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-05-30 17:18
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-05-30 gaorunding v1.0.0 修改原因
 */
public class PhantomReferenceTest {
    public static void main(String[] args) {
        var str = new String("java疯狂讲义");
        var rq = new ReferenceQueue<>();
        var pr = new PhantomReference<>(str, rq);
        System.out.println(pr.get());
        str = null;
        System.out.println(pr.get());
        System.gc();
        System.runFinalization();
        System.out.println(pr.get());
        System.out.println(rq.poll() == pr);
    }
}
