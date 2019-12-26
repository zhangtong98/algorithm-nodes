package com.zhang.leetCode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
     给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
     在杨辉三角中，每个数是它左上方和右上方的数的和。
     示例:
     输入: 5
     输出:
     [
         [1],
        [1,1],
       [1,2,1],
      [1,3,3,1],
     [1,4,6,4,1]
     ]
 */
public class Generate {


    public static void main(String[] args) {
        List<List<Integer>> l =generateV2(5);
        for (int i = 0; i < l.size(); i++) {
            for (int j = 0; j < l.get(i).size(); j++) {
                System.out.print(l.get(i).get(j));
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> generateV2(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Integer[] childList = null;
        for (int i = 0; i < numRows; i++) {
            Integer[] nums = new Integer[i+1];
            nums[0] = 1; nums[i] = 1;
            for (int j = 1; j < i; j++) {
                nums[j] = childList[j-1]+childList[j];
            }
            childList = nums;
            res.add(Arrays.asList(nums));
        }
        return res;
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> l = new ArrayList<Integer>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i){
                    l.add(1);
                    continue;
                }
                l.add(res.get(i-1).get(j-1)+res.get(i-1).get(j));
            }
            res.add(l);
        }
        return res;
    }


}
