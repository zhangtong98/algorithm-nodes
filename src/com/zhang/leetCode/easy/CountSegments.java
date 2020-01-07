package com.zhang.leetCode.easy;

/**
 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
 请注意，你可以假定字符串里不包括任何不可打印的字符。
 示例:
 输入: "Hello, my name is John"
 输出: 5
 */
public class CountSegments {

    public static void main(String[] args) {
        System.out.println(countSegmentsV2(", , , ,        a, eaefa"));
    }

    public static int countSegmentsV2(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if ((i == 0 || s.charAt(i-1) == ' ') && s.charAt(i) != ' ') res++;
        }
        return res;
    }

    public static int countSegments(String s) {
        if (s.trim().length() == 0) return 0;
        String arr[] = s.split("\\s");
        int res = 0;
        for (String str : arr){
            if (str.trim().length() > 0) res++;
        }
        return res;
    }
}
