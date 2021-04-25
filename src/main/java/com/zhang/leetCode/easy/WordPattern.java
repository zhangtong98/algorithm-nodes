package com.zhang.leetCode.easy;

import java.util.HashMap;
import java.util.Map;

/**
     给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
     这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
     示例1:
     输入: pattern = "abba", str = "dog cat cat dog"
     输出: true
     示例 2:
     输入:pattern = "abba", str = "dog cat cat fish"
     输出: false
     示例 3:
     输入: pattern = "aaaa", str = "dog cat cat dog"
     输出: false
     示例 4:
     输入: pattern = "abba", str = "dog dog dog dog"
     输出: false
     说明:
     你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。    
 */
public class WordPattern {

    public static void main(String[] args) {
        System.out.println(wordPatternV3("abba","dog cat cat fish"));
    }

    public static boolean wordPatternV3(String pattern, String str) {
        String[] strs = str.split("\\s");
        int len = pattern.length();
        if (len != strs.length) return false;
        Map<Character,String> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            char c = pattern.charAt(i);
            if (!map.containsKey(c)){
                if (map.containsValue(strs[i])) return false;
                map.put(c,strs[i]);
            }else {
                if (!map.get(c).equals(strs[i])) return false;
            }
        }
        return true;
    }

    public static boolean wordPatternV2(String pattern, String str) {
        String[] strs = str.split("\\s");
        int len = pattern.length();
        if (len != strs.length) return false;
        for (int i = 0; i < len; i++) {
            if (pattern.indexOf(pattern.charAt(i)) != indexOf(strs,strs[i])){
                return false;
            }
        }
        return true;
    }
    private static int indexOf(String[] arr, String s){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(s)){
                return i;
            }
        }
        return -1;
    }

    public static boolean wordPattern(String pattern, String str) {
        String[] strs = str.split("\\s");
        int len = pattern.length();
        if (len != strs.length) return false;
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                if ((pattern.charAt(i) != pattern.charAt(j) && strs[i].equals(strs[j]))
                        || (pattern.charAt(i) == pattern.charAt(j) && !strs[i].equals(strs[j]))){
                    return false;
                }
            }
        }
        return true;
    }
}
