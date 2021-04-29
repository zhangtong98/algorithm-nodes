package com.zhang.sortUtils;

/**
 * Created by zhangtong on 2021/4/28.
 * chongqing liangyao
 * 归并排序
 * 归并排序英文称为Merge Sort，归并排序是建立在归并操作上的一种有效的排序算法。
 * 该算法是采用分治法（Divide and Conquer）的一个非常典型的应用。它首先将数据样本拆分为两个子数据样本,
 * 并分别对它们排序, 最后再将两个子数据样本合并在一起; 拆分后的两个子数据样本序列,
 * 再继续递归的拆分为更小的子数据样本序列, 再分别进行排序, 直到最后数据序列为1，而不再拆分，此时即完成对数据样本的最终排序。
 * 归并排序严格遵循从左到右或从右到左的顺序合并子数据序列, 它不会改变相同数据之间的相对顺序, 因此归并排序是一种稳定的排序算法.
 * 平均时间复杂度：O(nlogn)
 * 空间复杂度：O(n)
 */
public abstract class MergeSort<T extends Comparable<T>> extends AbstractSort<T> {

    protected T[] aux;

    protected void merge(T[] nums, int l, int m, int h){
        int i = l, j = m + 1;

        for (int k = l; k <= h; k++) {
            aux[k] = nums[k];
        }

        for (int k = l; k <= h; k++) {
            nums[k] = i > m ? aux[j++]
                    : j > h ? aux[i++]
                    : less(aux[j], aux[i]) ? aux[j++]
                    : aux[i++];
        }
    }
}
