package com.zhang.other;

import java.util.LinkedList;
import java.util.Queue;

/**
 分解质因数
 求区间[a,b]中所有整数的质因数分解
 */
public class BreakDownPrimeFactor {
    public static void main(String[] args) {
        breakDownPrimeFactor(2,18);
    }
    public static void breakDownPrimeFactor(int a, int b){
        if (b < a)return;

        for (int i = a; i <= b; i++) {
            if (i < 2) System.out.println(i+"="+i);
            int p = isPrimeNumber(i);
            if (p == i) {
                System.out.println(i+"="+i);
            }else {
                Queue<Integer> q = new LinkedList<Integer>();
                q.offer(p);
                int childP = i/p;
                int flag = childP;
                while (flag != (childP = isPrimeNumber(childP))){
                    q.offer(childP);
                    flag = flag/childP;
                    childP = flag;
                }
                q.offer(childP);
                StringBuilder s = new StringBuilder(i+"=");
                while (q.size()>0){
                    s.append(q.poll()).append("*");
                }
                s.deleteCharAt(s.length()-1);
                System.out.println(s);
            }
        }
    }
    private static int isPrimeNumber(int num){
        if (num < 2) return 0;
        for (int i = 2; i <= num/2; i++) {
            if (num%i == 0) return i;
        }
        return num;
    }
}
