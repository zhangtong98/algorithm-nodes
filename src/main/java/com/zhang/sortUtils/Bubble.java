package com.zhang.sortUtils;

/**
 * Created by zhangtong on 2021/4/28.
 * chongqing liangyao
 * 冒泡排序
 * 冒泡排序是排序算法中较为简单的一种，英文称为Bubble Sort。
 * 它遍历所有的数据，每次对相邻元素进行两两比较，如果顺序和预先规定的顺序不一致，则进行位置交换；
 * 这样一次遍历会将最大或最小的数据上浮到顶端，之后再重复同样的操作，直到所有的数据有序。
 * 如果有n个数据，那么需要O(n^2)的比较次数，所以当数据量很大时，冒泡算法的效率并不高。
 * 当输入的数据是反序时，花的时间最长，当输入的数据是正序时，时间最短。
 * 平均时间复杂度：O(n^2),空间复杂度：O(1)
 * 动态演示：resources/imgs/sort/bubble.gif
 */
public class Bubble<T extends Comparable<T>> extends AbstractSort<T> {

    @Override
    public void sort(T[] nums) {
        int len = nums.length;
        //用于减少遍历次数
        boolean flag = true;
        for (int i = len - 1; i > 0 && flag; i--) {
            flag = false;
            for (int j = 0; j < i; j++) {
                if (less(nums[j+1],nums[j])){
                    swap(nums,j+1,j);
                    flag = true;
                }
            }
        }
    }
}
