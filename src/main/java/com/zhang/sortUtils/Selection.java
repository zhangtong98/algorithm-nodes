package com.zhang.sortUtils;


/**
 * Created by zhangtong on 2021/4/28.
 * chongqing liangyao
 * 选择排序
 * 选择排序简单直观，英文称为Selection Sort，先在数据中找出最大或最小的元素，放到序列的起始；
 * 然后再从余下的数据中继续寻找最大或最小的元素，依次放到排序序列中，直到所有数据样本排序完成。
 * 很显然，选择排序也是一个费时的排序算法，无论什么数据，都需要O(n^2)的时间复杂度，不适宜大量数据的排序。
 * 平均时间复杂度：O(n^2),空间复杂度：O(1)
 * 动态演示：resources/imgs/sort/selection.gif
 */
public class Selection<T extends Comparable<T>> extends AbstractSort<T> {

    @Override
    public void sort(T[] nums) {
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            int index = i;
            for (int j = i+1; j < len; j++) {
                if (less(nums[j],nums[index])){
                    index = j;
                }
            }
            if (index != i) swap(nums,i,index);
        }
    }


}
