package interviewbit.dynamicprogramming;

/*
Given a string A, Check if the length of the longest repeating sub-sequence is greater than or equal to 2,
A longest repeating sub-sequence is defined such that,
the two subsequences have the same string character at the same position
any ith character in the two subsequences should not have the same index in the original string
NOTE: If the Sub-sequence length is greater than or equal to 2 return 1, else return 0.

Problem Constraints
 1 <= |A| <= 100

Input Format
The first and only argument of input contains a string A.

Output Format
Return an integer, 0 or 1:
    => 0 : Length of Repeating subsequence is less than 2
    => 1 : Length of Repeating subsequence is greater than or equal to 2

Example Input
Input 1:
 A = "abab"
Input 2:
 A = "abba"

Example Output
Output 1:
 1
Output 2:
 0

Example Explanation
Explanation 1:
 "ab" is repeated.
Explanation 2:
 There is no repeating subsequence.
 */
public class RepeatingSubsequence {
    public static void main(String[] args) {
        System.out.println(new RepeatingSubsequence().anytwo("abab"));
    }

    public int anytwo(String A) {
        return lcsHelper(A, A);
    }

    public int lcsHelper(String A, String B) {
        int[][] dp = new int[A.length() + 1][B.length() + 1];

        // filling up the first row and column considering empty string
        for (int i = 0; i <= A.length(); i++) {
            dp[0][i] = 0;
            dp[i][0] = 0;
        }

        for (int i = 1; i <= A.length(); i++) {
            for (int j = 1; j <= B.length(); j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1) && i != j) {
                    dp[i][j] = 1 + dp[i - 1][j - 1]; //diagonal
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); //top and left side
                }
            }
        }
        return dp[A.length()][A.length()] >= 2 ? 1 : 0;
    }
}
