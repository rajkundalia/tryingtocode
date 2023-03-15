package interviewbit.dynamicprogramming;

/*
Given a 2D integer array A of size  N * N   representing a triangle of numbers.
Find the maximum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

NOTE:
Adjacent cells to cell (i,j) are only (i+1,j) and (i+1,j+1)
Row i contains i integer and n-i zeroes for all i in [1,n] where zeroes represent empty cells.

Problem Constraints
 0 <= N <= 1000
 0 <= A[i][j] <= 1000

Input Format
First and only argument is an 2D integer array A of size N * N.

Output Format
Return a single integer denoting the maximum path sum from top to bottom in the triangle.

Example Input
Input 1:
 A = [
        [3, 0, 0, 0]
        [7, 4, 0, 0]
        [2, 4, 6, 0]
        [8, 5, 9, 3]
     ]
Input 2:
 A = [
        [8, 0, 0, 0]
        [4, 4, 0, 0]
        [2, 2, 6, 0]
        [1, 1, 1, 1]
     ]

Example Output
Output 1:
 23
Output 2:
 19

Example Explanation
Explanation 1:
 Given triangle looks like:  3
                             7 4
                             2 4 6
                             8 5 9 3
        So max path is (3 + 7 + 4 + 9) = 23
Explanation 1:
 Given triangle looks like:  8
                             4 4
                             2 2 6
                             1 1 1 1
        So max path is (8 + 4 + 6 + 1) = 19
 */
public class MaximumPathInTriangle {
    public static void main(String[] args) {
        System.out.println(new MaximumPathInTriangle().solve(new int[][]{
                {3, 0, 0, 0},
                {7, 4, 0, 0},
                {2, 4, 6, 0},
                {8, 5, 9, 3}
        }));
    }

    /*
        Traverse the triangle from bottom to up to get the maximum path sum from top to bottom.

        dp[i][j] = max(dp[i+1][j],dp[i+1][j+1]) + A[i][j]
     */
    public int solve(int[][] input) {
        int n = input.length;
        // start from row above bottom row
        // since the bottom row cells are the answers themselves
        for(int i=n-2;i>=0;i--)
        {
            // start from left to right in column
            for(int j=0;j<=i;j++)
            {
                if(input[i+1][j] > input[i+1][j+1])
                    input[i][j] += input[i+1][j];
                else
                    input[i][j] += input[i+1][j+1];
            }
        }
        return input[0][0];
    }
}
