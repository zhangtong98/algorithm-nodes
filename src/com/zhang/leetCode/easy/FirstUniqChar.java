package com.zhang.leetCode.easy;

/**
     给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
     案例:
     s = "leetcode"
     返回 0.
     s = "loveleetcode",
     返回 2.
     注意事项：您可以假定该字符串只包含小写字母。
 */
public class FirstUniqChar {

    public static void main(String[] args) {
        System.out.println(firstUniqChar("aassxxss"));
    }

    public static int firstUniqChar(String s) {
        int charCount[] = new int[26];
        for (int i = 0; i < s.length(); i++) {
            charCount[s.charAt(i) - 'a']++;
        }
        int res = s.length();
        for (int i = 0; i < 26; i++) {
            if (charCount[i] == 1){
                res = Math.min(s.indexOf((char)(i+'a')),res);
            }
        }
        return res == s.length() ? -1 : res;
    }
}
