package com.zhang.leetCode.easy;

/**
     给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
     在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
     注意:
     假设字符串的长度不会超过 1010。
     示例 1:
     输入:
     "abccccdd"
     输出:
     7
     解释:
     我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        System.out.println(longestPalindromeV2("abcfrtcccdd"));
    }

    public static int longestPalindromeV2(String s) {
        int[] cCut = new int[128];
        for (char c : s.toCharArray()) {
            cCut[c]++;
        }
        int res = 0;
        for(int n : cCut){
            res += n / 2 * 2;
            if (n%2 != 0 && res % 2 == 0) res++;
        }
        return res;
    }

    public static int longestPalindrome(String s) {
        int[] cCut = new int[128];
        int res = 0;
        for (char c : s.toCharArray()) {
            cCut[c]++;
            if (cCut[c]%2 == 0){
                res += cCut[c];
                cCut[c] = 0;
            }
        }
        if (res < s.length()) res++;
        return res;
    }
}
