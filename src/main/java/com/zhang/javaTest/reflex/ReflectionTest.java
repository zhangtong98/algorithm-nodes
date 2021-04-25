package com.zhang.javaTest.reflex;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by kongweichun on 2021/3/10.
 * chongqing liangyao
 */
public class ReflectionTest {
    public static void main(String[] args) throws Exception {
        Class<?> targetClass = Class.forName("com.zhang.javaTest.reflex.TargetObjectTest");
        //创建对象
        TargetObjectTest targetObject = (TargetObjectTest)targetClass.newInstance();

        //获取对象中所有方法 注意：
        // targetClass.getMethods()--获取所有public方法，
        // targetClass.getDeclaredMethods()--获取所有方法
        Method[] methods = targetClass.getDeclaredMethods();
        for (Method m : methods) {
            System.out.println(m.getName());
        }
        //调用public方法
        Method pm = targetClass.getMethod("publicMethod",String.class);
        pm.invoke(targetObject,"publicTest");
        //调用private方法
        Method prm = targetClass.getDeclaredMethod("privateMethod",String.class);
        prm.setAccessible(true);
        prm.invoke(targetObject,"privateTest");
        //调用对象属性
        //targetClass.getField("test"); --只能访问public属性,否则报NoSuchFieldException
        //targetClass.getDeclaredField("test");--能访问所有属性
        Field f = targetClass.getDeclaredField("test");
        f.setAccessible(true);
        f.set(targetObject,"testtt");
        System.out.println(f.get(targetObject));
    }
}
