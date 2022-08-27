package interviewbit.strings;

import java.util.Arrays;

/*
    Understood it from: https://youtu.be/NPZn9jBrX8U
    Dp 25. Longest Common Subsequence | Top Down | Bottom-Up | Space Optimised | DP on Strings
 */
public class LongestCommonSubsequence {
    public static void main(String[] args) {
        System.out.println(lengthOfLCS("acd", "ced", 3, 3));
        System.out.println(lengthOfLCSOptimized("acd", "ced"));
        System.out.println(lengthOfLCSOptimizedTabulationBottomUpApproach("acd", "ced"));
    }

    /*
        APPROACH 1:
        Find LCS using recursion.
        This is not an optimized approach
        https://takeuforward.org/data-structure/longest-common-subsequence-dp-25/
     */
    public static int lengthOfLCS(String a, String b, int aL, int bL) {
        if (aL == 0 || bL == 0) // == and not less than 0 because we are passing length and not length - 1.
            return 0;
        if (a.charAt(aL - 1) == b.charAt(bL - 1))
            return 1 + lengthOfLCS(a, b, aL - 1, bL - 1);
        else
            return Math.max(lengthOfLCS(a, b, aL, bL - 1), lengthOfLCS(a, b, aL - 1, bL));
    }

    /*
        APPROACH 2:
        LCS using recursion + DP store
     */
    public static int lengthOfLCSOptimized(String a, String b) {
        int m = a.length();
        int n = b.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return lengthOfLCSOptimizedHelper(a, b, m, n, dp);
    }

    private static int lengthOfLCSOptimizedHelper(String a, String b, int m, int n, int[][] dp) {
        if (n == 0 || m == 0) // == and not less than 0 because we are passing length and not length - 1.
            return 0;
        if (dp[m][n] != -1)
            return dp[m][n];
        if (a.charAt(m - 1) == b.charAt(n - 1))
            return dp[m][n] = 1 + lengthOfLCSOptimizedHelper(a, b, m - 1, n - 1, dp);
        else
            return dp[m][n] = Math.max(lengthOfLCSOptimizedHelper(a, b, m, n - 1, dp), lengthOfLCSOptimizedHelper(a, b, m - 1, n, dp));
    }

    /*
        APPROACH 3:
        Tabulation Bottom Up Approach
        Non-Recursive
     */
    public static int lengthOfLCSOptimizedTabulationBottomUpApproach(String a, String b) {
        int m = a.length();
        int n = b.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        // So these 2 for loops replicates the base case from the recursive approach
        // if (n == 0 || m == 0) return 0;
        for (int i = 0; i <= n; i++) {
            dp[0][i] = 0;
        }
        for (int j = 0; j <= m; j++) {
            dp[j][0] = 0;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
