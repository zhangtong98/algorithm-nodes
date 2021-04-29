package com.zhang.other.threeSum;

import java.util.Arrays;

/**
 * Created by zhangtong on 2021/4/27.
 * chongqing liangyao
 * 首先将数组进行排序，然后使用双指针进行查找
 * 时间复杂度为O(N2)
 * 同样不适合有重复元素的数组
 */
public class ThreeSumTwoPointer implements ThreeSum {
    @Override
    public int count(Integer[] nums) {
        int len = nums.length;
        int count = 0;
        Arrays.sort(nums);
        for (int i = 0; i < len - 2; i++) {
            int l = i + 1,h = len - 1,target = -nums[i];
            while (l < h){
                int sum = nums[l] + nums[h];
                if (target == sum){
                    count++;
                    l++;
                    h--;
                }else if (target > sum){
                    l++;
                }else {
                    h--;
                }
            }
        }
        return count;
    }
}
