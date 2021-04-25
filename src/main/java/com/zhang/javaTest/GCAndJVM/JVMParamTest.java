package com.zhang.javaTest.GCAndJVM;

/**
 * Created by kongweichun on 2021/3/17.
 * chongqing liangyao
 */
public class JVMParamTest {
    public static void main(String[] args) {
        //创建需要
        byte[] b = new byte[1024*1024*1];
        System.out.println("Xmx="+Long.valueOf(Runtime.getRuntime().maxMemory()/1024/1024)+"M");
        System.out.println("freeMemory="+Long.valueOf(Runtime.getRuntime().freeMemory()/1024/1024)+"M");
        System.out.println("totalMemory="+Long.valueOf(Runtime.getRuntime().totalMemory()/1024/1024)+"M");
    }
}
