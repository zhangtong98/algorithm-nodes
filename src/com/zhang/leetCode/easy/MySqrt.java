package com.zhang.leetCode.easy;

/**
     实现 int sqrt(int x) 函数。
     计算并返回 x 的平方根，其中 x 是非负整数。
     由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
     示例 1:
     输入: 4
     输出: 2
     示例 2:
     输入: 8
     输出: 2
     说明: 8 的平方根是 2.82842...,
          由于返回类型是整数，小数部分将被舍去。
 */
public class MySqrt {

    public static void main(String[] args) {
        System.out.println(mySqrt(3));
    }

    public static int mySqrtV2(int x) {
        if (x < 0) return -1;
        if (x == 0 || x == 1) return x;

        long left = 0;
        long right = x/2;
        while (left <= right){
            long mid = (left + right) >>> 1;
            if (mid*mid == x) return (int) mid;
            else if (mid*mid < x) left = mid+1;
            else right = mid-1;
        }
        return (int)(left - 1);
    }

    public static int mySqrt(int x) {
        if (x < 0) return -1;
        if (x == 0 || x == 1) return x;

        long res = 0;
        while (res<x/2){
            if (res*res <= x && (res+1)*(res+1) > x) break;
            res++;
        }
        return (int)res;
    }
}
