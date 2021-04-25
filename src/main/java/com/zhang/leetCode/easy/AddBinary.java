package com.zhang.leetCode.easy;

import java.util.Arrays;

/**
 给定两个二进制字符串，返回他们的和（用二进制表示）。
 输入为非空字符串且只包含数字 1 和 0。
 示例 1:
 输入: a = "11", b = "1"
 输出: "100"
 示例 2:
 输入: a = "1010", b = "1011"
 输出: "10101"
 */
public class AddBinary {
    public static void main(String[] args) {
        String a = "1010";
        String b = "11";
        System.out.println(addBinaryV2(a,b));
    }
    public static String addBinaryV2(String a, String b) {
        if (a.length() == 0) return b;
        if (b.length() == 0) return a;

        int lenA = a.length();
        int lenB = b.length();
        char[] chas = a.toCharArray();
        char[] chbs = b.toCharArray();
        int lenL = lenA > lenB ? lenA+1 : lenB+1;
        char[] res = new char[lenL];
        boolean addFlag = false;
        while (lenA > 0 || lenB > 0){
            int count = 0;
            if (lenA > 0 && chas[--lenA] == '1') count++;
            if (lenB > 0 && chbs[--lenB] == '1') count++;
            if (addFlag) {
                count++;
                addFlag = false;
            }
            res[--lenL] = (char)(count%2 + '0');
            if (count > 1) addFlag = true;
        }

        if (addFlag){
            res[0] = '1';
            return new String(res);
        }
        return new String(Arrays.copyOfRange(res, 1, res.length));
    }

    public static String addBinary(String a, String b) {
        if (a.length() == 0) return b;
        if (b.length() == 0) return a;

        StringBuilder sb = new StringBuilder();
        int i = a.length()-1;
        int j = b.length()-1;
        int c =0;
        while (i >= 0 || j >= 0){
            if (i >= 0) c += a.charAt(i--)-'0';
            if (j >= 0) c += b.charAt(j--)-'0';
            sb.append(c%2);
            c >>= 1;
        }
        String str = sb.reverse().toString();
        return c > 0 ? "1"+str : str;
    }
}
