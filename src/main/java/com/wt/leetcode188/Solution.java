package com.wt.leetcode188;

/**
 * @program: leetcode
 * @description:
 * @author: wang tao
 * @create: 2020-01-25 16:27
 */
public class Solution {

    public int maxProfit(int max_k, int[] prices) {
        int n = prices.length;
        if (n <= 0) {
            return 0;
        }

        if (max_k > n / 2) {
            return maxProfit(prices);
        }


        int[][][] dp = new int[n][max_k + 1][2];


        for (int i = 0; i < n; i++) {
            for (int k = max_k; k >= 1; k--) {
                if (i == 0) {
                    dp[i][k][0] = 0;
                    dp[i][k][1] = -prices[i];
                    continue;
                }

                dp[i][k][0] =
                        Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1],
                        dp[i - 1][k - 1][0] - prices[i]);

            }
        }

        return dp[n - 1][max_k][0];
    }


    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n <= 0) {
            return 0;
        }

        int dp_i_0 = 0;
        int dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int tmp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, tmp - prices[i]);
        }

        return dp_i_0;
    }


}