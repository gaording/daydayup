package com.example.jvm;

/**
 *
 * @program: daydayup
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-05-08 10:57
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-05-08 gaorunding v1.0.0 修改原因
 * staticObj、instanceObj、localObj存放在哪里
 */
public class JHSDB_TestCase {
    static class Test{
        static ObjectHolder staticObj=new ObjectHolder();
        ObjectHolder instanceObj=new ObjectHolder();

        void foo(){
            ObjectHolder localObj=new ObjectHolder();
            System.out.println("done");
        }
    }

    private static class ObjectHolder{}

    public static void main(String[] args) {
        Test test=new Test();
        test.foo();
    }
}
