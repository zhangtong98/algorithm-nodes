package com.zhang.leetCode.easy;

import java.util.Arrays;
import java.util.HashMap;

/**
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     示例:
     给定 nums = [2, 7, 11, 15], target = 9
     因为 nums[0] + nums[1] = 2 + 7 = 9
     所以返回 [0, 1]
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] arr = {0,4,3,0};
        System.out.println(Arrays.toString(twoSumV3(arr, 0)));
    }

    public static int[] twoSumV3(int[] nums, int target){
        int n=2048;
        //存数组下标
        int[] map = new int[n];
        int max=n-1;
        for(int i=0;i<nums.length;i++){
            //查看map中下标为 target-nums[i] 的数是否为0，为0说明前面没匹配数进去，不为0说明已经匹配数进去
            //& max防止下标为负数
            int b = map[(target-nums[i]) & max];
            if (b!=0){
                //b-1：前面存进时 +1的
                return new int[]{b-1,i};
            }
            //把下标存入map中，+1是因为数组中默认为0，不存0
            map[nums[i]&max]=i+1;
        }
        return null;
    }

    public static int[] twoSumV2(int[] nums, int target) {
        HashMap<Integer, Integer> resultMap = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
            if(resultMap.containsKey(nums[i])){
                return new int[]{resultMap.get(nums[i]), i};
            }
            resultMap.put(target-nums[i], i);
        }
        return new int[]{-1, 0};
    }

    //暴力循环
    public int[] twoSumV1(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, 0};
    }
}
