package com.zhang.sortUtils;

/**
 * Created by zhangtong on 2021/4/28.
 * chongqing liangyao
 * 自上而下的递归；
 * 将一个大数组分成两个小数组去求解。
 * 因为每次都将问题对半分成两个子问题，这种对半分的算法复杂度一般为 O(NlogN)。
 *
 * 动态演示：resources/imgs/sort/up2DownMergeSort.gif
 */
public class Up2DownMergeSort<T extends Comparable<T>> extends MergeSort<T> {

    @Override
    public void sort(T[] nums) {
        aux = (T[])new Comparable[nums.length];
        sort(nums, 0, nums.length-1);
    }

    private void sort(T[] nums, int l, int h){
        if (l >= h) return;

        int mid = l + (h - l) / 2;
        sort(nums, 0, mid);
        sort(nums, mid + 1, h);
        merge(nums, l, mid, h);
    }
}
