package com.zhang.leetCode.easy;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
     给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。
     示例 1:
     输入: [3, 2, 1]
     输出: 1
     解释: 第三大的数是 1.
     示例 2:
     输入: [1, 2]
     输出: 2
     解释: 第三大的数不存在, 所以返回最大的数 2 .
     示例 3:
     输入: [2, 2, 3, 1]
     输出: 1
     解释: 注意，要求返回第三大的数，是指第三大且唯一出现的数。
     存在两个值为2的数，它们都排第二。
 */
public class ThirdMax {

    public static void main(String[] args) {
        System.out.println(thirdMaxV2(new int[]{1, 2}));
    }

    public static int thirdMaxV2(int[] nums) {
        long one = Long.MIN_VALUE, two = Long.MIN_VALUE, three = Long.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == one || nums[i] == two || nums[i] == three) continue;
            if (nums[i] > one){
                three = two;
                two = one;
                one = nums[i];
            }else if (nums[i] > two){
                three = two;
                two = nums[i];
            }else if (nums[i] > three){
                three = nums[i];
            }
        }
        return (int) (three == Long.MIN_VALUE ? one : three);
    }

    public static int thirdMax(int[] nums) {
        Arrays.sort(nums);
        List<Integer> l = new ArrayList<>();
        for (int i = nums.length-1; i >= 0; i--) {
            if (!l.contains(nums[i])) l.add(nums[i]);
            if (l.size() == 3) return l.get(l.size()-1);
        }
        return l.get(0);
    }
}
