package com.zhang.leetCode.easy;

import java.util.*;

/**
 * Created by kongweichun on 2019/12/10.
 * chongqing liangyao
 */
public class MinStackTest {
    public static void main(String[] args) {
        MinStack02 minStack = new MinStack02();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}

class MinStack02 {

    private int[] elementData;
    private int index;
    private int min = 0;

    public MinStack02() {
        elementData = new int[1000];
        index = -1;
    }

    public void push(int x) {
        if (index+1 >= elementData.length) elementData = addLength((index+1)<<2);
        elementData[++index] = x;
        if (elementData[min] > x) min = index;
    }

    private int[] addLength(int lenght){
        int _ele[] = new int[lenght];
        for (int i = 0; i <= index; i++) {
            _ele[i] = elementData[i];
        }
        return _ele;
    }

    public void pop() {
        --index;
        if (index < 0){
            min = 0;
        }else if (index+1 == min){
            min = index;
            for (int i = 0; i < index; i++) {
                if (elementData[i] < elementData[min]) min = i;
            }
        }
    }

    public int top() {
        return index < 0 ? elementData[0] : elementData[index];
    }

    public int getMin() {
        return elementData[min];
    }
}

class MinStack {

    private static final int DEFAULT_CAPACITY = 10;
    private Integer[] elementData;
    private Integer[] arrNew ;
    private int index = 0;


    public MinStack() {
        this.elementData = new Integer[DEFAULT_CAPACITY];
    }

    public void push(int x) {
        if (index >= elementData.length - 1){
            arrNew = new Integer[index + index/2];
            System.arraycopy(elementData, 0, arrNew, 0, index);
            elementData = arrNew;
        }
        elementData[index++] = x;
    }

    public void pop() {
        if (index <= 0) return;
        elementData[--index] = null;
    }

    public int top() {
        if (index <= 0)return Integer.MIN_VALUE;
        return elementData[index-1];
    }

    public int getMin() {
        Integer _ele[] = new Integer[index];
        System.arraycopy(elementData, 0, _ele, 0, index);
        Arrays.sort(_ele);
        return _ele[0];
    }
}

