package jvm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Copyright: Copyright (c) 2021 IWhaleCloud
 *
 * @program: forOffer
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-05-08 16:52
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-05-08 gaorunding v1.0.0 修改原因
 */
public class BTraceTest {
    public int add(int a,int b){
        return a+b;
    }

    public static void main(String[] args) throws IOException {
        BTraceTest test=new BTraceTest();
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            reader.readLine();
            int a= (int) Math.round(Math.random()*1000);
            int b= (int) Math.round(Math.random()*1000);
            System.out.println(test.add(a,b));
        }
    }
}
