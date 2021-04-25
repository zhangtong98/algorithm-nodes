package com.zhang.leetCode.easy;

/**
     给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
     说明：不要使用任何内置的库函数，如  sqrt。
     示例 1：
     输入：16
     输出：True
     示例 2：
     输入：14
     输出：False
 */
public class IsPerfectSquare {

    public static void main(String[] args) {
        System.out.println(isPerfectSquareV3(16));
    }

    public static boolean isPerfectSquareV3(int num) {
        if (num < 2) return true;
        long left = 2, right = num/2, x, guessSquared;
        while (left <= right){
            x = left + (right - left)/2;
            guessSquared = x*x;
            if (guessSquared == num) return true;
            else if (guessSquared < num) left = x+1;
            else right = x - 1;
        }
        return false;
    }

    public static boolean isPerfectSquareV2(int num) {
        if (num < 2) return true;
        long x = num/2;
        while (x*x > num){
            x = (x + num/x)/2;
        }
        return x*x == num;
    }

    public static boolean isPerfectSquare(int num) {
        int res = 0;
        for (int i = 1; i <= num/i; i++) {
            res = num % i == 0 ? i : res;
        }
        return res*res == num;
    }
}
