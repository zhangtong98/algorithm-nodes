package com.zhang.sortUtils;

import java.util.Arrays;

/**
 * Created by zhangtong on 2021/4/28.
 * chongqing liangyao
 */
public class SortTest {
    public static void main(String[] args) {
        AbstractSort<Integer> as = new RadixSort<>();
        Integer[] nums = {5, 1, 6, 4, 6, 3, 4, 0, 1, 74, 69, 1, 3};
        as.sort(nums);
        System.out.println(Arrays.toString(nums));
//        ThreeWayQuickSort<Integer> as1 = new ThreeWayQuickSort<>();
//        System.out.println(as1.select(nums,10));
    }
}
