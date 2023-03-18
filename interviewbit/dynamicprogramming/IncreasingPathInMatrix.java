package interviewbit.dynamicprogramming;

/*
Given a 2D integer matrix A of size N x M.
From A[i][j] you can move to A[i+1][j], if A[i+1][j] > A[i][j], or can move to A[i][j+1] if A[i][j+1] > A[i][j].
The task is to find and output the longest path length possible if we start
from the cell (0, 0) and want to reach cell (N - 1, M - 1).

NOTE:
If there doesn't exist a path return -1.

Problem Constraints
1 <= N, M <= 103
1 <= A[i][j] <= 108

Input Format
First and only argument is an 2D integer matrix A of size N x M.

Output Format
Return a single integer denoting the length of longest path in the matrix if no such path exists return -1.

Example Input
Input 1:
 A = [  [1, 2]
        [3, 4]
     ]
Input 2:
 A = [  [1, 2, 3, 4]
        [2, 2, 3, 4]
        [3, 2, 3, 4]
        [4, 5, 6, 7]
     ]

Example Output
Output 1:
 3
Output 2:
 7

Example Explanation
Explanation 1:
 Longest path is either 1 2 4 or 1 3 4.
Explanation 2:
 Longest path is 1 2 3 4 5 6 7.
 */
public class IncreasingPathInMatrix {
    public static void main(String[] args) {
        System.out.println(new IncreasingPathInMatrix().solve(new int[][]{
                {1, 2},
                {3, 4}
        }));
    }

    public int solve(int[][] A) {
        int n = A.length;
        int m = A[0].length;

        int[][] dp = new int[n][m];

        dp[n - 1][m - 1] = 1;

        for (int i = n - 1; i > -1; i--) {
            for (int j = m - 1; j > -1; j--) {
                if (i == n - 1 && j == m - 1) {
                    continue;
                }
                int a1 = -1, a2 = -1;
                if (i + 1 < n && A[i + 1][j] > A[i][j]) {
                    a1 = 1 + dp[i + 1][j];
                }
                if (j + 1 < m && A[i][j + 1] > A[i][j]) {
                    a2 = 1 + dp[i][j + 1];
                }
                dp[i][j] = Math.max(a1, a2);
            }
        }
        if (dp[0][0] < m + n - 1) {
            return -1;
        }
        return dp[0][0];
    }
}
