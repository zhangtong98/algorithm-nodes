package com.zhang.leetCode.easy;

import java.util.*;

/**
     给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
     示例 1:
     输入: nums = [1,2,3,1], k = 3
     输出: true
     示例 2:
     输入: nums = [1,0,1,1], k = 1
     输出: true
     示例 3:
     输入: nums = [1,2,3,1,2,3], k = 2
     输出: false
 */
public class ContainsNearbyDuplicate {

    public static void main(String[] args) {
        System.out.println(containsNearbyDuplicateV3(new int[]{99,99},2));
    }

    public static boolean containsNearbyDuplicateV3(int[] nums, int k) {
        boolean flag = false;
        int[] _nums = nums.clone();
        Arrays.sort(_nums);
        for (int i = 0; i < _nums.length-1; i++) {
            if (_nums[i] == _nums[i+1]) flag = searchIndex(_nums[i], nums, k);
        }
        return flag;
    }
    private static boolean searchIndex(int num, int[] nums, int k){
        List<Integer> indexs = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (num == nums[i]) indexs.add(i);
        }
        for (int i = 0; i < indexs.size()-1; i++) {
            if (indexs.get(i+1)-indexs.get(i)<=k) return true;
        }

        return false;
    }

    public static boolean containsNearbyDuplicateV2(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) return true;
            if (set.size() > k) set.remove(nums[i-k]);
        }
        return false;
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        int len = nums.length;
        if (len < 2) return false;
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j <= (i+k>len-1?len-1:i+k); j++) {
                if (nums[i] == nums[j]) return true;
            }
        }
        return false;
    }
}
