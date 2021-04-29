package com.zhang.other.threeSum;

import com.zhang.numberUtils.ArrayGenerater;

import java.util.Arrays;

/**
 * Created by zhangtong on 2021/4/27.
 * chongqing liangyao
 */
public class ThreeSumDemo {
    public static void main(String[] args) {
        int len = 500;
        int loopTimes = 7;
        double preTime = -1;
        while (loopTimes-- > 0) {
            Integer[] nums = ArrayGenerater.notRepeatArrayGenerater(len);
            StopWatch.start();
            ThreeSum threeSum = new ThreeSumSlow();
            int cnt = threeSum.count(nums);
            System.out.println(cnt);
            double elapsedTime = StopWatch.elapsedTime();
            double ratio = preTime == -1 ? 0 : elapsedTime / preTime;
            System.out.println(len + "  " + elapsedTime + "  " + ratio);
            preTime = elapsedTime;
            len *= 2;
        }
    }
}
class StopWatch{
    private static long start;

    public static void start(){
        start = System.currentTimeMillis();
    }

    public static double elapsedTime() {
        long now = System.currentTimeMillis();
        return (now - start) / 1000.0;
    }
}

