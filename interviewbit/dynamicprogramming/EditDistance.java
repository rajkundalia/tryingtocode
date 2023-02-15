package interviewbit.dynamicprogramming;

/*
Given two strings A and B, find the minimum number of steps required to convert A to B.
(each operation is counted as 1 step.)
You have the following 3 operations permitted on a word:
Insert a character
Delete a character
Replace a character

Input Format:
The first argument of input contains a string, A.
The second argument of input contains a string, B.
Output Format:
Return an integer, representing the minimum number of steps required.
Constraints:
1 <= length(A), length(B) <= 450
Examples:
Input 1:
    A = "abad"
    B = "abac"

Output 1:
    1
Explanation 1:
    Operation 1: Replace d with c.

Input 2:
    A = "Anshuman"
    B = "Antihuman"
Output 2:
    2
Explanation 2:
    => Operation 1: Replace s with t.
    => Operation 2: Insert i.
 */
public class EditDistance {
    public static void main(String[] args) {
        System.out.println(new EditDistance().minDistance("Anshuman", "Antihuman"));
    }

    public int minDistance(String A, String B) {
        int m = A.length();
        int n = B.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            dp[0][i] = i;
        }
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {                    // i-1, j-1 -> replace
                                            // i, j-1 -> insert
                                            // i-1, j -> delete
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
            }
        }
        return dp[m][n];
    }
}
