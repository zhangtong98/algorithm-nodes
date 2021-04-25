package com.zhang.leetCode.easy;

import java.util.Arrays;

/**
     给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
     示例 1:
     输入: [3,0,1]
     输出: 2
     示例 2:
     输入: [9,6,4,2,3,5,7,0,1]
     输出: 8
     说明:
     你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?
 */
public class MissingNumber {

    public static void main(String[] args) {
        System.out.println(missingNumberV4(new int[]{3,0,1}));
    }

    public static int missingNumberV4(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }

    public static int missingNumberV3(int[] nums) {
        int sum = 0;
        int _sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            _sum += i;
        }
        return _sum+nums.length-sum;
    }

    public static int missingNumberV2(int[] nums) {
        int _nums[] = new int[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            _nums[nums[i]] = nums[i];
        }
        for (int i = 0; i < _nums.length; i++) {
            if (_nums[i] == 0 && i != 0) return i;
        }
        return 0;
    }

    public static int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) return i;
        }
        return nums.length;
    }
}
