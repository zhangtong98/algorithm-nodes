package com.zhang.javaTest.bloom;

import java.util.BitSet;

/**
 * Created by kongweichun on 2021/3/30.
 * chongqing liangyao
 */
public class BloomFilterTest{
    public static void main(String[] args) {
        MyBloomFilter<String> ibf = new MyBloomFilter<>();
        for (int i = 0; i < 100; i++) {
            ibf.addItem(i+"");
        }
        int c = 0;
        for (int i = 100; i < 200; i++) {
            if (ibf.contains(i+""))
                c++;
        }
        System.out.println(c);
    }
}

class MyBloomFilter<T> {
    //位数组默认长度
    private static final int DEFAULT_SIZE = 2 << 23;
    //位数组
    private BitSet bit = new BitSet(DEFAULT_SIZE);
    //hash函数信号量
    private static final int[] HASH_FUN_SIGNAL = {3,7,19,57,73,91};
    //hash函数
    private SimpleHash[] simpleHashs = new SimpleHash[HASH_FUN_SIGNAL.length];

    public MyBloomFilter(){
        for (int i = 0; i < HASH_FUN_SIGNAL.length; i++) {
            simpleHashs[i] = new SimpleHash(DEFAULT_SIZE,HASH_FUN_SIGNAL[i]);
        }
    }
    //添加元素
    public void addItem(T item){
        for (SimpleHash s: simpleHashs) {
            bit.set(s.hash(item),true);
        }
    }

    //查看是否包含元素
    public boolean contains(T item){
        boolean result = true;
        for (SimpleHash s: simpleHashs) {
            //这里防止中间为false
            result = result && bit.get(s.hash(item));
        }
        return result;
    }

    private static class SimpleHash{
        int size;
        int signal;
        SimpleHash(int size,int signal){
            this.size = size;
            this.signal = signal;
        }
        public int hash(Object value){
            int h;
            return value == null ? 0 : Math.abs(signal * (size - 1)
                    & ((h = value.hashCode()) ^ (h >>> 16)));
        }
    }
}
