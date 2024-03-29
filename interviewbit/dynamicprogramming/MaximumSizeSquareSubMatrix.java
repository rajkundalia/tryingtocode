package interviewbit.dynamicprogramming;

/*
Given a 2D binary matrix A of size  N x M  find the area of maximum size square sub-matrix with all 1's.

Problem Constraints
1 <= N, M <= 103
 A[i][j] = 1 or A[i][j] = 0

Input Format
First argument is an 2D matrix A of size N x M.

Output Format
Output the area of maximum size square sub-matrix in A with all 1's.

Example Input
Input 1:
 A = [

        [0, 1, 1, 0, 1],

        [1, 1, 0, 1, 0],

        [0, 1, 1, 1, 0],

        [1, 1, 1, 1, 0],

        [1, 1, 1, 1, 1],

        [0, 0, 0, 0, 0]
     ]
Input 2:
 A = [

       [1, 1],
       [1, 1]
     ]


Example Output
Output 1:
 9
Output 2:
 4


Example Explanation
Explanation 1:

  Consider the below binary matrix.
 The area of the square is 3 * 3 = 9
Explanation 2:
 The given matrix is the largest size square possible so area will be 2 * 2 = 4
 */
public class MaximumSizeSquareSubMatrix {
    public static void main(String[] args) {
        System.out.println(new MaximumSizeSquareSubMatrix().solve(new int[][]{
                {1, 1},
                {1, 1}
        }));
    }

    public int solve(int[][] A) {
        int m = A.length; // rows
        int n = A[0].length; // columns

        int ans = 1;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    if (A[i][j] == 1) {
                        dp[i][j] = 1;
                    }
                } else {
                    if (A[i][j] == 1) {
                        dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                    }
                    ans = Math.max(ans, dp[i][j]);
                }

            }
        }
        return ans * ans;
    }
}
