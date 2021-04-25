package com.zhang.leetCode.easy;

import java.util.HashMap;
import java.util.Map;

/**
     给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
     你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     示例 1:
     输入: [3,2,3]
     输出: 3
     示例 2:
     输入: [2,2,1,1,1,2,2]
     输出: 2
 */
public class MajorityElement {
    public static void main(String[] args) {
        int a[] = {2,2,1,1,1,2,2};
        System.out.println(majorityElementV2(a));
    }

    public static int majorityElementV2(int[] nums) {
        int num = nums[0], count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == num){
                count++;
            }else {
                count--;
                if (count == 0){
                    num = nums[i];
                    count++;
                }
            }
        }
        return num;
    }

    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> m = new HashMap<>();
        int[] _nums = new int[nums.length/2+1];
        int l = 0;
        for (int i = 0; i < nums.length; i++) {
            if (m.containsKey(nums[i])) {
                m.put(nums[i], m.get(nums[i]) + 1);
            }else {
                m.put(nums[i],0);
                _nums[l++] = nums[i];
            }
        }
        int res = _nums[0];
        for (int i = 1; i < _nums.length; i++) {
            if (m.get(_nums[i]) != null && m.get(_nums[i-1]) != null && m.get(_nums[i]) > m.get(res)){
                res = _nums[i];
            }
        }
        return res;
    }

}
