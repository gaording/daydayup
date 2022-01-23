package com.example.crazyjava;

import lombok.Getter;

import java.util.Objects;

/**
 *
 * @program: daydayup
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-05-28 15:40
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-05-28 gaorunding v1.0.0 修改原因
 */
public class CacheImmutable {
    private static int MAX_SIZE = 10;
    //使用数组来缓存已有的实例
    private static CacheImmutable[] cache = new CacheImmutable[MAX_SIZE];
    //记录缓存实例在缓存中的位置，cache[pos-1]是最新缓存的实例
    private static int pos = 0;
    @Getter
    private final String name;

    private CacheImmutable(String name) {
        this.name = name;
    }

    public static CacheImmutable valueOf(String name) {
        for (int i = 0; i < MAX_SIZE; i++) {
            //如果已有相同实例，则直接返回该缓存的实例
            if (cache[i] != null && cache[i].getName().equals(name)) {
                return cache[i];
            }
        }
        CacheImmutable cacheImmutable = new CacheImmutable(name);
        cache[pos++] = cacheImmutable;
        pos %= MAX_SIZE;
        return cacheImmutable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CacheImmutable that = (CacheImmutable) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
