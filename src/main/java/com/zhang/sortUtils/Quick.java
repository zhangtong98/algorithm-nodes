package com.zhang.sortUtils;

/**
 * Created by zhangtong on 2021/4/30.
 * chongqing liangyao
 * 快速排序
 * 快速排序,英文称为Quicksort，又称划分交换排序 partition-exchange sort 简称快排。
 * 快速排序使用分治法（Divide and conquer）策略来把一个序列（list）分为两个子序列（sub-lists）。
 * 首先从数列中挑出一个元素，并将这个元素称为「基准」，英文pivot。重新排序数列，所有比基准值小的元素摆放在基准前面，
 * 所有比基准值大的元素摆在基准后面（相同的数可以到任何一边）。在这个分区结束之后，该基准就处于数列的中间位置。
 * 这个称为分区（partition）操作。之后，在子序列中继续重复这个方法，直到最后整个数据序列排序完成。
 * 在平均状况下，排序n个项目要O(nlogn)次比较。在最坏状况下则需要O(n^2)次比较，但这种状况并不常见。
 * 事实上，快速排序通常明显比其他算法更快，因为它的内部循环可以在大部分的架构上很有效率地达成。
 * 平均时间复杂度：O(nlogn)
 * 空间复杂度：O(logn)
 * 动态演示：resources/imgs/sort/quick.gif
 * 代码分两种方式实现，分别为迭代法和递归法。
 */
public abstract class Quick<T extends Comparable<T>> extends AbstractSort<T> {

    protected T[] aux;


}
