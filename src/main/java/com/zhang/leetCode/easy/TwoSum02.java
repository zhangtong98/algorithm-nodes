package com.zhang.leetCode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 说明:
 返回的下标值（index1 和 index2）不是从零开始的。
 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 示例:
 输入: numbers = [2, 7, 11, 15], target = 9
 输出: [1,2]
 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 */
public class TwoSum02 {

    public static void main(String[] args) {
        int arr[] = {0,0,3,4};
        System.out.println(Arrays.toString(twoSumV3(arr, 0)));
    }

    public static int[] twoSumV3(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length-1;
        if (numbers[0] >= 0){
            while (left < right){
                int mid = (left + right + 1)>>>1;
                if (target >= numbers[mid]) left = mid;
                else right = mid-1;
            }
        }
        left = 0;
        while (left < right){
            if (numbers[left] + numbers[right] == target) return new int[]{left+1,right+1};
            else if (numbers[left] + numbers[right] < target) left++;
            else right--;
        }
        return null;
    }

    public static int[] twoSumV2(int[] numbers, int target) {
        if (numbers.length < 2) return null;
        if (target < numbers[0] + numbers[1]) return null;

        int n = 2048;
        int arr[] = new int[n];
        int num = n-1;

        for (int i = 0; i < numbers.length; i++) {
            int b = arr[(target - numbers[i]) & num];
            if (b != 0) return new int[]{b, i+1};

            arr[num&numbers[i]] = i+1;
        }
        return null;
    }

    public static int[] twoSum(int[] numbers, int target) {
        if (numbers.length < 2) return null;
        if (target < numbers[0] + numbers[1]) return null;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(numbers[i])) return new int[]{map.get(numbers[i]),i+1};
            map.put(target-numbers[i],i+1);
        }
        return null;
    }
}
