package com.zhang.javaTest.proxy;

import net.sf.cglib.proxy.Enhancer;

/**
 * Created by kongweichun on 2021/3/10.
 * chongqing liangyao
 */
public class CGLEBProxyFactory {

    //创建代理对象
    public static Object getProxy(Class<?> c){
        //创建动态代理类
        Enhancer e = new Enhancer();
        //设置类加载器
        e.setClassLoader(c.getClassLoader());
        //设置被代理类
        e.setSuperclass(c);
        //设置方法拦截器，因为MethodInterceptor实现了Callback
        e.setCallback(new MyCGLEBMethodInterceptor());
        return e.create();
    }
}
