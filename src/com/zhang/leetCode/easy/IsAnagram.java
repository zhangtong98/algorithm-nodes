package com.zhang.leetCode.easy;

import java.util.Arrays;

/**
     给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     示例 1:
     输入: s = "anagram", t = "nagaram"
     输出: true
     示例 2:
     输入: s = "rat", t = "car"
     输出: false
     说明:
     你可以假设字符串只包含小写字母。
     进阶:
     如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 */
public class IsAnagram {

    public static void main(String[] args) {
        System.out.println(isAnagramV2_3("anagram","nagaram"));
    }

    public static boolean isAnagramV2_3(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] nums = new int[26];
        for (int i = 0; i < s.length(); i++) {
            nums[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            nums[t.charAt(i) - 'a']--;
            if (nums[t.charAt(i) - 'a'] < 0) return false;

        }
        return true;
    }

    public static boolean isAnagramV2_2(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] nums = new int[26];
        for (int i = 0; i < s.length(); i++) {
            nums[s.charAt(i) - 'a']++;
            nums[t.charAt(i) - 'a']--;
        }
        for (int num : nums) {
            if (num != 0) return false;
        }
        return true;
    }

    public static boolean isAnagramV2(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] nums = new int[256];
        char sc[] = s.toCharArray();
        for (char c : sc) {
            nums[c]++;
        }
        char tc[] = t.toCharArray();
        for (char c : tc) {
            nums[c]--;
        }
        for (int num : nums) {
            if (num != 0) return false;
        }
        return true;
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        char sc[] = s.toCharArray();
        char tc[] = t.toCharArray();
        Arrays.sort(sc);
        Arrays.sort(tc);
//        for (int i = 0; i < sc.length; i++) {
//            if (sc[i] != tc[i]) return false;
//        }
//        return true;
        return Arrays.equals(sc,tc);
    }
}
