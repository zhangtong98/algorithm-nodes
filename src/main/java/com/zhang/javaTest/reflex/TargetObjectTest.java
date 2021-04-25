package com.zhang.javaTest.reflex;

/**
 * Created by kongweichun on 2021/3/10.
 * chongqing liangyao
 */
public class TargetObjectTest {
    private String test = "test";
    public TargetObjectTest(){
        System.out.println("TargetObject()");
    }
    public void publicMethod(String s){
        System.out.println(s);
    }

    private void privateMethod(String test){
        this.test = test;
        System.out.println(this.test);
    }
}
