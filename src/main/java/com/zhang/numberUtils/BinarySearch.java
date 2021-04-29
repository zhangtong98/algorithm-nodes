package com.zhang.numberUtils;

/**
 * Created by zhangtong on 2021/4/27.
 * chongqing liangyao
 * 二分查找，必须为排序数组
 */
public class BinarySearch {
    public static int search(Integer[] nums,int target) {
        int l = 0, h = nums.length - 1;
        while (l <= h) {
            //不用(h + l)/2是因为如果数组长度非常大，
            // h + l值可能会超出int范围，导致程序结果出乎意料
            int mid = l + (h - l) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return -1;
    }
}
