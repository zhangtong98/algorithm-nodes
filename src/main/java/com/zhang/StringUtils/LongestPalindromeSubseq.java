package com.zhang.StringUtils;

/**
 * Created by kongweichun on 2021/4/6.
 * chongqing liangyao
 * 动态规划：状态的定义“dp[i][i]=1”和状态转移方程
 *
 * dp[i][j]表示字符串str从第i到第j最长状态回文字符序列的长度
 *
 * 参考：https://zhuanlan.zhihu.com/p/265530621
 */
public class LongestPalindromeSubseq {
    public static void main(String[] args) {
        System.out.println(longestPalindromeSubseq("bbbab"));
    }
    public static int longestPalindromeSubseq(String str){
        int len = str.length();
        int[][] dp = new int[len][len];
        for (int i = len-1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i+1; j < len; j++) {
                if (str.charAt(i) == str.charAt(j)){
                    dp[i][j] = dp[i+1][j-1] + 2;
                }else {
                    dp[i][j] = Math.max(dp[i][j-1],dp[i+1][j]);
                }
            }
        }
        return dp[0][len-1];
    }
}
