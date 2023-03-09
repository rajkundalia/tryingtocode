package interviewbit.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

/*
Given an array of integers A of size N in which ith element is the price of the stock on day i.
You can complete atmost B transactions.
Find the maximum profit you can achieve.
NOTE: You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

Problem Constraints
1 <= N <= 500
0 <= A[i] <= 106
0 <= B <= 109

Input Format
The First argument given is the integer array A.
The Second argument is integer B.

Output Format
Return the maximum profit you can achieve by doing atmost B transactions.

Example Input
Input 1:
 A = [2, 4, 1]
 B = 2
Input 2:
 A = [3, 2, 6, 5, 0, 3]
 B = 2

Example Output
Output 1:
 2
Output 2:
 7

Example Explanation
Explanation 1:
 Buy on day 1 (price = 2) and sell on day 2 (price = 4),
 Profit = 4 - 2 = 2
Explanation 2:
 Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6 - 2 = 4.
 Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3 - 0 = 3.
 */
public class BestTimeToBuyAndSellStockAtmostBTimes {
    public static void main(String[] args) {
        System.out.println(new BestTimeToBuyAndSellStockAtmostBTimes().solve(new int[]{2, 4, 8, 6, 7}, 2));
    }

    /*
        2 4 8 6 7
        k = 2

            2   4   8   6   7
        0   0   0   0   0   0
        1   0   2   6   6   6
        2   0   2   6   6   7

        dp table
     */
    public int solve(int[] a, int b) {
        int n = a.length;
        if (b >= n / 2) {
            int ans = 0;
            for (int i = 1; i < n; i++) {
                ans += Math.max(a[i] - a[i - 1], 0);
            }
            return ans;
        }
        int[][] dp = new int[b + 1][n + 1];
        for (int i = 1; i <= b; i++) {
            int md = a[0];
            for (int j = 1; j <= n; j++) {
                // dp[i][j-1] - taking previous value i.e. no transaction
                dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j - 1] + a[j - 1] - md);
                md = Math.min(md, a[j - 1] - dp[i - 1][j]);
            }
        }
        return dp[b][n];
    }
}
