package com.zhang.leetCode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 在杨辉三角中，每个数是它左上方和右上方的数的和。
 示例:
 输入: 3
 输出: [1,3,3,1]
 进阶：
 你可以优化你的算法到 O(k) 空间复杂度吗？
 */
public class GetRow {

    public static void main(String[] args) {
        List<Integer> l = getRowV3(4);
        for (int i = 0; i < l.size(); i++) {
            System.out.println(l.get(i));
        }
    }
    public static List<Integer> getRowV3(int rowIndex) {
        List<Integer> res = new ArrayList<Integer>(rowIndex+1);
        long num = 1;
        for (int i = 0; i <= (rowIndex+1)/2; i++) {
            res.add((int)num);
            num = num * (rowIndex - i)/(i + 1);
        }
        List<Integer> _res = new ArrayList<>(res);
        Collections.reverse(res);
        _res.addAll(res);
        _res.remove((rowIndex+1)/2);
        if (rowIndex%2!=0){
            _res.remove((rowIndex+1)/2);
        }
        return _res;
    }

    public static List<Integer> getRowV2(int rowIndex) {
        Integer[] childList = null;
        for (int i = 0; i <= rowIndex; i++) {
            Integer[] nums = new Integer[i+1];
            nums[0] = 1;nums[i] = 1;
            for (int j = 1; j < i; j++) {
                nums[j] = childList[j-1] + childList[j];
            }
            childList = nums;
        }
        return Arrays.asList(childList);
    }

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<Integer>(rowIndex+1);
        long num = 1;
        for (int i = 0; i <= rowIndex; i++) {
            res.add((int)num);
            num = num * (rowIndex - i)/(i + 1);
        }
        return res;
    }
}
