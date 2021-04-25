package com.zhang.javaTest.proxy;

/**
 * Created by kongweichun on 2021/3/10.
 * chongqing liangyao
 * 被代理类
 */
public class TargetTestImpl implements TestDao {
    @Override
    public void test(){
        System.out.println("test");
    }
}
