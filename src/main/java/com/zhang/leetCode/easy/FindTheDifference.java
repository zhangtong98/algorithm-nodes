package com.zhang.leetCode.easy;

/**
     给定两个字符串 s 和 t，它们只包含小写字母。
     字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
     请找出在 t 中被添加的字母。
     示例:
     输入：
     s = "abcd"
     t = "abcde"
     输出：
     e
     解释：
     'e' 是那个被添加的字母。
 */
public class FindTheDifference {

    public static void main(String[] args) {
        System.out.println(findTheDifferenceV2("abcd","asbcd"));
    }

    public static char findTheDifferenceV2(String s, String t) {
        String st = s + t;
        char[] cst = st.toCharArray();
        int res = 0;
        for (char c : cst) {
            res ^= c;
        }
        return (char) res;
    }

    public static char findTheDifference(String s, String t) {
        int charCounts[] = new int[26];
        int i = 0,j = 0;
        while (i < s.length() || j < t.length()){
            if (i < s.length()) charCounts[s.charAt(i++) - 'a']--;
            if (j < t.length()) charCounts[t.charAt(j++) - 'a']++;
        }
        char res = t.charAt(0);
        for (int k = 0; k < 26; k++) {
            if (charCounts[k] == 1) return res = (char) (k + 'a');
        }
        return res;
    }
}
