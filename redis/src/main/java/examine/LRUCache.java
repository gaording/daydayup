package examine;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Copyright: Copyright (c) 2021 IWhaleCloud
 *
 * @program: forOffer
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-05-17 07:37
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-05-17 gaorunding v1.0.0 修改原因
 */
public class LRUCache extends LinkedHashMap {
    private int CACHE_SIZE;

    public LRUCache(int cacheSize) {
        super((int) Math.ceil(cacheSize/0.75+1),0.75f,true);
        this.CACHE_SIZE = CACHE_SIZE;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size()>CACHE_SIZE;
    }
}
