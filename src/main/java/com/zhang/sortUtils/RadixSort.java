package com.zhang.sortUtils;

import java.util.ArrayList;

/**
 * Created by zhangtong on 2021/5/6.
 * chongqing liangyao
 * 基数排序
 * 基数排序(Radix Sort)是桶排序的扩展，它的基本思想是：将整数按位数切割成不同的数字，然后按每个位数分别比较。
 * 排序过程：将所有待比较数值（正整数）统一为同样的数位长度，数位较短的数前面补零。然后，从最低位开始，依次进行一次排序。
 * 这样从最低位排序一直到最高位排序完成以后, 数列就变成一个有序序列。
 * 算法描述
 * 取得数组中的最大数，并取得位数；
 * arr为原始数组，从最低位开始取每个位组成radix数组；
 * 对radix进行计数排序（利用计数排序适用于小范围数的特点）；
 */
public class RadixSort<T extends Comparable<T>> extends AbstractSort<T> {
    private int radix;

    public RadixSort() {
        this.radix = 10;
    }

    @Override
    public void sort(T[] _nums) {
        Integer[] arr = (Integer[]) _nums;
        int length = arr.length;

        //最大值
        int max = arr[0];
        for (int i = 0; i < length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        //当前排序位置
        int location = 1;

        //桶列表
        ArrayList<ArrayList<Integer>> bucketList = new ArrayList<>();

        //长度为10 装入余数0-9的数据
        for (int i = 0; i < 10; i++) {
            bucketList.add(new ArrayList());
        }

        while (true) {
            //判断是否排完
            int dd = (int) Math.pow(10, (location - 1));
            if (max < dd) {
                break;
            }

            //数据入桶
            for (int i = 0; i < length; i++) {
                //计算余数 放入相应的桶
                int number = ((arr[i] / dd) % 10);
                bucketList.get(number).add(arr[i]);
            }

            //写回数组
            int nn = 0;
            for (int i = 0; i < 10; i++) {
                int size = bucketList.get(i).size();
                for (int ii = 0; ii < size; ii++) {
                    arr[nn++] = bucketList.get(i).get(ii);
                }
                bucketList.get(i).clear();
            }
            location++;
        }
    }

    private int getDistance(Integer[] nums) {
        Integer max = computeMax(nums);
        int digits = 0;
        int temp = max / radix;
        while (temp != 0) {
            digits++;
            temp /= radix;
        }
        return digits + 1;
    }

    private int computeMax(Integer[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        return max;
    }
}
