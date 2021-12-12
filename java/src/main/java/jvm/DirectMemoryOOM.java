package jvm;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 *
 * @program: daydayup
 * @description: 直接内存溢出
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-05-05 12:39
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-05-05 gaorunding v1.0.0 修改原因
 */
public class DirectMemoryOOM {
    private static final int _1MB=1024*1024;

    public static void main(String[] args) throws IllegalAccessException {
        Field unsafeField= Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe= (Unsafe) unsafeField.get(null);
        while (true){
            unsafe.allocateMemory(_1MB);
        }
    }
}
