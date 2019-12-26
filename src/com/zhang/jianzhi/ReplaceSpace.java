package com.zhang.jianzhi;

/**
 * Created by kongweichun on 2019/11/4.
 *  替换空格
 *      将一个字符串中的空格替换成 "%20"。
 Input:
 "A B"
 Output:
 "A%20B"
 解题思路
 ① 在字符串尾部填充任意字符，使得字符串的长度等于替换之后的长度。因为一个空格要替换成三个字符（%20），
 所以当遍历到一个空格时，需要在尾部填充两个任意字符。
 ② 令 P1 指向字符串原来的末尾位置，P2 指向字符串现在的末尾位置。P1 和 P2 从后向前遍历，当 P1 遍历到一个空格时，
 就需要令 P2 指向的位置依次填充 02%（注意是逆序的），否则就填充上 P1 指向字符的值。从后向前遍是为了在改变
 P2 所指向的内容时，不会影响到 P1 遍历原来字符串的内容。
 ③ 当 P2 遇到 P1 时（P2 <= P1），或者遍历结束（P1 < 0），退出。
 */
public class ReplaceSpace {
    public static void main(String[] args) {
        String str = "A B C D";
        System.err.println(replaceSpace(str));
    }

    public static String replaceSpace(String str){
        //String类中的API
        //return str.replaceAll("\\s" ,"%20");

        //不使用API
        StringBuilder sb = new StringBuilder(str);
        //没出现一个空格就在末尾添加两个空位
        for (int i = 0; i < str.length(); i++) {
            if (' ' == str.charAt(i)) {
                sb.append("  ");
            }
        }

        //从初始字符串末尾向前遍历
        int strLength = str.length() - 1;
        //改变后的字符串长度
        int sbLength = sb.length() - 1;
        //strLength >= 0：遍历完成
        //sbLength > strLength：当sbLength和strLength相等时，说明前面没有空格符，结束
        while (strLength >= 0 && sbLength > strLength){
            //获取当前的字符 然后指针自减
            char c = sb.charAt(strLength--);
            if (' ' == c){
                //从sbLength开始填充%20并自减
                sb.setCharAt(sbLength--, '0');
                sb.setCharAt(sbLength--, '2');
                sb.setCharAt(sbLength--, '%');
            }else {
                //填充当前字符并自减
                sb.setCharAt(sbLength--, c);
            }
        }
        return sb.toString();
    }
}
