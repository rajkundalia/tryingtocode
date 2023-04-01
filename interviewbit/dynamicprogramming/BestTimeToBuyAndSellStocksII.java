package interviewbit.dynamicprogramming;

/*
Say you have an array, A, for which the ith element is the price of a given stock on day i.
Design an algorithm to find the maximum profit.
You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).
However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

Problem Constraints
0 <= len(A) <= 1e5
1 <= A[i] <= 1e7

Input Format
The first and only argument is an array of integers, A.
Output Format
Return an integer, representing the maximum possible profit.
Example Input
Input 1:
    A = [1, 2, 3]
Input 2:
    A = [5, 2, 10]

Example Output
Output 1:
    2
Output 2:
    8

Example Explanation
Explanation 1:
    => Buy a stock on day 0.
    => Sell the stock on day 1. (Profit +1)
    => Buy a stock on day 1.
    => Sell the stock on day 2. (Profit +1)

Overall Profit = 2

Explanation 2:
    => Buy a stock on day 1.
    => Sell the stock on on day 2. (Profit +8)

Overall profit = 8
 */
public class BestTimeToBuyAndSellStocksII {
    public static void main(String[] args) {
        System.out.println(new BestTimeToBuyAndSellStocksII().maxProfit(new int[]{1, 2, 3}));
    }

    // buy when current value is local minimum and sell when current value is local maximum
    // local minimum means both side values are higher
    // local maximum means both side values are lower
    public int maxProfit(final int[] A) {
        int profit = 0;

        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]) {
                profit += (A[i] - A[i-1]);
            }
        }
        return profit;
    }
}
