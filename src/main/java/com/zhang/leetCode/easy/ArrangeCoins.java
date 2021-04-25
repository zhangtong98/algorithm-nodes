package com.zhang.leetCode.easy;

import java.util.Map;

/**
     你总共有 n 枚硬币，你需要将它们摆成一个阶梯形状，第 k 行就必须正好有 k 枚硬币。
     给定一个数字 n，找出可形成完整阶梯行的总行数。
     n 是一个非负整数，并且在32位有符号整型的范围内。
     示例 1:
     n = 5
     硬币可排列成以下几行:
     ¤
     ¤ ¤
     ¤ ¤
     因为第三行不完整，所以返回2.
     示例 2:
     n = 8
     硬币可排列成以下几行:
     ¤
     ¤ ¤
     ¤ ¤ ¤
     ¤ ¤
     因为第四行不完整，所以返回3.
 */
public class ArrangeCoins {

    public static void main(String[] args) {
        System.out.println(arrangeCoinsV3(2147483647));
    }

    public static int arrangeCoinsV3(int n) {
        return (int)(Math.sqrt(2)*Math.sqrt(n+0.125)-0.5);
    }

    public static int arrangeCoinsV2(int n) {
        int i = 1;
        while (n >= i){
            n-=i;
            i++;
        }
        return i-1;
    }

    public static int arrangeCoins(int n) {
        if (n == 0) return 0;
        long sum = 0;
        int row = 0;
        while (sum <= n){
            sum += row;
            row++;
        }
        if (row != n-sum) row--;
        return row-1;
    }
}
