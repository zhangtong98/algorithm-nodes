package com.zhang.numberUtils;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by zhangtong on 2021/4/27.
 * chongqing liangyao
 */
public class ArrayGenerater {
    private static Random random = new Random();

    /**
     * 生成不重复数组
     * @return
     */
    public static Integer[] notRepeatArrayGenerater(int size){
        Set<Integer> set = new HashSet<>();
        while (true){
            Integer item = random.nextInt(Integer.MAX_VALUE);
            set.add(random.nextBoolean() ? item : -item);
            if (set.size() == size) break;
        }
        return set.toArray(new Integer[size]);
    }
}
