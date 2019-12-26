package com.zhang.leetCode.easy;

import java.util.ArrayList;
import java.util.List;

/**
     编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
     示例 1:
     输入: "hello"
     输出: "holle"
     示例 2:
     输入: "leetcode"
     输出: "leotcede"
     说明:
     元音字母不包含字母"y"。
        a[ei]、e[i:]、i[ ai]、o[eu]、u[ju:]
 */
public class ReverseVowels {

    public static void main(String[] args) {
        System.out.println(reverseVowelsV2("a."));
    }

    public static String reverseVowelsV2(String s) {
        char[] cs = s.toCharArray();
        int left = 0, right = cs.length-1;
        while (left < right){
            while (left < right && !isVowels(cs[left])) left++;
            while (left < right && !isVowels(cs[right])) right--;

            char temp;
            temp = cs[left];
            cs[left] = cs[right];
            cs[right] = temp;
            left++;
            right--;
        }
        return new String(cs);
    }
    private static boolean isVowels(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
                || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }

    public static String reverseVowels(String s) {
        int len = s.length();
        if (len < 2) return s;
        char cs[] = s.toCharArray();
        int left = 0, right = len - 1;
        List<Character> list = new ArrayList<Character>(){{
            add('a');
            add('e');
            add('i');
            add('o');
            add('u');
            add('A');
            add('E');
            add('I');
            add('O');
            add('U');
        }};
        while (left < right){
            if (!list.contains(cs[left])){
                left++;
                continue;
            }
            if (!list.contains(cs[right])){
                right--;
                continue;
            }
            if (list.contains(cs[left]) && list.contains(cs[right])){
                cs[left] = (char)(cs[left] ^ cs[right]);
                cs[right] = (char)(cs[left] ^ cs[right]);
                cs[left] = (char)(cs[left] ^ cs[right]);
                left++;
                right--;
            }
        }
        return new String(cs);
    }
}
