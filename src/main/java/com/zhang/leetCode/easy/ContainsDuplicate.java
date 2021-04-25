package com.zhang.leetCode.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
     给定一个整数数组，判断是否存在重复元素。
     如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
     示例 1:
     输入: [1,2,3,1]
     输出: true
     示例 2:
     输入: [1,2,3,4]
     输出: false
     示例 3:
     输入: [1,1,1,3,3,4,3,2,4,2]
     输出: true
 */
public class ContainsDuplicate {

    public static void main(String[] args) {
        System.out.println(containsDuplicateV2(new int[]{1,1,1,3,3,4,3,2,4,2}));
    }

    public static boolean containsDuplicateV2(int[] nums) {

        if (nums.length <= 1) return false;

        for (int i = 1; i < nums.length; i++) {
            int j = i - 1;
            for (; j >= 0; j--) {
                if (nums[j] == nums[i]) return true;
                if (nums[j] < nums[i]) break;
            }
            j++;
            if (j < i) {
                nums[j] = nums[i] ^ nums[j];
                nums[i] = nums[i] ^ nums[j];
                nums[j] = nums[i] ^ nums[j];
            }
        }

        return false;
    }


    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) return true;
        }
        return false;
    }
}
