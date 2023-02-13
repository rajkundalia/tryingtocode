package interviewbit.dynamicprogramming;

/*
Given two strings A and B. Find the longest common sequence
( A sequence which does not need to be contiguous), which is common in both the strings.

You need to return the length of such longest common subsequence.

Problem Constraints
1 <= |A|, |B| <= 1005

Input Format
First argument is an string A.
Second argument is an string B.

Output Format
Return the length of such longest common subsequence between string A and string B.

Example Input
Input 1:
 A = "abbcdgf"
 B = "bbadcgf"

Example Output
Output 1:
 5

Example Explanation
Explanation 1:
 The longest common subsequence is "bbcgf", which has a length of 5
 */
//https://youtu.be/Xtv_0EpzChE
public class LongestCommonSubsequence {
    public static void main(String[] args) {
        System.out.println(new LongestCommonSubsequence().solve("abbcdgf", "bbadcgf"));
    }

    public int solve(String A, String B) {
        int[][] dp = new int[A.length() + 1][A.length() + 1];

        // filling up the first row and column considering empty string
        for (int i = 0; i <= A.length(); i++) {
            dp[0][i] = 0;
            dp[i][0] = 0;
        }

        for (int i = 1; i <= A.length(); i++) {
            for (int j = 1; j <= A.length(); j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1]; //diagonal
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); //top and left side
                }
            }
        }
        return dp[A.length()][A.length()];
    }
}
