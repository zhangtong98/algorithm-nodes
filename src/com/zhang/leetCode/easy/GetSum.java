package com.zhang.leetCode.easy;

/**
     不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。
     示例 1:
     输入: a = 1, b = 2
     输出: 3
     示例 2:
     输入: a = -2, b = 3
     输出: 1
 */
public class GetSum {

    public static void main(String[] args) {
        System.out.println(getSum(-2,3));
    }

    public static int getSum(int a, int b) {
        while (b != 0){
            int temp = a ^ b;
            b = (a & b) << 1;
            a = temp;
        }
        return a;
    }
}
