package com.zhang.leetCode.easy;

/**
     实现 strStr() 函数。
     给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
     示例 1:
     输入: haystack = "hello", needle = "ll"
     输出: 2
     示例 2:
     输入: haystack = "aaaaa", needle = "bba"
     输出: -1
     说明:
     当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
     对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 */
public class StrStr {

    public static void main(String[] args) {
        String haystack = "mississippi";
        String needle = "issipi";
        System.out.println(strStrV3(haystack, needle));
    }

    public static int strStrV3(String haystack, String needle) {
        int needL = needle.length();
        int hayL = haystack.length();

        if (needL == 0) return 0;
        if (hayL == 0 || needL > hayL) return -1;

        int[] arr = new int[hayL - needL];
        int j = 0;
        for (int i = 0; i < hayL - needL + 1; i++) {
            if (haystack.charAt(i) == needle.charAt(0)
                    && haystack.charAt(i+needL-1) == needle.charAt(needL-1)) arr[j++] = i;
        }
        if (j == 0) return -1;

        for (int i = 0; i < j; i++) {
            int k;
            for (k = 0; k < needL; k++) {
                if (haystack.charAt(arr[i]+k) != needle.charAt(k)) break;
            }
            if (k == needL) return arr[i];
        }
        return -1;
    }

    public static int strStrV2(String haystack, String needle) {
        return haystack.indexOf(needle);
    }


    public static int strStr(String haystack, String needle) {
        if (needle == null || "".equals(needle)) return 0;
        if (haystack == null || "".equals(haystack) || needle.length() > haystack.length()) return -1;

        int i = 0, j=0;
        while (i < haystack.length() && j < needle.length()){
            if (haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
            }else {
                i = i - j + 1;
                j = 0;
            }
        }
        return j == needle.length() ? i - j : -1;
    }
}
