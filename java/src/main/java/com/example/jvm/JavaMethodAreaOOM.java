package com.example.jvm;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

/**
 *
 * @program: daydayup
 * @description: 方法区内存溢出
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-05-05 12:31
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-05-05 gaorunding v1.0.0 修改原因
 */
public class JavaMethodAreaOOM {
    public static void main(String[] args) {
        while (true){
            Enhancer enhancer=new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback((MethodInterceptor) (o, method, objects, methodProxy) -> methodProxy.invokeSuper(objects,args));
            enhancer.create();
        }
    }

    static class OOMObject{

    }
}
