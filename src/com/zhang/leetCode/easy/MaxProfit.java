package com.zhang.leetCode.easy;

/**
     给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
     注意你不能在买入股票前卖出股票。
     示例 1:
     输入: [7,1,5,3,6,4]
     输出: 5
     解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
     示例 2:
     输入: [7,6,4,3,1]
     输出: 0
     解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 */
public class MaxProfit {

    public static void main(String[] args) {
        int arr[] = {1,2};
        System.out.println(maxProfitV2(arr));
    }

    public static int maxProfitV2(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxPrice = 0;
        for (int i = 0; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            maxPrice = Math.max(prices[i] - minPrice,maxPrice);
//            if (minPrice > prices[i]) minPrice = prices[i];
//            else if (prices[i] - minPrice > maxPrice) maxPrice = prices[i] - minPrice;
        }
        return maxPrice;
    }

    public static int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;

        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i+1; j < prices.length; j++) {
                int _max = prices[j] - prices[i];
                max = Math.max(max,_max);
            }
        }
        return max;
    }
}
