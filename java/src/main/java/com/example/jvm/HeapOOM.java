package com.example.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @program: daydayup
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
