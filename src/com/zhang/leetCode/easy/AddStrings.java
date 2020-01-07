package com.zhang.leetCode.easy;

import java.util.Arrays;

/**
     给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
     注意：
     num1 和num2 的长度都小于 5100.
     num1 和num2 都只包含数字 0-9.
     num1 和num2 都不包含任何前导零。
     你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
 */
public class AddStrings {

    public static void main(String[] args) {
        System.out.println(addStrings("5555","2222"));
    }

    public static String addStrings(String num1, String num2) {
        char[] cNum1 = num1.toCharArray();
        char[] cNum2 = num2.toCharArray();
        int l1 = cNum1.length-1,l2 = cNum2.length-1;
        char[] res = new char[l1 > l2 ? l1+2 : l2+2];
        Arrays.fill(res,'0');
        int i = res.length-1;
        boolean flag = false;
        while (l1 >= 0 && l2 >= 0){
            if (flag) {
                res[i] = '1';
                flag = false;
            }
            int n = (cNum1[l1--]-'0')+(cNum2[l2--]-'0')+(res[i]-'0');
            if (n >= 10){
                flag = true;
                n-=10;
            }
            res[i--] = (char) (n+'0');
        }
        int l = Math.max(l1,l2);
        char[] cloneNum = l1 > l2 ? cNum1 : cNum2;
        while (l >= 0){
            if (flag){
                res[i] = '1';
                flag = false;
            }
            int n = (cloneNum[l--] - '0') + (res[i] - '0');
            if (n >= 10){
                flag = true;
                n -= 10;
            }
            res[i--] = (char)(n+'0');
        }
        if (flag) res[i] = '1';
        String result = new String(res);
        return res[0] == '0' ? result.substring(1) : result;
    }
}
