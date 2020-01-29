package com.wt.leetcode5;

/**
 * @program: leetcode
 * @description: 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: wang tao
 * @create: 2020-01-27 21:28
 */
public class Solution {
    public static void main(String[] args) {
        String s = "aaaa";
        Solution solution = new Solution();

        System.out.println(solution.longestPalindrome(s));
    }


    /**
     * @Description:
     * 如果是回文子串，则
     * s(i) = s(j) 并且
     * dp(i, j) = dp(i+1,j-1);
     * @Param:
     * @return:
     * @Author: your name
     * @date:
     */
    public String longestPalindrome(String s) {
        if (s == null) {
            return "";
        }
        int n = s.length();

        if (n == 0 || n == 1) {
            return s;
        }

        boolean[][] dp = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        int maxlength = 1;
        int start = 0;

        for (int j = 1; j < s.length(); j++) {
            for (int i = 0; i < j; i++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 2) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                if (dp[i][j]) {
                    if (j - i + 1 > maxlength) {
                        maxlength = j - i + 1;
                        start = i;
                    }
                }
            }
        }

        return s.substring(start, start + maxlength);
    }
}