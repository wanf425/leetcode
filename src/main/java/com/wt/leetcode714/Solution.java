package com.wt.leetcode714;

/**
 * @program: leetcode
 * @description:
 * @author: wang tao
 * @create: 2020-01-25 22:39
 */
public class Solution {

    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        if (n <= 0) {
            return 0;
        }

        int[][] dp = new int[n][2];

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                dp[0][0] = 0;
                dp[0][1] = -prices[0];
                continue;
            }

            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }

        return dp[n - 1][0];
    }
}