package jvm;

/**
 * Copyright: Copyright (c) 2021 IWhaleCloud
 *
 * @program: forOffer
 * @description: 对象死亡回收时会调用一次finalize方法
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-05-05 14:04
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-05-05 gaorunding v1.0.0 修改原因
 */
public class FinalizeEscapeGC {
    public static FinalizeEscapeGC SAVE_HOOK=null;
    public void isAlive(){
        System.out.println("yes,i am still alive");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed");
        FinalizeEscapeGC.SAVE_HOOK=this;
    }

    public static void main(String[] args) throws InterruptedException {
        SAVE_HOOK=new FinalizeEscapeGC();
        SAVE_HOOK=null;
        System.gc();
        Thread.sleep(500);
        if (SAVE_HOOK==null){
            System.out.println("no,i am dead");
        }else {
            SAVE_HOOK.isAlive();
        }
        SAVE_HOOK=null;
        System.gc();
        Thread.sleep(500);
        if (SAVE_HOOK==null){
            System.out.println("no,i am dead");
        }else {
            SAVE_HOOK.isAlive();
        }
    }
}
