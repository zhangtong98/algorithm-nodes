package com.zhang.javaTest.proxy;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by kongweichun on 2021/3/10.
 * chongqing liangyao
 * 总结：
 * 代理模式：我们使用代理模式来替代对真实对象的访问，这样就可以在不修改真实对象的前提下，提供额外的功能操作，扩展目标对象的功能
 *          代理模式的主要作用是扩展目标对象的功能，可以在目标对象某个方法执行前后增加操作
 * 静态代理：必须和被代理类实现相同的接口和重写对应的方法，静态代理是在JVM编译时就生成接口、被代理类和代理类的一个个class文件
 *          如果项目中需要被代理的类过多，就会导致代码臃肿，难以维护
 * 动态代理：动态代理是在运行时生成类字节码并加载到JVM中
     * JDK动态代理：被代理类需要实现接口，核心是InvocationHandle接口和Proxy类，利用Proxy类的newProxyInstance()
     *              方法动态生成代理对象，相对于静态代理更加灵活
     * CGLEB动态代理：被代理类无需实现任何接口，核心是MethodInterceptor(方法拦截器)接口和EnHancer(增强类),
     *               通过增强类EnHancer来生成被代理类的子类来拦截被代理类的方法调用，所以不能声明final类型的类和方法
 *                   （通过继承实现的）
     * 二者比较，JDK动态代理的效率更高一些，而且随着JDK版本的迭代会更加明显
     * 例子，spring框架中的AOP和RPC 框架就是使用的动态代理，默认使用JDK动态代理，当被代理类没有实现接口才使用CGLEB动态代理
 */
public class Main {
    public static void main(String[] args) {
        //静态代理
        TestDao testDao = new TargetTestImpl();
        StaticProxyTest staticProxyTest = new StaticProxyTest(testDao);
        staticProxyTest.test();
        //JDK动态代理
        TestDao JDKTestDao = (TestDao)JDKProxyFactory.getProxy(new TargetTestImpl());
        JDKTestDao.test();
        //CGLEB动态代理 (3.3.0不兼容jdk1.7)
        CGLIBTest cglibTest = (CGLIBTest)CGLEBProxyFactory.getProxy(CGLIBTest.class);
        cglibTest.test();
    }
}
