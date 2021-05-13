package jvm;

/**
 * Copyright: Copyright (c) 2021 IWhaleCloud
 *
 * @program: forOffer
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-05-04 16:25
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-05-04 gaorunding v1.0.0 修改原因
 */
public class JavaVMStackSOF {
    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLeak();
        } catch (Throwable t) {
            System.out.println("stack length:"+oom.stackLength);
            System.out.println(t);
        }
    }


}
