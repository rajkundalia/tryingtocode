package interviewbit.dynamicprogramming;

/*
Given a string A, find the common palindromic sequence
(A sequence which does not need to be contiguous and is a palindrome), which is common in itself.

You need to return the length of longest palindromic subsequence in A.
NOTE:
Your code will be run on multiple test cases (<=10). Try to come up with an optimised solution.
Problem Constraints
 1 <= |A| <= 1005

Input Format
First and only argument is an string A.

Output Format
Return a integer denoting the length of longest palindromic subsequence in A.

Example Input
Input 1:
 A = "bebeeed"

Example Output
Output 1:
 4
Example Explanation
Explanation 1:
 The longest common pallindromic subsequence is "eeee", which has a length of 4
 */
public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubsequence().solve("bebeeed"));
    }

    public int solve(String A) {
        return lcs(A, new StringBuilder(A).reverse().toString());
    }

    public int lcs(String a, String b) {
        int[][] dp = new int[a.length() + 1][b.length() + 1];
        for (int i = 0; i <= a.length(); i++) {
            dp[0][i] = 0;
            dp[i][0] = 0;
        }

        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1]; //diagonal
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); //top and left side
                }
            }
        }
        return dp[a.length()][b.length()];
    }
}
