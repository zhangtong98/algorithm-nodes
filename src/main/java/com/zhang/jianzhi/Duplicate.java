package com.zhang.jianzhi;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhangtong on 2019/11/4.
 *
 * 数组中重复的数字
 *      在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字是重复的，
 *      也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 *
 * 解题思路（/jianzhi/JianZhi03.gif）
 *     要求时间复杂度 O(N)，空间复杂度 O(1)。因此不能使用排序的方法，也不能使用额外的标记数组。
 *     对于这种数组元素在 [0, n-1] 范围内的问题，可以将值为 i 的元素调整到第 i 个位置上进行求解。
 *     本题要求找出重复的数字，因此在调整过程中，如果第 i 位置上已经有一个值为 i 的元素，就可以知道 i 值重复。
 *     以 (2, 3, 1, 0, 2, 5) 为例，遍历到位置 4 时，该位置上的数为 2，但是第 2 个位置上已经有一个 2 的值了，
 *     因此可以知道 2 重复：
 */
public class Duplicate {
    public static void main(String[] args) {
        int[] nums = {0, 3, 1, 0, 2, 5};
        int[] deplication = new int[1];
        int length = nums.length;
        duplicate2(nums, length, deplication);
        System.err.println(deplication[0]);
    }

    public static boolean duplicate2(int[] nums, int length, int[] deplication){
        if (nums == null || length <= 0)
            return false;

        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                deplication[0] = nums[i];
                return true;
            }
        }
        return false;
    }

    public static boolean duplicate(int[] nums, int length, int[] deplication){
        if (nums == null || length <= 0)
            return false;

        for (int i = 0; i < length; i++) {
            //nums中下标为i的数不等于i
            while (nums[i] != i){
                //nums中下标为i的数等等于nums中下标为（nums中下标为i的数）的数，即数组中这两个数相等
                if (nums[i] == nums[nums[i]]) {
                    deplication[0] = nums[i];
                    return true;
                }
                //交换nums中下标为i的数和下标为（nums中下标为i的数）的数
                swap(nums, i, nums[i]);
            }
        }
        return false;
    }

    //两数交换
    public static void swap(int[] nums, int i, int j){
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }
}
