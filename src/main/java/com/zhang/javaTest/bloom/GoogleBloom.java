package com.zhang.javaTest.bloom;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

/**
 * Created by kongweichun on 2021/3/30.
 * chongqing liangyao
 */
public class GoogleBloom {
    public static void main(String[] args) {
        BloomFilter<Integer> bf = BloomFilter.create(
                //整型
                Funnels.integerFunnel(),
                //最多存放多少元素
                10000,
                //允许误判概率
                0.01);
        for (int i = 0; i < 9000; i++) {
            bf.put(i);
        }
        int c = 0;
        for (int i = 9000; i < 18000; i++) {
            if (bf.mightContain(i)) c++;
        }
        System.out.println(c);
    }
}
