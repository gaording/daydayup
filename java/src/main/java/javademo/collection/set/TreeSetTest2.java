package javademo.collection.set;

import java.util.TreeSet;

/**
 *
 * @program: daydayup
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-06-01 16:19
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-06-01 gaorunding v1.0.0 修改原因
 */
public class TreeSetTest2 {
    public static void main(String[] args) {
        var set = new TreeSet<Z>();
        var z1 = new Z(6);
        set.add(z1);
        System.out.println(set.add(z1));
        System.out.println(set);
        set.first().age = 1;
        System.out.println(set.last().age);
    }
}

class Z implements Comparable {

    int age;

    public Z(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        return true;
    }


    @Override
    public int compareTo(Object o) {
        return 1;
    }
}