package com.zhang.leetCode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
     使用栈实现队列的下列操作：
     push(x) -- 将一个元素放入队列的尾部。
     pop() -- 从队列首部移除元素。
     peek() -- 返回队列首部的元素。
     empty() -- 返回队列是否为空。
     示例:
     MyQueue queue = new MyQueue();
     queue.push(1);
     queue.push(2);
     queue.peek();  // 返回 1
     queue.pop();   // 返回 1
     queue.empty(); // 返回 false
     说明:
     你只能使用标准的栈操作 -- 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
     你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
     假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）。
 */
public class MyQueueTest {

    public static void main(String[] args) {
        MyQueueV2 queue = new MyQueueV2();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println(queue.peek());  // 返回 1
        System.out.println(queue.pop());   // 返回 1
        System.out.println(queue.pop());
        System.out.println(queue.empty());  // 返回 false
    }
}

class MyQueueV2 {

    private Stack<Integer> stackPush;
    private Stack<Integer> stackPop;

    /** Initialize your data structure here. */
    public MyQueueV2() {
        stackPush = new Stack<>();
        stackPop = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stackPush.push(x);
    }

    private void shift(){
        if (stackPop.isEmpty()){
            while (!stackPush.isEmpty()){
                stackPop.push(stackPush.pop());
            }
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        shift();
        if (stackPop.size() == 0) throw new NullPointerException("NullPointerException");
        return stackPop.pop();
    }

    /** Get the front element. */
    public int peek() {
        shift();
        if (stackPop.size() == 0) throw new NullPointerException("NullPointerException");
        return stackPop.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stackPop.isEmpty() && stackPush.isEmpty();
    }
}

class MyQueue {

    private Stack<Integer> stack;

    /** Initialize your data structure here. */
    public MyQueue() {
        stack = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        Stack<Integer> _stack = new Stack<>();
        _stack.push(x);
        List<Integer> l = new ArrayList<>();
        while (stack.size() != 0){
            l.add(stack.pop());
        }
        for (int i = l.size()-1; i >= 0; i--) {
            _stack.push(l.get(i));
        }
        stack = _stack;
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (stack.size() == 0) throw new NullPointerException("NullPointerException");
        return stack.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (stack.size() == 0) throw new NullPointerException("NullPointerException");
        return stack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */