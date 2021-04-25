package com.zhang.StringUtils;

import java.util.*;

/**
 * Created by kongweichun on 2021/3/31.
 * chongqing liangyao
 * 在字符串(s)中查找字符串(p)出现的位置
 */
public class KMPString {

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(next("abababca")));

        System.out.println(KMPOperate("BBCABCDABABCDABCDABDEABCDABD","A"));
    }

    /**
     * 记录字符串p在字符串s中出现的所有位置
     * @param s
     * @param p
     * @return
     */
    public static Map<Integer,Integer> KMPOperate(String s, String p){
        Map<Integer,Integer> result = new HashMap<>();
        int index = 0;
        /*
         * KMP原理：
         */
        int sIndex = 0;
        int pIndex = 0;
        int[] next = next(p);
        while (sIndex < s.length()){
            if (s.charAt(sIndex++) == p.charAt(pIndex)){
                pIndex++;
            }else {
                pIndex = next[pIndex];
            }
            if (pIndex == p.length()){
                result.put(++index,sIndex-p.length());
                pIndex = 0;
            }
        }
        return result;
    }
    public static int[] next(String p){
        if (p == null || "".equals(p)) throw new RuntimeException();
        int[] result = new int[p.length()];
        result[0] = 0;
        for (int i = 0;i < p.length();i++) {
            String partP = p.substring(0,i+1);
            List<String> prefix = new ArrayList<>();
            List<String> suffix = new ArrayList<>();
            for (int j = 0; j < partP.length()-1; j++) {
                prefix.add(partP.substring(0,j+1));
                suffix.add(partP.substring(j+1));
            }
            prefix.retainAll(suffix);
            Collections.sort(prefix, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.length() < o2.length() ? 1 : -1;
                }
            });
            if (i != p.length()-1)
            result[i+1] = prefix.isEmpty() ? 0 : prefix.get(0).length();
        }
        return result;
    }
}
