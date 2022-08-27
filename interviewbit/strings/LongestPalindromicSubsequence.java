package interviewbit.strings;

import java.util.Arrays;

public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        System.out.println(longestPalindromicSubsequence("bbabcbcab"));
    }

    public static int longestPalindromicSubsequence(String s) {
        String a = s;
        String b = new StringBuilder(s).reverse().toString();
        return lengthOfLCSOptimizedTabulationBottomUpApproach(a, b);
    }

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
