package com.zhang.leetCode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
     写一个程序，输出从 1 到 n 数字的字符串表示。
     1. 如果 n 是3的倍数，输出“Fizz”；
     2. 如果 n 是5的倍数，输出“Buzz”；
     3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
     示例：
     n = 15,
     返回:
     [
     "1",
     "2",
     "Fizz",
     "4",
     "Buzz",
     "Fizz",
     "7",
     "8",
     "Fizz",
     "Buzz",
     "11",
     "Fizz",
     "13",
     "14",
     "FizzBuzz"
     ]
 */
public class FizzBuzz {

    public static void main(String[] args) {
        for (String s : fizzBuzzV2(15)) {
            System.out.println(s);
        }
    }

    public static List<String> fizzBuzzV2(int n) {
        String[] arr = new String[n];
        for (int i = 1; i <= n; i++)
            arr[i-1] = i+"";
        for (int i = 3; i <= n; i+=3)
            arr[i-1] = "Fizz";
        for (int i = 5; i <= n; i+=5)
            arr[i-1] = "Buzz";
        for (int i = 15; i <= n; i+=15)
            arr[i-1] = "FizzBuzz";
        return Arrays.asList(arr);
    }

    public static List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i%3 == 0 && i%5 == 0) {
                res.add("FizzBuzz");
                continue;
            }
            if (i%3 == 0) {
                res.add("Fizz");
                continue;
            }
            if (i%5 == 0) {
                res.add("Buzz");
                continue;
            }
            res.add(i+"");
        }
        return res;
    }
}
