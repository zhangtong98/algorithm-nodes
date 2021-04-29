package com.zhang.other.threeSum;

import com.zhang.numberUtils.BinarySearch;

import java.util.Arrays;

/**
 * Created by zhangtong on 2021/4/27.
 * chongqing liangyao
 * 将数组进行排序，对两数求和的相反数，在对相反数进行二分查找
 * 注意:该数组不应出现重复元素，该方法的增长数量级为O(N^2logN)
 */
public class ThreeSumBinarySearch implements ThreeSum {
    @Override
    public int count(Integer[] nums) {
        int l = nums.length;
        int count = 0;
        Arrays.sort(nums);
        for (int i = 0; i < l; i++) {
            for (int j = i+1; j < l; j++) {
                int target = -nums[i] - nums[j];
                int index = BinarySearch.search(nums,target);
                //防止重复统计
                if (index > j){
                    count++;
                }
            }
        }
        return count;
    }
}
