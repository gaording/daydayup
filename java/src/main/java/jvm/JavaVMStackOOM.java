package jvm;

/**
 * Copyright: Copyright (c) 2021 IWhaleCloud
 *
 * @program: forOffer
 * @description: 栈动态扩展，内容过多导致操作系统内存不足
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-05-05 11:02
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-05-05 gaorunding v1.0.0 修改原因
 */
public class JavaVMStackOOM {
    private void dontStop(){
        while (true){}
    }

    public void stackLeakByThread(){
        while (true){
            Thread thread=new Thread(this::dontStop);
            thread.start();
        }
    }

    public static void main(String[] args) {
        JavaVMStackOOM oom=new JavaVMStackOOM();
        oom.stackLeakByThread();
    }
}
