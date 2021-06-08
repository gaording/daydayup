package javademo.collection.set;

import java.util.HashSet;

/**
 * Copyright: Copyright (c) 2021 IWhaleCloud
 *
 * @program: forOffer
 * @description: 测试更改hashset中元素属性的情况
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-06-01 15:23
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-06-01 gaorunding v1.0.0 修改原因
 */
public class HashSetTest2 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        var hs = new HashSet<R>();
        hs.add(new R(5));
        hs.add(new R(-3));
        hs.add(new R(9));
        hs.add(new R(-2));
        System.out.println(hs);
        //取出第一个元素
        var it = hs.iterator();
        var first = it.next();
        System.out.println(first);
        //为第一个元素的count实例变量赋值
        first.count = -3;
        //再次输出hashset集合，集合元素有重复元素
        System.out.println(hs);
        //删除count为-3的R元素
        hs.remove(new R(-3));
        System.out.println(hs);

        System.out.println("hs是否包含count为-3的R对象？" + hs.contains(new R(-3)));
        System.out.println("hs是否包含count为-2的R对象？" + hs.contains(new R(-2)));

    }
}

class R {
    int count;

    public R(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "R{" +
                "count=" + count +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        R r = (R) o;
        return count == r.count;
    }

    @Override
    public int hashCode() {
        return count;
    }
}
