package interviewbit.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

/*
There are a row of N houses, each house can be painted with one of the three colors: red, blue or green.

The cost of painting each house with a certain color is different.
You have to paint all the houses such that no two adjacent houses have the same color.

The cost of painting each house with a certain color is represented by a N x 3 cost matrix A.

For example, A[0][0] is the cost of painting house 0 with color red;
A[1][2] is the cost of painting house 1 with color green, and so on.

Find the minimum total cost to paint all houses.

Problem Constraints
1 <= N <= 105
1 <= A[i][j] <= 103

Input Format
First and only argument is an 2D integer matrix A of size N x 3 denoting the cost to paint the houses.

Output Format
Return an integer denoting the minimum total cost to paint all houses.

Example Input
A = [
        [cost of red for house 1, cost of blue for house 1, cost of green for house 1],
        [cost of red for house 2, cost of blue for house 2, cost of green for house 2]
    ]
Input 1:
 A = [  [1, 2, 3]
        [10, 11, 12]
     ]

Example Output
Output 1:
 12

Example Explanation
Explanation 1:
 Paint house 1 with red and house 2 with green i.e A[0][0] + A[1][1] = 1 + 11 = 12
 */
//https://youtu.be/kh48JLieeW8
public class PaintHouse {
    public static void main(String[] args) {
        System.out.println(new PaintHouse().solve(new ArrayList<>(List.of(
                new ArrayList<>(List.of(1, 2, 3)), new ArrayList<>(List.of(10, 11, 12))))));
    }

    public int solve(ArrayList<ArrayList<Integer>> A) {
        int n = A.size();
        int[][] dp = new int[n][3];

        // setting for 1st house
        dp[0][0] = A.get(0).get(0);
        dp[0][1] = A.get(0).get(1);
        dp[0][2] = A.get(0).get(2);

        for (int i = 1; i < n; i++) {
            // 0 - red, 1 - blue, 2 - green
            // setting color for subsequent houses
            // A.get(i).get(0) -> cost of painting it red considering previous house was not red
            // Math.min(dp[i - 1][1], dp[i - 1][2]) -> finding minimum cost of blue or green

            // dp[i][0] - gives us cost of that house red and minimum cost of
            // previous house (minimum of blue or green) + current house (red)
            dp[i][0] = A.get(i).get(0) + Math.min(dp[i - 1][1], dp[i - 1][2]);

            // dp[i][1] - gives us cost of that house blue and minimum cost of
            // previous house (minimum of red or green) + current house (blue)
            dp[i][1] = A.get(i).get(1) + Math.min(dp[i - 1][0], dp[i - 1][2]);

            // dp[i][2] - gives us cost of that house green and minimum cost of
            // previous house (minimum of blue or red) + current house (green)
            dp[i][2] = A.get(i).get(2) + Math.min(dp[i - 1][0], dp[i - 1][1]);
        }

        return Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2]));
    }
}

