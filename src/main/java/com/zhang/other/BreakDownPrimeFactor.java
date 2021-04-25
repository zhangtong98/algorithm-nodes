package com.zhang.other;

import java.util.LinkedList;
import java.util.Queue;

/**
 分解质因数
 求区间[a,b]中所有整数的质因数分解
 */
public class BreakDownPrimeFactor {
    public static void main(String[] args) {
        breakDownPrimeFactorv2();
    }

    public static void breakDownPrimeFactorv2(){
        String s = "AF,AH,AI,AJ,AK,AB,AC,AD,AE,AG,BB,BC,BD,BE,BG,BF,BH,BI,BJ,BK,CG,CF,CH,CI,CJ,CK,CB,CC,CD,CE,DD,DE,DG,DF,DH,DI,DJ,DK,DB,DC,EJ,EK,EB,EC,ED,EE,EG,EF,EH,EI,FI,FJ,FK,FB,FC,FD,FE,FG,FF,FH,HF,HH,HI,HJ,HK,HB,HC,HD,HE,HG,IF,IH,II,IJ,IK,IB,IC,ID,IE,IG,JD,JE,JG,JF,JH,JI,JJ,JK,JB,JC,KB,KC,KD,KE,KG,KF,KH,KI,KJ,KK,LC,LD,LE,LG,LF,LH,LI,LJ,LK,LB,MG,MF,MH,MI,MJ,MK,MB,MC,MD,ME,NC,ND,NE,NG,NF,NH,NI,NJ,NK,NB,PG,PF,PH,PI,PJ,PK,PB,PC,PD,PE,QE,QG,QF,QH,QI,QJ,QK,QB,QC,QD,RI,RJ,RK,RB,RC,RD,RE,RG,RF,RH,SJ,SK,SB,SC,SD,SE,SG,SF,SH,SI,TI,TJ,TK,TB,TC,TD,TE,TG,TF,TH,UH,UI,UJ,UK,UB,UC,UD,UE,UG,UF,VH,VI,VJ,VK,VB,VC,VD,VE,VG,VF,WF,WH,WI,WJ,WK,WB,WC,WD,WE,WG,ZF,ZH,ZI,ZJ,ZK,ZB,ZC,ZD,ZE,ZG,AS,AT,AU,AV,AL,AM,AN,AP,AQ,AR,BU,BV,BL,BM,BN,BP,BQ,BR,BS,BT,CR,CS,CT,CU,CV,CL,CM,CN,CP,CQ,DL,DM,DN,DP,DQ,DR";
        String[] sl = s.split(",");
        for (int i = 0; i < sl.length; i++) {
            if (sl[i].length()!=2){
                System.err.println("===================");
            }
            System.out.println("INSERT INTO v4_item_sort_order_char(sort_char,sort_order,is_valid) VALUES ('"+sl[i]+"',"+(i+1)+",1);");
        }
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
