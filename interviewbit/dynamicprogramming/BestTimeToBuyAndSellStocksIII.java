package interviewbit.dynamicprogramming;

/*
Say you have an array, A, for which the ith element is the price of a given stock on day i.
Design an algorithm to find the maximum profit. You may complete at most 2 transactions.
Return the maximum possible profit.
Note: You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

Problem Constraints
1 <= length(A) <= 7e5
1 <= A[i] <= 1e7

Input Format
The first and only argument is an integer array, A.

Output Format
Return an integer, representing the maximum possible profit.

Example Input
Input 1:
    A = [1, 2, 1, 2]
Input 2:
    A = [7, 2, 4, 8, 7]
Example Output
Output 1:
    2
Output 2:
    6
Example Explanation
Explanation 1:
    Day 0 : Buy
    Day 1 : Sell
    Day 2 : Buy
    Day 3 : Sell

Explanation 2:
    Day 1 : Buy
    Day 3 : Sell
 */
public class BestTimeToBuyAndSellStocksIII {
    public static void main(String[] args) {
        System.out.println(new BestTimeToBuyAndSellStocksIII().maxProfit(new int[]{7, 2, 4, 8, 7}));
    }

    public int maxProfit(final int[] arr) {
        int k = 2;
        int n = arr.length;
        if(n == 0) {
            return 0;
        }
        int[][] dp = new int[k + 1][n];

        // rows are transactions, so outer loop is t for transaction numbers
        for (int t = 1; t <= k; t++) {
            int max = Integer.MIN_VALUE;
            // columns are d for days
            for (int d = 1; d < n; d++) {
                if (dp[t - 1][d - 1] - arr[d - 1] > max) {
                    max = dp[t - 1][d - 1] - arr[d - 1];
                }
                if (max + arr[d] > dp[t][d - 1]) {
                    dp[t][d] = max + arr[d];
                } else {
                    dp[t][d] = dp[t][d - 1];
                }
            }
        }
        return dp[k][n - 1];
    }
}
