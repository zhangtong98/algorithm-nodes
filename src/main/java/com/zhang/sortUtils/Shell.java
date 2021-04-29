package com.zhang.sortUtils;

/**
 * Created by zhangtong on 2021/4/28.
 * chongqing liangyao
 * 希尔排序
 * 希尔排序也称递减增量排序，是插入排序的一种改进版本，英文称为Shell Sort，效率虽高，但它是一种不稳定的排序算法。
 * 插入排序在对几乎已经排好序的数据操作时，效果是非常好的；但是插入排序每次只能移动一位数据，因此插入排序效率比较低。
 * 希尔排序在插入排序的基础上进行了改进，它的基本思路是先将整个数据序列分割成若干子序列分别进行直接插入排序，
 * 待整个序列中的记录基本有序时，再对全部数据进行依次直接插入排序。
 * 平均时间复杂度：O(nlogn)
 * 空间复杂度：O(1)
 * 图解：resources/imgs/sort/shell.jpg
 */
public class Shell<T extends Comparable<T>> extends AbstractSort<T> {

    @Override
    public void sort(T[] nums) {
        int len = nums.length;
        int h = 1;
        while (h < len/3){
            h = h * 3 + 1;
        }

        while (h >= 1){
            for (int i = h; i < len; i++) {
                for (int j = i; j >= h && less(nums[j],nums[j-h]); j-=h) {
                    swap(nums,j,j-h);
                }
            }
            h /= 3;
        }
    }
}
