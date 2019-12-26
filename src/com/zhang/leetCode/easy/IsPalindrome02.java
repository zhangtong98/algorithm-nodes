package com.zhang.leetCode.easy;

/**
     给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
     说明：本题中，我们将空字符串定义为有效的回文串。
     示例 1:
     输入: "A man, a plan, a canal: Panama"
     输出: true
     示例 2:
     输入: "race a car"
     输出: false
 */
public class IsPalindrome02 {

    public static void main(String[] args) {
        String str = "A man, a plan, a canal: Panama";
        System.out.println(isPalindromeV2(str));
    }

    public static boolean isPalindromeV2(String s) {
        if (s.length() < 1) return true;
        char cs[] = s.toCharArray();
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            if ((cs[i] >= '0' && cs[i] <= '9') || (cs[i] >= 'a' && cs[i] <= 'z')) cs[index++] = cs[i];
            if (cs[i] >= 'A' && cs[i] <= 'Z') cs[index++] = (char)(cs[i]+32);
        }
        int l = 0, r = index - 1;
        while (l < r){
            if (cs[l++] != cs[r--]) return false;
        }
        return true;
    }

    public static boolean isPalindrome(String s) {
        s = s.trim();
        if (s.length() < 1) return true;
        s = s.toUpperCase();
        int left = 0, right = s.length()-1;
        while (left < right){
            char l = s.charAt(left), r = s.charAt(right);
            if (!Character.isLetterOrDigit(l)){
                left++;
                continue;
            }
            if (!Character.isLetterOrDigit(r)){
                right--;
                continue;
            }
            if (r != l) return false;
            left++;
            right--;
        }
        return true;
    }
}
