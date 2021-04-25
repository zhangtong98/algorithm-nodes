package com.zhang.javaTest.myThreadPoolExecutorTest;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by kongweichun on 2021/3/19.
 * chongqing liangyao
 */
public class ThreadPoolExecutorTest {
    //核心线程池容量
    private static final int CORE_POOL_SIZE = 5;
    //线程池容量（最大限度）
    private static final int MAXIMUM_POOL_SIZE = 10;
    //线程池最小容量装满后，当其中线程执行完后此线程存活时间
    private static final long KEEP_ALIVE_TIME = 10;
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAXIMUM_POOL_SIZE,
                KEEP_ALIVE_TIME,
                //存活时间单位
                TimeUnit.SECONDS,
                //线程池等待队列及容量大小
                new ArrayBlockingQueue<Runnable>(10,true),
                //线程池最大容量装满及等待队列装满后在有任务进入后的策略机制
                new ThreadPoolExecutor.CallerRunsPolicy());
        for (int i = 0; i < 21; i++) {
            //创建一个线程并执行
            executor.execute(new MyRunnable(" "+i));
        }
        //线程池终止
        executor.shutdown();
        while (!executor.isTerminated()){
        }
        System.out.println("Finished all threads");
    }
}
