package com.zhang.leetCode.easy;

/**
     你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
        如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
     示例 1:
     输入: [1,2,3,1]
     输出: 4
     解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
          偷窃到的最高金额 = 1 + 3 = 4 。
     示例 2:
     输入: [2,7,1,3,9]
           [16,16,10,9,9]
     输出: 12
     解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
          偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 */
public class Rob {

    public static void main(String[] args) {
        int a[] = {2,7,1,1,9};
        System.out.println(robV3(a));
    }

    public static int robV3(int[] nums) {
        int len = nums.length;
        if (len <= 0) return len == 0 ? 0 : nums[1];
        int memo[] = new int[len];
        memo[0] = nums[0];
        memo[1] = Math.max(memo[0],nums[1]);
        for (int i = 2; i < len; i++) {
            memo[i] = Math.max(memo[i-1],memo[i-2]+nums[i]);
        }
        return memo[len-1];
    }

    public static int robV2(int[] nums) {
        int len = nums.length;
        if (len < 1) return 0;
        // memo[i] 表示考虑抢劫 nums[i...n-1] 所能获得最大收益（不是说一定从 i 开始抢劫）
        int[] memo = new int[len];
        // 先考虑最简单的情况
        memo[len-1] = nums[len-1];
        for (int i = len-2; i >= 0; i--) {
            // memo[i] 的取值在考虑抢劫 i 号房子和不考虑抢劫之间取最大值
            memo[i] = Math.max(nums[i] + (i+2>=len?0:memo[i+2]),nums[i+1] + (i+3>=len?0:memo[i+3]));
        }
        return memo[0];
    }

    /**
     * 考虑所有可能的抢劫方案过于困难。一个自然而然的想法是首先从最简单的情况开始。记：
     f(k) = 从前 k 个房屋中能抢劫到的最大数额，Ai= 第 i 个房屋的钱数。
     首先看 n = 1 的情况，显然 f(1) = A1.
     再看 n = 2，f(2) = max(A1, A2)。
     对于 n = 3，有两个选项:
     抢第三个房子，将数额与第一个房子相加。
     不抢第三个房子，保持现有最大数额。
     显然，你想选择数额更大的选项。于是，可以总结出公式：
     f(k) = max(f(k – 2) + Ak,f(k – 1))
     我们选择 f(–1) = f(0) = 0 为初始情况，这将极大地简化代码。
     答案为 f(n)。可以用一个数组来存储并计算结果。不过由于每一步你只需要前两个最大值，两个变量就足够用了。
     */
    public static int rob(int[] nums) {
        int prevMax = 0;
        int currMax = 0;
        for (int n: nums) {
            int temp = currMax;
            currMax = Math.max(prevMax+n, currMax);
            prevMax = temp;
        }
        return currMax;
    }
}
