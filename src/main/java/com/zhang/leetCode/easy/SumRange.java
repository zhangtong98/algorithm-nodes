package com.zhang.leetCode.easy;

/**
     给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
     示例：
     给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()
     sumRange(0, 2) -> 1
     sumRange(2, 5) -> -1
     sumRange(0, 5) -> -3
     说明:
     你可以假设数组不可变。
     会多次调用 sumRange 方法。
 */
public class SumRange {

    public static void main(String[] args) {
        int[] arr = {-2, 0, 3, -5, 2, -1};
        NumArrayV2 array = new NumArrayV2(arr);
        System.out.println(array.sumRange(0,2));
        System.out.println(array.sumRange(2,5));
        System.out.println(array.sumRange(0,5));
    }
}

class NumArrayV2 {
    private int[] sums;

    public NumArrayV2(int[] nums) {
        sums = new int[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            sums[i+1] = sums[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return sums[j+1] - sums[i];
    }
}

class NumArray {
    private int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
    }

    public int sumRange(int i, int j) {
        if (i < 0 || j >= nums.length) throw new IndexOutOfBoundsException("IndexOutOfBoundsException");
        int sum = 0;
        for (int k = i; k <= j; k++) {
            sum += nums[k];
        }
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
