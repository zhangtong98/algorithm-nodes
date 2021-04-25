package com.zhang.javaTest.proxy;

import java.lang.reflect.Proxy;

/**
 * Created by kongweichun on 2021/3/10.
 * chongqing liangyao
 * JDK动态代理机制工厂类，用来动态生成代理类对象
 */
public class JDKProxyFactory {
    public static Object getProxy(Object target){
        /**
         * ClassLoader loader, 被代理对象类加载器
         Class<?>[] interfaces, 被代理对象实现的所有接口
         InvocationHandler h    实现了InvocationHandler接口的对象
         */
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new MyJDKInvocationHandle(target));
    }
}
