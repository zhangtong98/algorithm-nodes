package com.zhang.sortUtils;

/**
 * Created by zhangtong on 2021/4/28.
 * chongqing liangyao
 * 待排序的元素需要实现 Java 的 Comparable 接口，该接口有 compareTo() 方法，可以用它来判断两个元素的大小关系。
 * 使用辅助函数 less() 和 swap() 来进行比较和交换的操作，使得代码的可读性和可移植性更好。
 * 排序算法的成本模型是比较和交换的次数。
 *
 * 链接：resources/imgs/sort/sort.jpg
 * 「稳定」是指当排序后两个相等键值的顺序和排序之前的顺序相同；
 * n: 代表数据规模及数据量大小
 * k: 桶的个数
 * In-place: 不占用额外内存，只占用常数内存
 * Out-place: 占用额外内存
 */
public abstract class AbstractSort<T extends Comparable<T>> {
    public abstract void sort(T[] nums);

    public boolean less(T a, T b){
        return a.compareTo(b) < 0;
    }

    public void swap(T[] a, int i, int j){
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
