package interviewbit.dynamicprogramming;

/*
Given a grid of size m * n, lets assume you are starting at (1,1) and your goal is to reach (m,n).
At any instance, if you are on (x, y), you can either go to (x, y + 1) or (x + 1, y).

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

Example :
There is one obstacle in the middle of a 3x3 grid as illustrated below.
[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.

Note: m and n will be at most 100.
 */
public class UniquePathsInAGrid {
    public static void main(String[] args) {
        System.out.println(new UniquePathsInAGrid().uniquePathsWithObstacles(new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        }));
    }

    /*
        If you look at a cell, there are atmost 2 ways to reach it. From the cell left and up.

        If the cell does not have an obstacle, then the number of ways to reach this cell would be the
        summation of the number of ways to reach the immediate neighbors preceding it ( left and up ).
     */
    public int uniquePathsWithObstacles(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = 0;
                if (A[i][j] == 1) {
                    continue;
                }
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                }

                if (i > 0) {
                    dp[i][j] += dp[i - 1][j];
                }
                if (j > 0) {
                    dp[i][j] += dp[i][j - 1];
                }
            }
        }

        return dp[n - 1][m - 1];
    }
}
