package interviewbit.strings;

/*
    https://youtu.be/_wP9mWNPL5w
    DP 27. Longest Common Substring | DP on Strings 🔥
 */
public class LongestCommonSubstring {
    public static void main(String[] args) {
        System.out.println(longestCommonSubstring("abcd", "abcd"));
    }

    public static int longestCommonSubstring(String a, String b) {
        int m = a.length();
        int n = b.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            dp[0][i] = 0;
        }
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 0;
        }
        int ans = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    ans = Math.max(ans, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return ans;
    }
}
