package interviewbit.strings;

/*
Given an string A. The only operation allowed is to insert  characters in the beginning of the string.

Find how many minimum characters are needed to be inserted to make the string a palindrome string.

Input Format
The only argument given is string A.
Output Format
Return the minimum characters that are needed to be inserted to make the string a palindrome string.
For Example
Input 1:
    A = "ABC"
Output 1:
    2
    Explanation 1:
        Insert 'B' at beginning, string becomes: "BABC".
        Insert 'C' at beginning, string becomes: "CBABC".

Input 2:
    A = "AACECAAAA"
Output 2:
    2
    Explanation 2:
        Insert 'A' at beginning, string becomes: "AAACECAAAA".
        Insert 'A' at beginning, string becomes: "AAAACECAAAA".
 */
/*
Prerequisite: Longest Common Subsequence
Longest Palindromic Subsequence
 */

import java.util.Arrays;

public class MinimumCharactersForPalindrome {
    public static void main(String[] args) {
        System.out.println(solve("BABCA"));
    }

    /*
        The idea he is to find the prefix pattern, debug to understand.
     */
    public static int solve(String A) {
        StringBuilder rev_ = new StringBuilder();
        rev_.append(A);
        rev_.reverse();

        int j = 1, i = 0;
        String res = A + "$" + rev_;
        int n = res.length();
        int[] prefix = new int[n];
        while (j < n) {
            if (res.charAt(i) == res.charAt(j)) {
                prefix[j] = i + 1;
                i++;
                j++;
            } else {
                if (i != 0) {
                    i = prefix[i - 1];
                } else {
                    prefix[j] = 0;
                    j++;
                }
            }
        }
        return A.length() - prefix[n - 1];
    }

    /**
     * The below approach is to be used ideally but the question above is different such that letters
     * can only be added at the beginning
     **/
    public static int solve1(String A) {
        return A.length() - longestPalindromicSubsequence(A);
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
