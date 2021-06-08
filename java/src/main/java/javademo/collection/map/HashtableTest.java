package javademo.collection.map;

import java.util.Hashtable;

/**
 * Copyright: Copyright (c) 2021 IWhaleCloud
 *
 * @program: forOffer
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-06-02 19:40
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-06-02 gaorunding v1.0.0 修改原因
 */
public class HashtableTest {
    public static void main(String[] args) {
        var ht = new Hashtable<>();
        ht.put(new A(6000), "轻量级Java讲义");
        ht.put(new A(87563), "轻量级Java EE企业应用实战");
        ht.put(new A(1232), new B());
        System.out.println(ht);
        System.out.println(ht.containsValue("测试字符串"));
        System.out.println(ht.containsKey(new A(87563)));
        ht.remove(new A(1232));
        System.out.println(ht);
    }

    static class A {
        int count;

        public A(int count) {
            this.count = count;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            A a = (A) o;
            return count == a.count;
        }

        @Override
        public int hashCode() {
            return this.count;
        }
    }

    static class B {
        @Override
        public boolean equals(Object o) {
            return true;
        }
    }
}


