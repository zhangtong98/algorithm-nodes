package com.zhang.javaTest.myCollection;

import java.util.Arrays;

/**
 * Created by kongweichun on 2021/3/26.
 * chongqing liangyao
 */
public class MyArrayStack {
    private int[] storage;
    //容量
    private int capacity;
    //元素个数
    private int size;
    //扩容因子
    private static final int GROW_FACTOR = 2;
    public MyArrayStack(){
        //默认容量为8
        capacity = 8;
        size = 0;
        storage = new int[capacity];
    }
    public MyArrayStack(int capacity){
        if (capacity < 1)
            throw new IllegalArgumentException();
        this.capacity = capacity;
        size = 0;
        storage = new int[capacity];
    }
    //入栈
    public void push(int ele){
        //确保容量大小
        ensureCapacity();
        storage[size++] = ele;
    }
    private void ensureCapacity(){
        int newCapacity;
        if (size >= capacity*0.7){
            newCapacity = capacity*GROW_FACTOR;
        }else if (size <= capacity*0.4 && capacity > 8){
            newCapacity = capacity/GROW_FACTOR;
        }else {
            return;
        }
        storage = Arrays.copyOf(storage,newCapacity);
        capacity = newCapacity;
    }
    //获取栈顶元素不出栈
    public int peek(){
        if (count() == 0)
            throw new RuntimeException("Stack is null");
        return storage[size-1];
    }
    //获取栈顶元素并出栈
    public int pop(){
        if (count() == 0)
            throw new RuntimeException("Stack is null");
        size--;
        ensureCapacity();
        return storage[size];
    }
    //元素个数
    public int count(){
        return size;
    }

    public static void main(String[] args) {
        MyArrayStack arrayStack = new MyArrayStack();
        arrayStack.count();
        for (String s : args) {
            arrayStack.push(Integer.valueOf(s));
        }
        System.out.println(arrayStack.count());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.count());
        arrayStack.peek();
    }
}
