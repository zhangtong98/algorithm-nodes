package com.zhang.leetCode.easy;

import java.util.Arrays;

/**
     给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
     示例 1:
     输入: [1,2,3,4,5,6,7] 和 k = 3
     输出: [5,6,7,1,2,3,4]
     解释:
     向右旋转 1 步: [7,1,2,3,4,5,6]
     向右旋转 2 步: [6,7,1,2,3,4,5]
     向右旋转 3 步: [5,6,7,1,2,3,4]
     示例 2:
     输入: [-1,-100,3,99] 和 k = 2
     输出: [3,99,-1,-100]
     解释:
     向右旋转 1 步: [99,-1,-100,3]
     向右旋转 2 步: [3,99,-1,-100]
     说明:
     尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
     要求使用空间复杂度为 O(1) 的 原地 算法。
 */
public class Rotate {

    public static void main(String[] args) {
        int a[] = {1,2};
        rotatev3(a,3);
        System.out.println(Arrays.toString(a));
    }

    public static void rotatev3(int[] nums, int k) {
        int len = nums.length;
        k%=len;
        if (k % len == 0) return;
        reverse(nums, 0, len-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, len-1);
    }
    private static void reverse(int[] nums, int start, int end){
        while (start < end){
            nums[start] = nums[start] ^ nums[end];
            nums[end] = nums[start] ^ nums[end];
            nums[start] = nums[start] ^ nums[end];
            start++;end--;
        }
    }

    public static void rotatev2(int[] nums, int k) {
        int len = nums.length;
        k %= len;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int cur = start;
            int prev = nums[start];
            do {
                int next = (cur + k)%len;
                prev = nums[next] ^ prev;
                nums[next] = nums[next] ^ prev;
                prev = nums[next] ^ prev;
                cur = next;
                count++;
            }while (cur != start);
        }
    }

    public static void rotate(int[] nums, int k) {
        int len = nums.length;
        if (k % len == 0) return;
        int _nums[] = new int[len];
        for (int i = 0; i < len; i++) {
            _nums[(i+k)%len] = nums[i];
        }
        for (int i = 0; i < len; i++) {
            nums[i] = _nums[i];
        }
    }
}
