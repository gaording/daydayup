package jvm.notInitialization;

/**
 * Copyright: Copyright (c) 2021 IWhaleCloud
 *
 * @program: forOffer
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-05-13 17:20
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-05-13 gaorunding v1.0.0 修改原因
 */
public class NotInitialization2 {
    public static void main(String[] args) {
        SuperClass[] sca=new SuperClass[10];
    }
}
