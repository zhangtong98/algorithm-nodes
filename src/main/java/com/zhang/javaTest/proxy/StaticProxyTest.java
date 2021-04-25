package com.zhang.javaTest.proxy;

/**
 * Created by kongweichun on 2021/3/10.
 * chongqing liangyao
 * 静态代理必须和被代理类实现相同的接口和重新被代理类的每个方法，在编译器就将接口，代理类，被代理类编译成class文件
 */
public class StaticProxyTest implements TestDao {

    private final TestDao testDao;
    public StaticProxyTest(TestDao testDao){
        this.testDao = testDao;
    }

    @Override
    public void test() {
        System.out.println("static test");
    }
}
