package interviewbit.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

/*
Given an integer array A of size N. You have to merge all the elements of the array into one with the minimum possible cost.

The rule for merging is as follows:

Choose any two adjacent elements of the array with values say X and Y and merge them into a single element with value
(X + Y) paying a total cost of (X + Y).

Return the minimum possible cost of merging all elements.

Problem Constraints
1 <= N <= 200
1 <= A[i] <= 103

Input Format
First and only argument is an integer array A of size N.

Output Format
Return an integer denoting the minimum cost of merging all elements.

Example Input
Input 1:
 A = [1, 3, 7]
Input 2:
 A = [1, 2, 3, 4]

Example Output
Output 1:
 15
Output 2:
 19

Example:
Explanation 1:
 All possible ways of merging:
 a) {1, 3, 7} (cost = 0) -> {4, 7} (cost = 4) -> {11} (cost = 4+11 = 15)
 b) {1, 3, 7} (cost = 0) -> {1, 10} (cost = 10) -> {11} (cost = 10+11 = 21)
 Thus, ans = 15
 */
//https://youtu.be/TFdclijv4Mg
public class MergeElements {
    public static void main(String[] args) {
        System.out.println(new MergeElements().solve(new ArrayList<>(List.of(1, 2, 3, 4))));
    }

    public int solve(ArrayList<Integer> A) {
        int n = A.size();
        int[] prefix = new int[n + 1];

        // This helps in finding sum of elements in array
        // e.g. A - 1,2,3,4
        // prefix - 0 1 3 6 10
        for (int i = 1; i < n + 1; i++) {
            prefix[i] = prefix[i - 1] + A.get(i - 1);
        }

        int[][] dp = new int[n][n];

        // only diagonal traversal,
        /*
            00 01 02 03
            10 11 12 13
            20 21 22 23
            30 31 32 33

            Here we consider only 01 02 03 12 13 23, other elements will be something that changes the order
            of finding sum i.e. we always go forward for the summing up and not backwards
         */
        for (int diff = 1; diff < n; diff++) {
            int i = 0;
            int j = i + diff;

            for (; j < n; j++, i++) {
                dp[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], prefix[j + 1] - prefix[i] + dp[i][k] + dp[k + 1][j]);
                }

                /*
                    Cases:
                    i = 0, j = 3

                    1. (0,0) + (1,3) -> (i,k) + (k + 1,j)
                       (prefix[1] - prefix[0]) + (prefix[4] - prefix[1]) + dp[0][0] + dp[1][3]

                    2. (0,1) + (2,3)
                       (prefix[2] - prefix[0]) + (prefix[4] - prefix[2]) + dp[0][1] + dp[2][3]

                    3. (0,2) + (3,3)
                       (prefix[3] - prefix[0]) + (prefix[4] - prefix[3]) + dp[0][2] + dp[3][3]

                 */
            }
        }
        return dp[0][n - 1];
    }
}
