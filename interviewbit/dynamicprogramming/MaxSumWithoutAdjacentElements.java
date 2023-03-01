package interviewbit.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

/*
Given a 2 x N grid of integer, A, choose numbers such that the sum of the numbers
is maximum and no two chosen numbers are adjacent horizontally, vertically or diagonally, and return it.
Note: You can choose more than 2 numbers.

Input Format:
The first and the only argument of input contains a 2d matrix, A.
Output Format:
Return an integer, representing the maximum possible sum.
Constraints:
1 <= N <= 20000
1 <= A[i] <= 2000
Example:
Input 1:
    A = [   [1]
            [2]    ]
Output 1:
    2
Explanation 1:
    We will choose 2.
Input 2:
    A = [   [1, 2, 3, 4]
            [2, 3, 4, 5]    ]
Output 2:
    We will choose 3 and 5.
 */
public class MaxSumWithoutAdjacentElements {

    public static void main(String[] args) {
        System.out.println(new MaxSumWithoutAdjacentElements().adjacent(new ArrayList<>(List.of(
                new ArrayList<>(List.of(1, 2, 3, 4)),
                new ArrayList<>(List.of(2, 3, 4, 5))))));
    }

    public int adjacent(ArrayList<ArrayList<Integer>> A) {
        int n = A.get(0).size();
        int[] dp = new int[n];

        dp[0] = Math.max(A.get(0).get(0), A.get(1).get(0)); // first column

        if (n == 1) {
            return dp[0];
        }

        dp[1] = Math.max(dp[0], Math.max(A.get(0).get(1), A.get(1).get(1))); // 2nd column

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(Math.max(A.get(0).get(i), A.get(1).get(i)) + dp[i - 2], dp[i - 1]);
        }

        return dp[n - 1];
    }
}
