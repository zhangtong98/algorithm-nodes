package com.zhang.leetCode.easy;

import java.util.HashMap;
import java.util.Map;

/**
     *罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
     字符          数值
     I             1
     V             5
     X             10
     L             50
     C             100
     D             500
     M             1000
     例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
     通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，
        所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
         I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
         X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
         C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
     给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内
 */
public class RomanToInt {

    public static void main(String[] args) {
        String s = "CMLXIV";
        System.out.println(remanToIntV2(s));
    }
    public static int remanToIntV3(String s){
        char[] chars = s.toCharArray();
        int res = 0;
        for (int i = 0, len = chars.length; i < len; i++) {
            switch (chars[i]){
                case 'M':
                    res+=1000;
                    break;
                case 'D':
                    res+=500;
                    break;
                case 'C':
                    if (i < len-1){
                        if (chars[i+1] == 'M'){
                            res+=900;
                            i++;
                            break;
                        }else if(chars[i+1] == 'D'){
                            res+=400;
                            i++;
                            break;
                        }
                    }
                    res+=100;
                    break;
                case 'L':
                    res+=50;
                    break;
                case 'X':
                    if (i < len-1){
                        if (chars[i+1] == 'C'){
                            res+=90;
                            i++;
                            break;
                        }else if (chars[i+1] == 'L'){
                            res+=40;
                            i++;
                            break;
                        }
                    }
                    res+=10;
                    break;
                case 'V':
                    res+=5;
                    break;
                default:
                    if (i < len-1){
                        if (chars[i+1] == 'X'){
                            res+=9;
                            i++;
                            break;
                        }else if (chars[i+1] == 'V'){
                            res+=4;
                            i++;
                            break;
                        }
                    }
                    res+=1;
                    break;
            }
        }
        return res;
    }


    //
    public static int remanToIntV2(String s){
        int count=0;
        for(int i=0;i<s.length();i++){
            switch(s.charAt(i)){
                case 'I': count+=1; break;
                case 'V': count+=5; break;
                case 'X': count+=10; break;
                case 'L': count+=50; break;
                case 'C': count+=100; break;
                case 'D': count+=500; break;
                case 'M': count+=1000; break;
            }
        }
        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i)=='I'&&s.charAt(i+1)=='V'||s.charAt(i)=='I'&&s.charAt(i+1)=='X'){
                count-=2;
            }
            if(s.charAt(i)=='X'&&s.charAt(i+1)=='L'||s.charAt(i)=='X'&&s.charAt(i+1)=='C'){
                count-=20;
            }
            if(s.charAt(i)=='C'&&s.charAt(i+1)=='D'||s.charAt(i)=='C'&&s.charAt(i+1)=='M'){
                count-=200;
            }
        }
        return count;
    }

    public static int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>(){
            {
                put('I', 1);
                put('V', 5);
                put('X', 10);
                put('L', 50);
                put('C', 100);
                put('D', 500);
                put('M', 1000);
            }
        };

        int result = 0;
        for (int i = 0; i < s.length(); i++)
            result += (i == s.length()-1 || map.get(s.charAt(i)) >= map.get(s.charAt(i + 1)))
                    ? map.get(s.charAt(i)) : -map.get(s.charAt(i));

        return result;
    }
}
