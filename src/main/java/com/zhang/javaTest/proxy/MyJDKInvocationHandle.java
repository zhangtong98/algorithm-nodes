package com.zhang.javaTest.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by kongweichun on 2021/3/10.
 * chongqing liangyao
 * JDK动态代理实现InvocationHandler接口并重写invoke方法
 */
public class MyJDKInvocationHandle implements InvocationHandler {

    //代理类中的真实对象
    private final Object target;

    public MyJDKInvocationHandle(Object target){
        this.target = target;
    }
    /**
     * 当我们调用对象的原生方法时，实际上调用的是invoke方法，invoke方法代替我们去调用对象的原生方法
     * @param proxy 动态生成的代理类
     * @param method 与代理类调用的方法对应
     * @param args 参数
     * @return
     */
    @Override
    public Object invoke(Object proxy, Method method,Object[] args)
            throws InvocationTargetException, IllegalAccessException {
        System.out.println("JDK proxy before");
        //执行被代理对象对应的方法,这里传入代理类中的真实对象
        Object res = method.invoke(target,args);
        System.out.println("JDK proxy end");
        return res;
    }
}
