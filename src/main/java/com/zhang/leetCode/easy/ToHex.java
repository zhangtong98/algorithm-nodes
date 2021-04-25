package com.zhang.leetCode.easy;

/**
     给定一个整数，编写一个算法将这个数转换为十六进制数。对于负整数，我们通常使用 补码运算 方法。
     注意:
     十六进制中所有字母(a-f)都必须是小写。
     十六进制字符串中不能包含多余的前导零。如果要转化的数为0，那么以单个字符'0'来表示；对于其他情况，十六进制字符串中的第一个字符将不会是0字符。 
     给定的数确保在32位有符号整数范围内。
     不能使用任何由库提供的将数字直接转换或格式化为十六进制的方法。
     示例 1：
     输入:
     26
     输出:
     "1a"
     示例 2：
     输入:
     -1
     输出:
     "ffffffff"
 */
public class ToHex {

    public static void main(String[] args) {
        System.out.println(toHex(26));
    }

    /*
    【笔记】核心思想，使用位运算，每4位，对应1位16进制数字。
    使用0xf(00...01111b)获取num的低4位。
    >>算数位移，其中正数右移左边补0，负数右移左边补1。
    位移运算并不能保证num==0，需要使用32位int保证（对应16进制小于等于8位）。
    使用string直接进行字符串拼接....
     */
    public static String toHex(int num) {
        String res = "";
        if (num == 0) return "0";
        String hexString = "0123456789abcdef";
        while (num != 0 && res.length() < 8){
            res = hexString.charAt(num & 0xf) + res;
            num >>= 4;
        }
        return res;
    }
}
