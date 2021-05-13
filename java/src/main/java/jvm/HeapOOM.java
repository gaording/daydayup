package jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright: Copyright (c) 2021 IWhaleCloud
 *
 * @program: forOffer
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-05-04 15:35
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-05-04 gaorunding v1.0.0 修改原因
 */
public class HeapOOM {
    static class OOMObject{}

    public static void main(String[] args) {
        List<OOMObject> list=new ArrayList<>();
        while (true){
            list.add(new OOMObject());
        }
    }
}
