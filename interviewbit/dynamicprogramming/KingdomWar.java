package interviewbit.dynamicprogramming;

/*
Two kingdoms are on a war right now, kingdom X and kingdom Y. As a war specialist of kingdom X,
you scouted kingdom Y area.

A kingdom area is defined as a N x M grid with each cell denoting a village.

Each cell has a value which denotes the strength of each corresponding village.

The strength can also be negative, representing those warriors of your kingdom who were held hostages.

There’s also another thing to be noticed.

The strength of any village on row larger than one (2<=r<=N) is stronger or equal to the strength of village
which is exactly above it.
The strength of any village on column larger than one (2<=c<=M) is stronger or equal to the strength of
village which is exactly to its left.

(stronger means having higher value as defined above).
So your task is, find the largest sum of strength that you can erase by bombing one sub-matrix in the grid.

Input format:

First line consists of 2 integers N and M denoting the number of rows and columns in the grid respectively.
The next N lines, consists of M integers each denoting the strength of each cell.

1 <= N <= 1500
1 <= M <= 1500
-200 <= Cell Strength <= 200
Output:

The largest sum of strength that you can get by choosing one sub-matrix.
Example:

Input:
3 3
-5 -4 -1
-3 2 4
2 5 8

Output:
19

Explanation:
Bomb the sub-matrix from (2,2) to (3,3): 2 + 4 + 5 + 8 = 19
 */
public class KingdomWar {
    public static void main(String[] args) {
        int[][] A = {
                {-5, -4, -1},
                {-3, 2, 4},
                {2, 5, 8}
        };
        System.out.println(new KingdomWar().solve(A));
    }

    //https://youtu.be/lInhOSvjg6E
    /*

        // the thing at each point the value is sorted from its above
        // top and left values, so it's certain that last value will be the biggest

        //[ -5 , -2 , -1]
        //[ -2  , 1 ,  4]
        //[  3  , 5 ,  10]

        //[ 16 ,  18 , 13]
        //[  21  , 20 ,  14]
        //[  18 , 15 ,  10]

        // ans = 21

        // as at every point  u calculate the value of a possible  matrix  ,

        // dp[i][j] = curr_value + dp[i][j+1] + dp[i+1][j]  - dp[i+1][j+1]

        // dp[i][j+1] -> denotes the grid of values from below part of (i , j+1) -> including itself

        // dp[i+1][j]->denotes the grid of values from below part of (i+1 , j) -> including itself

        // as both contains grid(i+1 , j+1) values , it comes twice so we
        // will subtract dp[i+1][j+1];

        // dp[i][j+1] + dp[]

     */
    public int solve(int[][] A) {
        int n = A.length;
        int m = A[0].length;



        int[][] dp = new int[n + 1][m + 1];
        int ans = Integer.MIN_VALUE;

        for (int i = n; i >= 0; i--) {
            for (int j = m; j >= 0; j--) {
                if (i == n || j == m) {
                    continue;
                }
                //
                dp[i][j] = A[i][j] + dp[i + 1][j] + dp[i][j + 1] - dp[i + 1][j + 1];
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }
}
