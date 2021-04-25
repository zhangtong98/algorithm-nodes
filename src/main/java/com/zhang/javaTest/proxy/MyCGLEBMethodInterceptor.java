package com.zhang.javaTest.proxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by kongweichun on 2021/3/10.
 * chongqing liangyao
 */
public class MyCGLEBMethodInterceptor implements MethodInterceptor {

    /**
     *
     * @param target 被代理对象
     * @param method 被拦截的方法
     * @param args 方法参数
     * @param methodProxy 用于调用原始方法
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object target, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("CGLEB Proxy before");
        //调用原始方法
        Object res = methodProxy.invokeSuper(target,args);
        System.out.println("CGLEB Proxy end");
        return res;
    }
}
