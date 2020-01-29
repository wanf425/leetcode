package com.wt.leetcode121;

/**
 * @author wangtao
 * <p>
 * 动态规划解法
 * <p>
 * <p>
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/solution/yi-ge-fang-fa-tuan-mie-6-dao-gu-piao-wen-ti-by-l-3/
 */
public class Solution {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n <= 0) {
            return 0;
        }

        int dp_i_0 = 0;
        int dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, -prices[i]);
        }

        return dp_i_0;
    }

    public int maxProfit2(int[] prices) {
        int n = prices.length;
        if (n <= 0) {
            return 0;
        }

        int[][] dp = new int[n][2];

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }

            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }

        return dp[n - 1][0];
    }

}
