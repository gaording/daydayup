package jvmdemo;

/**
 * Copyright: Copyright (c) 2021 IWhaleCloud
 *
 * @program: forOffer
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-06-06 07:23
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-06-06 gaorunding v1.0.0 修改原因
 */
public class StringGCTest {
    public static void main(String[] args) {
        for (int i = 0; i < 1000000; i++) {
            String.valueOf(i).intern();
        }
    }
}
