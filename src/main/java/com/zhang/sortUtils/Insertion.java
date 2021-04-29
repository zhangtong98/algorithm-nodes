package com.zhang.sortUtils;

/**
 * Created by zhangtong on 2021/4/28.
 * chongqing liangyao
 * 插入排序
 * 插入排序英文称为Insertion Sort，它通过构建有序序列，对于未排序的数据序列，在已排序序列中从后向前扫描，
 * 找到相应的位置并插入，类似打扑克牌时的码牌。插入排序有一种优化的算法，可以进行拆半插入。
 * 基本思路是先将待排序序列的第一个元素看做一个有序序列，把第二个元素到最后一个元素当成是未排序序列；
 * 然后从头到尾依次扫描未排序序列，将扫描到的每个元素插入有序序列的适当位置，直到所有数据都完成排序；
 * 如果待插入的元素与有序序列中的某个元素相等，则将待插入元素插入到相等元素的后面。
 * 平均时间复杂度：O(n^2)
 * 空间复杂度：O(1)
 * 动态演示：resources/imgs/sort/insertion.gif
 */
public class Insertion<T extends Comparable<T>> extends AbstractSort<T> {

    @Override
    public void sort(T[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i; j > 0 && less(nums[j],nums[j-1]); j--) {
                swap(nums,j,j-1);
            }
        }
    }
}
