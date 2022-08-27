package interviewbit.strings;

import java.util.Arrays;

// DP 26. Print Longest Common Subsequence | Dp on Strings
// https://youtu.be/-zI4mrF2Pb4
public class PrintLongestCommonSubsequence {
    public static void main(String[] args) {
        System.out.println(lcs("AGGTAB", "GXTXAYB"));
    }

    public static String lcs(String a, String b) {
        int m = a.length();
        int n = b.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

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

        int len = dp[m][n];
        char[] ans = new char[len];
        for (int i = 0; i < len; i++) {
            ans[i] = '$';
        }

        // Here we use DP matrix generated
        int index = len - 1;
        int i = m;
        int j = n;
        while (i > 0 && j > 0) {
            if (a.charAt(i - 1) == b.charAt(j - 1)) {
                ans[index] = a.charAt(i - 1);
                index--;
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        return new String(ans);
    }
}
