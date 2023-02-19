package interviewbit.dynamicprogramming;

/*
Implement regular expression matching with support for '.' and '*'.
'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

Return 0 / 1 ( 0 for false, 1 for true ) for this problem

Problem Constraints
1 <= |A| <= 5 * 103
1 <= |B| <= 5 * 103

Input Format
The first argument is a string A.
The second argument is a string A.

Output Format
Return an integer, 0 / 1 ( 0 for false, 1 for true ) for this problem

Example Input
isMatch("aa","a") → 0
isMatch("aa","aa") → 1
isMatch("aaa","aa") → 0
isMatch("aa", "a*") → 1
isMatch("aa", ".*") → 1
isMatch("ab", ".*") → 1
isMatch("aab", "c*a*b") → 1

 */
public class RegularExpressionMatch2 {
    public static void main(String[] args) {
        System.out.println(new RegularExpressionMatch2().isMatch("aab", "c*a*b"));
    }

    public int isMatch(final String A, final String B) {
        int n = A.length();
        int m = B.length();

        boolean[][] dp = new boolean[n + 1][m + 1];

        dp[0][0] = true;

        for (int i = 1; i < dp[0].length; i++) {
            if (B.charAt(i - 1) == '*') {
                dp[0][i] = dp[0][i - 2];
            }
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (B.charAt(j - 1) == '.' || B.charAt(j - 1) == A.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (B.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2];
                    if (B.charAt(j - 2) == '.' || B.charAt(j - 2) == A.charAt(i - 1)) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[n][m] ? 1 : 0;
    }
}
