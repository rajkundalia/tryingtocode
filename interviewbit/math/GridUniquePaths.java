package interviewbit.math;

import java.util.Arrays;

/*
A robot is located at the top-left corner of an A x B grid (marked ‘Start’ in the diagram below).
Path Sum: Example 1
The robot can only move either down or right at any point in time.
The robot is trying to reach the bottom-right corner of the grid (marked ‘Finish’ in the diagram below).
How many possible unique paths are there?
Note: A and B will be such that the resulting answer fits in a 32 bit signed integer.
Example :
Input : A = 2, B = 2
Output : 2

2 possible routes : (0, 0) -> (0, 1) -> (1, 1)
              OR  : (0, 0) -> (1, 0) -> (1, 1)
 */
public class GridUniquePaths {
    public static void main(String[] args) {
        System.out.println(solveGridUniquePaths(2, 2));
    }

    /*
        Approach would be in terms of grid:
        0,0 to 2,6 or 1,1 to 3,7

        Find number of ways to travel from starting point
        S(1,1)   1       1       1        1       1       1
        1       2(2,2)   3       4(2,4)   5       6       7
        1       3        6(3,3)  10(3,4)  15      21      28 End

        first column and row has only 1 direction each to reach there.
        Where 2 is present, you can reach there from top by coming down or from bottom to go towards right, so 1+1=2 ways
        for 3,4 - addition of ways from (2,4)+(3,3)
     */
    public static int solveGridUniquePaths(int A, int B) {
        int[][] grid = new int[A][B];
        for (int[] arr : grid) {
            Arrays.fill(arr, 1);
        }
        for (int i = 1; i < A; i++) {
            for (int j = 1; j < B; j++) {
                grid[i][j] = grid[i - 1][j] + grid[i][j - 1];
            }
        }
        return grid[A - 1][B - 1];
    }

    public int uniquePaths(int A, int B) {
        if (A == 1 || B == 1)
            return 1;
        else
            return uniquePaths(A - 1, B) + uniquePaths(A, B - 1);
    }
}
