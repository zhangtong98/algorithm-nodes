package com.zhang.javaTest.myThreadPoolExecutorTest;

import java.util.Date;

/**
 * Created by kongweichun on 2021/3/19.
 * chongqing liangyao
 */
public class MyRunnable implements Runnable {
    private String command;
    public MyRunnable(String command){
        this.command = command;
    }
    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName()+"Start:"+new Date());
        processCommand();
        System.out.println(Thread.currentThread().getName()+"End"+new Date());
    }

    protected void processCommand(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Override
    public String toString() {
        return "MyRunnable{" +
                "command='" + command + '\'' +
                '}';
    }
}
