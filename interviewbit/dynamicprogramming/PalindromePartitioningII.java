package interviewbit.dynamicprogramming;

/*
Given a string A, partition A such that every substring of the partition is a palindrome.
Return the minimum cuts needed for a palindrome partitioning of A.

Problem Constraints
1 <= length(A) <= 501

Input Format
The first and the only argument contains the string A.

Output Format
Return an integer, representing the minimum cuts needed.

Example Input
Input 1:
 A = "aba"
Input 2:
 A = "aab"

Example Output
Output 1:
 0
Output 2:
 1

Example Explanation
Explanation 1:
 "aba" is already a palindrome, so no cuts are needed.
Explanation 2:
 Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
 */
public class PalindromePartitioningII {
    public static void main(String[] args) {
        System.out.println(new PalindromePartitioningII().minCut("aab"));
    }

    //https://youtu.be/ot5Q9dD5rWM
    public int minCut(String A) {
        int n = A.length();
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) { // worst case, all characters are distinct
            dp[i] = i - 1;
        }

        boolean[][] isPal = new boolean[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            isPal[i][i] = true;
        }

        for (int L = 2; L <= n; L++) {
            for (int i = 1; i + L <= n+1; i++) {
                int j = i + L - 1;

                if (L == 2) {
                    if (A.charAt(i - 1) == A.charAt(j - 1)) {
                        isPal[i][j] = true;
                    }
                } else {
                    if (A.charAt(i - 1) == A.charAt(j - 1) && isPal[i + 1][j - 1]) {
                        isPal[i][j] = true;
                    }
                }

            }
        }

        for (int i = 2; i <= n; i++) {
            if (isPal[1][i]) {
                dp[i] = 0;
            }
            for (int j = 2; j <= i; j++) {
                if (isPal[j][i]) {
                    dp[i] = Math.min(dp[i], 1 + dp[j - 1]);
                }
            }
        }

        return dp[n];
    }
}
