package com.example.javademo.collection.set;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @program: daydayup
 * @description: 测试hashset中hashcode与equals的情况
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-06-01 15:12
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-06-01 gaorunding v1.0.0 修改原因
 */
public class HashSetTest {
    public static void main(String[] args) {
        Set set = new HashSet();
        set.add(new A());
        set.add(new A());
        set.add(new B());
        set.add(new B());
        set.add(new C());
        set.add(new C());
        set.forEach(System.out::println);
    }
}

class A {
    @Override
    public boolean equals(Object obj) {
        return true;
    }
}

class B {
    @Override
    public int hashCode() {
        return 1;
    }
}

class C {
    @Override
    public int hashCode() {
        return 2;
    }

    @Override
    public boolean equals(Object obj) {
        return true;
    }
}