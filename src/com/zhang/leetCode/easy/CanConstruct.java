package com.zhang.leetCode.easy;


/**
     给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串ransom能不能由第二个字符串magazines里面的字符构成。如果可以构成，返回 true ；否则返回 false。
     (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。)
     注意：
     你可以假设两个字符串均只含有小写字母。
     canConstruct("a", "b") -> false
     canConstruct("aa", "ab") -> false
     canConstruct("aa", "aab") -> true
 "fffbfg"
 "effjfggbffjdgbjjhhdegh"
 */
public class CanConstruct {

    public static void main(String[] args) {
        System.out.println(canConstructV2("fffbfg","effjfggbffjdgbjjhhdegh"));
    }

    public static boolean canConstructV2(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;
        //记录最后一个相同字母出现的位置
        int caps[] = new int[26];
        for (char c : ransomNote.toCharArray()){
            //当前字母在magazine中出现的位置（从上一次出现位置后一个开始检索）
            int index = magazine.indexOf(c, caps[c-'a']);
            //c不再magazine中出现
            if (index == -1) return false;
            //当前字母的位置加1，表示如果下一次遇到这个字母时，就从magazine的下一个位置检索
            caps[c - 'a'] = index + 1;
        }
        return true;
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        int ranLen = ransomNote.length(),magLen = magazine.length();
        if (ranLen > magLen) return false;
        int charCount[] = new int[256];
        for (int i = 0; i < ranLen; i++) {
            charCount[ransomNote.charAt(i)]++;
        }
        for (int i = 0; i < magLen; i++) {
            charCount[magazine.charAt(i)]--;
        }
        for(int n : charCount){
            if (n > 0) return false;
        }
        return true;
    }
}
