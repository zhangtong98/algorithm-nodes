package com.zhang.sortUtils;

/**
 * Created by zhangtong on 2021/4/28.
 * chongqing liangyao
 * 自下而上的迭代
 * 先归并那些微型数组，然后成对归并得到的微型数组。
 */
public class Down2UpMergeSort<T extends Comparable<T>> extends MergeSort<T> {

    @Override
    public void sort(T[] nums) {
        int len = nums.length;
        aux = (T[])new Comparable[len];

        for (int i = 1; i < len; i+=i) { // 定义微型数组元素个数
            for (int j = 0; j < len - i; j+=(i+i)) { // 合并两个相邻微型数组
                merge(nums, j, j+i-1, Math.min(j + i + i - 1, len - 1));
            }
        }
    }
}
