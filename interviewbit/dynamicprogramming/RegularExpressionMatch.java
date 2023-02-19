package interviewbit.dynamicprogramming;

/*
Implement wildcard pattern matching with support for '?' and '*' for strings A and B.
'?' : Matches any single character.
'*' : Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).

Problem Constraints
1 <= |A|, |B| <= 9e4

Input Format
The first argument of input contains a string A.
The second argument of input contains a string B.

Output Format
Return 0 or 1:
=> 0 : If the patterns do not match.
=> 1 : If the patterns match.

Example Input
Input 1:
 A = "aa"
 B = "a"
Input 2:
 A = "aa"
 B = "aa"
Input 3:
 A = "aaa"
 B = "aa"
Input 4:
 A = "aa"
 B = "*"
Input 5:
 A = "aa"
 B = "a*"
Input 6:
 A = "ab"
 B = "?*"
Input 7:
 A = "aab"
 B = "c*a*b"

Example Output
Output 1:
0
Output 2:
1
Output 3:
0
Output 4:
1
Output 5:
1
Output 6:
1
Output 7:
0
 */
//https://youtu.be/7SHV_QfVROE
public class RegularExpressionMatch {
    public static void main(String[] args) {
        System.out.println(new RegularExpressionMatch().isMatch("albmnc", "a?b*c"));
    }

    public int isMatch(final String A, final String B) {
        int n = A.length();
        int m = B.length();

        boolean[][] dp = new boolean[m + 1][n + 1];

        dp[0][0] = true;

        for (int i = 1; i <= m; i++) {
            if (B.charAt(i - 1) == '*') {
                // this is a test case for e.g. when pattern is * and A is aaaaa
                dp[i][0] = dp[i - 1][0];
            } else {
                break;
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (B.charAt(i - 1) == '*') {
                    // i, j-1 to when * will represent empty string
                    // i-1, j to check when * replaced with a character
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else if (B.charAt(i - 1) == A.charAt(j - 1) || B.charAt(i - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1]; // from diagonal
                }
            }
        }

        return dp[m][n] ? 1 : 0;
    }
}
