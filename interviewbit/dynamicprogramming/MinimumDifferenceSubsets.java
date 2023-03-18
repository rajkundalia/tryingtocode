package interviewbit.dynamicprogramming;

import java.util.Arrays;

/*
Given an integer array A containing N integers.
You need to divide the array A into two subsets S1 and S2 such that the absolute difference
between their sums is minimum.
Find and return this minimum possible absolute difference.

NOTE:
Subsets can contain elements from A in any order (not necessary to be contiguous).
Each element of A should belong to any one subset S1 or S2, not both.
It may be possible that one subset remains empty.

Problem Constraints
1 <= N <= 100
1 <= A[i] <= 100

Input Format
First and only argument is an integer array A.

Output Format
Return an integer denoting the minimum possible difference among the sums of two subsets.

Example Input
Input 1:
 A = [1, 6, 11, 5]

Example Output
Output 1:
 1

Example Explanation
Explanation 1:
 Subset1 = {1, 5, 6}, sum of Subset1 = 12
 Subset2 = {11}, sum of Subset2 = 11
 */
public class MinimumDifferenceSubsets {
    public static void main(String[] args) {
        //System.out.println(new MinimumDifferenceSubsets().solve(new int[]{1, 6, 5, 11}));
        System.out.println(new MinimumDifferenceSubsets().solve(new int[]{1, 2, 3}));
    }

    public int solve(int[] A) {
        int sum = Arrays.stream(A).sum();
        int n = A.length + 1;

        boolean[] dp = new boolean[sum + 1];

        for (int i = 1; i < n; i++) {
            dp[0] = true;
            for (int j = sum; j >= 1; j--) {
                if (A[i - 1] <= j) {
                    dp[j] = dp[j] || dp[j - A[i-1]];
                } else {
                    break;
                }
            }
        }

        int minAns = Integer.MAX_VALUE;

        for (int i = 0; i <= sum / 2; i++) {
            if (dp[i] == true) {
                minAns = Math.min(minAns, sum - 2 * i);
            }
        }
        return minAns;
    }
}
