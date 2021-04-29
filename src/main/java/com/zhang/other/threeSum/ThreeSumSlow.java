package com.zhang.other.threeSum;

/**
 * Created by zhangtong on 2021/4/27.
 * chongqing liangyao
 * 该算法的内循环为if (nums[i] + nums[j] + nums[k] == 0)语句，
 * 总共执行的次数为N(N-1)(N-2)=N^3/6-N^2/2+N/3,近似执行次数为~N^3/6
 * 增长数量级为O(N^3)
 */
public class ThreeSumSlow implements ThreeSum{
    @Override
    public int count(Integer[] nums) {
        int count = 0;
        int l = nums.length;
        for (int i = 0; i < l; i++) {
            for (int j = i+1; j < l; j++) {
                for (int k = j+1; k < l; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
