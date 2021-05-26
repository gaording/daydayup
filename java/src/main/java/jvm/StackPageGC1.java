package jvm;

/**
 * Copyright: Copyright (c) 2021 IWhaleCloud
 *
 * @program: forOffer
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-05-20 12:42
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-05-20 gaorunding v1.0.0 修改原因
 */
public class StackPageGC1 {
    public static void main(String[] args) {
        byte[] placeholder = new byte[64 * 1024 * 1024];
        System.gc();
    }
}
