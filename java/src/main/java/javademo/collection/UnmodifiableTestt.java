package javademo.collection;

import java.util.Collections;
import java.util.HashMap;

/**
 * Copyright: Copyright (c) 2021 IWhaleCloud
 *
 * @program: forOffer
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-06-03 18:31
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-06-03 gaorunding v1.0.0 修改原因
 */
public class UnmodifiableTestt {
    public static void main(String[] args) {
        var unmodifiableList = Collections.emptyList();
        var unmodifiableSet = Collections.singleton("疯狂Java讲义");
        var scores = new HashMap<>();
        scores.put("语文", 80);
        scores.put("数学", 82);
        var unmodifiableMap = Collections.unmodifiableMap(scores);
//        unmodifiableList.add("测试元素");
//        unmodifiableSet.add("测试元素");
        unmodifiableMap.put("语文", 90);
    }

}
