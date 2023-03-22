package interviewbit.dynamicprogramming;

/*
Given a 2D integer array A of size M x N, you need to find a path from top left to bottom right which
minimizes the sum of all numbers along its path.

NOTE: You can only move either down or right at any point in time.

Input Format
First and only argument is an 2D integer array A of size M x N.

Output Format
Return a single integer denoting the minimum sum of a path from cell (1, 1) to cell (M, N).

Example Input
Input 1:
 A = [  [1, 3, 2]
        [4, 3, 1]
        [5, 6, 1]
     ]

Example Output
Output 1:
 8

Example Explanation
Explanation 1:
 The path is 1 -> 3 -> 2 -> 1 -> 1
 So ( 1 + 3 + 2 + 1 + 1) = 8
 */
public class MinSumPathInMatrix {
    public static void main(String[] args) {
//        System.out.println(new MinSumPathInMatrix().minPathSum(new int[][]{
//                {1, 3, 2},
//                {4, 3, 1},
//                {5, 6, 1}
//        }));
        System.out.println(new MinSumPathInMatrix().minPathSum(new int[][]{
                {6, 4, 63},
                {14, 95, 20},
                {31, 85, 6}
        }));
    }

    public int minPathSum(int[][] A) {
        int m = A.length;
        int n = A[0].length;

        int[][] dp = new int[m][n];

        dp[0][0] = A[0][0];

        // 1st row
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + A[i][0];
        }

        // 1st column
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + A[0][j];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = A[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[m - 1][n - 1];
    }
}
