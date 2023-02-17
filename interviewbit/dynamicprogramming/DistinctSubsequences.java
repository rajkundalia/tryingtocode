package interviewbit.dynamicprogramming;

import java.util.Arrays;

/*
Given two sequences A, B, count number of unique ways in sequence A,
to form a subsequence that is identical to the sequence B.

Subsequence : A subsequence of a string is a new string which is formed from the original string by
deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters.
(ie, “ACE” is a subsequence of “ABCDE” while “AEC” is not).

Input Format:
The first argument of input contains a string, A.
The second argument of input contains a string, B.

Output Format:
Return an integer representing the answer as described in the problem statement.

Constraints:
1 <= length(A), length(B) <= 700
Example :
Input 1:
    A = "abc"
    B = "abc"

Output 1:
    1

Explanation 1:
    Both the strings are equal.

Input 2:
    A = "rabbbit"
    B = "rabbit"

Output 2:
    3

Explanation 2:
    These are the possible removals of characters:
        => A = "ra_bbit"
        => A = "rab_bit"
        => A = "rabb_it"

    Note: "_" marks the removed character.
 */
public class DistinctSubsequences {
    public static void main(String[] args) {
        System.out.println(new DistinctSubsequences().numDistinct("abc", "abc"));
    }

    public int numDistinct(String A, String B) {
        if (A.equals(B)) {
            return 1;
        }
        int dp[][] = new int[A.length() + 1][B.length() + 1];
        for (int[] e : dp) {
            Arrays.fill(e, -1);
        }
        return numDistinct(A, B, 0, 0, dp);
    }

    private int numDistinct(String A, String B, int i, int j, int[][] dp) {
        if (j == B.length()) {
            return 1;
        }
        if (i == A.length()) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (A.charAt(i) == B.charAt(j)) {
            dp[i][j] = numDistinct(A, B, i + 1, j + 1, dp) // include the character
                    + numDistinct(A, B, i + 1, j, dp); // exclude the character
        } else {
            dp[i][j] = numDistinct(A, B, i + 1, j, dp); // exclude the character
        }
        return dp[i][j];
    }
}
