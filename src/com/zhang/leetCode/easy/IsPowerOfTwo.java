package com.zhang.leetCode.easy;

/**
     给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
     示例 1:
     输入: 1
     输出: true
     解释: 2^0 = 1
     示例 2:
     输入: 16
     输出: true
     解释: 2^4 = 16
     示例 3:
     输入: 218
     输出: false
 */
public class IsPowerOfTwo {

    public static void main(String[] args) {
        System.out.println(isPowerOfTwoV3(1));
    }

    public static boolean isPowerOfTwoV3(int n) {
        if (n <= 0) return false;
        return (n & (n-1)) == 0 ? true : false;
    }
    public static boolean isPowerOfTwoV2(int n) {
        if (n < 1) return false;
        return n + n-1 == (n ^ (n-1)) ? true : false;
    }

    public static boolean isPowerOfTwo(int n) {
        if (n < 1 || n % 2 != 0 && n != 1) return false;

        String s = Integer.toBinaryString(n);
        return !s.substring(s.indexOf('1')+1).contains("1");
    }
}
