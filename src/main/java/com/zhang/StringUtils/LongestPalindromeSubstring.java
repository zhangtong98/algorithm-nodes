package com.zhang.stringUtils;

/**
 * Created by kongweichun on 2021/4/6.
 * chongqing liangyao
 */
public class LongestPalindromeSubstring {

    public static void main(String[] args) {
        LongestPalindromeSubstring lp = new LongestPalindromeSubstring();
        System.out.println(lp.longestPalindrome("zxdmxbiuoouiasdf"));
    }

    public int index, len;

    public String longestPalindrome(String str){
        for (int i = 0; i < str.length(); i++) {
            palindromeHelper(str,i,i);
            palindromeHelper(str,i,i+1);
        }
        return str.substring(index,index+len);
    }

    public void palindromeHelper(String str,int p,int n){
        while (p >= 0 && n < str.length()-1 && str.charAt(p)==str.charAt(n)){
            p--;
            n++;
        }
        if (len < n - p - 1){
            index = p + 1;
            len = n - p - 1;
        }
    }
}

