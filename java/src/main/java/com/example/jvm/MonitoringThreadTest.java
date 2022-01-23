package com.example.jvm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @program: daydayup
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-05-08 14:57
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-05-08 gaorunding v1.0.0 修改原因
 */
public class MonitoringThreadTest {
    public static void createBusyThread(){
        Thread thread=new Thread(()->{while (true);},"testBusyThread");
        thread.start();
    }
    public static void createLockThread(final Object lock){
        Thread thread=new Thread(()->{synchronized (lock){
            try {
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }},"testLockThread");
        thread.start();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        createBusyThread();
        bufferedReader.readLine();
        Object obj=new Object();
        createLockThread(obj);
    }
}
