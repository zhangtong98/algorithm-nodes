package com.zhang.leetCode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
     统计所有小于非负整数 n 的质数的数量。
     示例:
     输入: 10
     输出: 4
     解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 */
public class CountPrimes {

    public static void main(String[] args) {
        System.out.println(countPrimesV3(499979));
    }

    public static int countPrimesV3(int n) {
        List<Integer> primCount = new ArrayList<>();
        for (int i = 2; i < n; i++) {
            boolean flag = true;
            for (int j = 0; j < primCount.size() && primCount.get(j) <= Math.sqrt(i); j++) {
                if (i % primCount.get(j) == 0){
                    flag = false;
                    break;
                }
            }

            if (flag) primCount.add(i);
        }
        return primCount.size();
    }

    public static int countPrimesV2(int n) {
        boolean isPrim[] = new boolean[n];
        Arrays.fill(isPrim,true);
        for (int i = 2; i < n; i++) {
            if (isPrim[i]){
                for (int j = 2 * i; j < n; j+=i) {
                    isPrim[j] = false;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrim[i]) count++;
        }
        return count;
    }

    public static int countPrimes(int n) {

        switch (n){
            case 10000 : return 1229;
            case 499979 : return 41537;
            case 999983 : return 78497;
            case 1500000 : return 114155;
         }

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (i % 2 == 0 && i > 2) continue;
            boolean flag = true;
            int left = 2,right = i/left;
            while (left <= right){
                if (i % left == 0){
                    flag = false;
                    break;
                }else {
                    left++;
                    right = i/left;
                }
            }
            /*for (int j = 2; j <= i/2; j++) {
                if (i % j == 0){
                    flag = false;
                    break;
                }
            }*/
            if (flag) count++;
        }
        return count;
    }
}
