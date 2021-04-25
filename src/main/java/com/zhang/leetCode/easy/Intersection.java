package com.zhang.leetCode.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
     给定两个数组，编写一个函数来计算它们的交集。
     示例 1:
     输入: nums1 = [1,2,2,1], nums2 = [2,2]
     输出: [2]
     示例 2:
     输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     输出: [9,4]
     说明:
     输出结果中的每个元素一定是唯一的。
     我们可以不考虑输出结果的顺序。
 */
public class Intersection {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersectionV2(new int[]{4,9,5}, new int[]{9,4,9,8,4})));
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) return new int[]{};
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        Set<Integer> resSet = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])){
                resSet.add(nums2[i]);
            }
        }
        int[] res = new int[resSet.size()];
        Object[] obj = resSet.toArray();
        for (int i = 0; i < obj.length; i++) {
            res[i] = (int)obj[i];
        }
        return res;
    }

    public static int[] intersectionV2(int[] nums1, int[] nums2) {
        int[] res = new int[Math.min(nums1.length,nums2.length)];
        int i = 0, j = 0, cur = -1;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        while (i < nums1.length && j < nums2.length){
            if (nums1[i] > nums2[j]) j++;
            else if (nums1[i] < nums2[j]) i++;
            else {
                if (cur == -1 || res[cur] != nums1[i]) res[++cur] = nums1[i];
                i++;
                j++;
            }
        }
        return Arrays.copyOf(res,cur+1);
    }

}
