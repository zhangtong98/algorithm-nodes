package com.zhang.sortUtils;

/**
 * Created by zhangtong on 2021/5/6.
 * chongqing liangyao
 * 4. 算法改进
 * #4.1 切换到插入排序
 *  因为快速排序在小数组中也会递归调用自己，对于小数组，插入排序比快速排序的性能更好，因此在小数组中可以切换到插入排序。
 * #4.2 三数取中
 *  最好的情况下是每次都能取数组的中位数作为切分元素，但是计算中位数的代价很高。一种折中方法是取 3 个元素，
 *  并将大小居中的元素作为切分元素。
 * #4.3 三向切分
 *  对于有大量重复元素的数组，可以将数组切分为三部分，分别对应小于、等于和大于切分元素。
 *  三向切分快速排序对于有大量重复元素的随机数组可以在线性时间内完成排序。
 */
public class ThreeWayQuickSort<T extends Comparable<T>> extends QuickSort<T> {

    @Override
    public void sort(T[] nums, int l, int h){
        if (h <= l) return;

        int lt = l, i = l + 1, gt = h;
        T v = nums[l];
        while (i <= gt){
            int cmp = nums[i].compareTo(v);
            if (cmp < 0){
                swap(nums, lt++, i++);
            }else if (cmp > 0){
                swap(nums, i, gt--);
            }else {
                i++;
            }
        }
        sort(nums, l, lt - 1);
        sort(nums, gt + 1, h);
    }

    /**
     * 5. 基于切分的快速选择算法
     * 快速排序的 partition() 方法，会返回一个整数 j 使得 a[l..j-1] 小于等于 a[j]，
     * 且 a[j+1..h] 大于等于 a[j]，此时 a[j] 就是数组的第 j 大元素。
     * 可以利用这个特性找出数组的第 k 个元素。
     * 该算法是线性级别的，假设每次能将数组二分，那么比较的总次数为 (N+N/2+N/4+..)，
     * 直到找到第 k 个元素，这个和显然小于 2N。
     */
    public T select(T[] nums, int k) {
        int l = 0, h = nums.length - 1;
        while (h > l) {
            int j = partition(nums, l, h);

            if (j == k){
                return nums[k];
            }else if (j < k){
                l = j + 1;
            }else {
                h = j - 1;
            }
        }
        return nums[k];
    }
}
