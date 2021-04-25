package com.zhang.leetCode.easy;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
     如果不存在公共前缀，返回空字符串 ""。
     示例 1:
     输入: ["flower","flow","flight"]
     输出: "fl"
     示例 2:
     输入: ["dog","racecar","car"]
     输出: ""
     解释: 输入不存在公共前缀。
     说明:
     所有输入只包含小写字母 a-z 。
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strings = {"dog","racecar","car"};
        System.out.println(longestCommonPrefixV2(strings));
    }

    public static String longestCommonPrefixV2(String[] strs){
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];

        String shortStr = strs[0];
        for (int i = 1; i < strs.length; i++) {
            if (shortStr.length() > strs[i].length()) shortStr = strs[i];
        }

        StringBuilder result = new StringBuilder();
        boolean flag = true;
        for (int i = 0; i < shortStr.length(); i++) {
            for (int j = 0; j < strs.length; j++) {
                if (shortStr.charAt(i) != strs[j].charAt(i)) flag = false;
            }
            if (flag == true) result.append(shortStr.charAt(i));
        }
        return result.toString();
    }

    public static String longestCommonPrefix(String[] strs) {

        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];

        String result = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(result) != 0){
                result = result.substring(0, result.length()-1);
                if (result == "") return result;
            }
        }
        return result;
    }
}
