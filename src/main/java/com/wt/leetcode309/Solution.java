package com.wt.leetcode309;

/**
 * @program: leetcode
 * @description:
 * @author: wang tao
 * @create: 2020-01-25 22:21
 */
public class Solution {

    public int maxProfit(int[] prices) {
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

            if (i == 1) {
                dp[1][0] = Math.max(dp[0][0], dp[0][1] + prices[i]);
                dp[1][1] = Math.max(dp[0][1], -prices[i]);
                continue;
            }

            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
        }

        return dp[n - 1][0];
    }
}