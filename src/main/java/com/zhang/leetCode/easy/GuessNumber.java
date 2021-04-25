package com.zhang.leetCode.easy;

/**
     我们正在玩一个猜数字游戏。 游戏规则如下：
     我从 1 到 n 选择一个数字。 你需要猜我选择了哪个数字。
     每次你猜错了，我会告诉你这个数字是大了还是小了。
     你调用一个预先定义好的接口 guess(int num)，它会返回 3 个可能的结果（-1，1 或 0）：
     -1 : 我的数字比较小
     1 : 我的数字比较大
     0 : 恭喜！你猜对了！
     示例 :
     输入: n = 10, pick = 6
     输出: 6
 */
public class GuessNumber extends GuessGame  {

    public static void main(String[] args) {
        System.out.println(guessNumber(4));
    }


    public static int guessNumber(int n) {
        int l = 0, r = n;
        while (l < r){
            int mid = l + (r - l)/2;
            if (guess(mid) == -1) l = mid+1;
            else if (guess(mid) == 1) r = mid -1;
            return mid;
        }
        return -1;
    }
}

class GuessGame{

    /* The guess API is defined in the parent class GuessGame.
       @param num, your guess
       @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
          int guess(int num); */
    public static int guess(int num){
        int n=2;
        if (n < num) return 1;
        else if (n > num) return -1;
        else return 0;
    }
}