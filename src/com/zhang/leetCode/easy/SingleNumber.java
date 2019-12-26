package com.zhang.leetCode.easy;

import java.util.*;

/**
     给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     说明：
     你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
     示例 1:
     输入: [2,2,1]
     输出: 1
     示例 2:
     输入: [4,1,2,1,2]
     输出: 4
 */
public class SingleNumber {
    public static void main(String[] args) {
        int arr[] = {4,1,2,1,2};
        System.out.println(singleNumberV3(arr));
    }

    public static int singleNumberV3(int[] nums) {
        if (nums.length == 1) return nums[0];
        int res = nums[0];
        for (int i = 2; i < nums.length; i+=2) {
            System.out.println(res);
            res = res ^ nums[i-1] ^ nums[i];
            System.out.println(res);
        }
        return res;
    }
    public static int singleNumberV2(int[] nums) {
        if (nums.length == 1) return nums[0];
        int res = 0;
        for (int num: nums) {
            res ^= num;
        }
        return res;
    }

    public static int singleNumber(int[] nums) {
        if (nums.length == 1) return nums[0];
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (l.contains(nums[i])){
                l.remove((Object)nums[i]);
                continue;
            }
            l.add(nums[i]);
        }
        return l.get(0);
    }
}
