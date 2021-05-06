package com.zhang.sortUtils;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by zhangtong on 2021/5/6.
 * chongqing liangyao
 * 桶排序
 * 桶排序也称为箱排序，英文称为 Bucket Sort。它是将数组划分到一定数量的有序的桶里，
 * 然后再对每个桶中的数据进行排序，最后再将各个桶里的数据有序的合并到一起。
 * 平均时间复杂度：O(n+k)
 * 空间复杂度：O(n+k)
 *
 * 算法描述
 * 1.找出待排序数组中的最大值max、最小值min
 * 2.我们使用 动态数组ArrayList 作为桶，桶里放的元素也用 ArrayList 存储。桶的数量为(max-min)/arr.length+1
 * 3.遍历数组 arr，计算每个元素 arr[i] 放的桶
 * 4.每个桶各自排序
 * 5.遍历桶数组，把排序好的元素放进输出数组
 *
 * 稳定性
 * 可以看出，在分桶和从桶依次输出的过程是稳定的。但是，由于我们在对每个桶进行排序时使用了其他算法，
 * 所以，桶排序的稳定性依赖于这一步。如果我们使用了快排，显然，算法是不稳定的。
 * 适用场景
 * 桶排序可用于最大最小值相差较大的数据情况，但桶排序要求数据的分布必须均匀，否则可能导致数据都集中到一个桶中。
 * 比如[104,150,123,132,20000], 这种数据会导致前4个数都集中到同一个桶中。导致桶排序失效。
 */
public class BucketSort<T extends Comparable<T>> extends AbstractSort<T> {
    @Override
    public void sort(T[] _nums) {
        Integer[] nums = (Integer[])_nums;
        Integer min = nums[0];
        Integer max = nums[0];
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            min = Math.min(nums[i], min);
            max = Math.max(nums[i], max);
        }

        //桶数
        int bucketNum = (max - min) / len + 1;
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketNum);
        for (int i = 0; i < bucketNum; i++) {
            bucketArr.add(new ArrayList<Integer>());
        }
        //将每个元素放入桶
        for (int i = 0; i < len; i++) {
            int num = (nums[i] - min) / len;
            bucketArr.get(num).add(nums[i]);
        }
        int n = 0;
        //对每个桶进行排序
        for (ArrayList<Integer> bucket : bucketArr) {
            Collections.sort(bucket);
            for (int i = 0; i < bucket.size(); i++) {
                nums[n++] = bucket.get(i);
            }
        }
    }
}
