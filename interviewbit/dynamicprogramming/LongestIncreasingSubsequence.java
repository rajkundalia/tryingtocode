package interviewbit.dynamicprogramming;

import java.util.Arrays;
import java.util.List;

/*
Find the longest increasing subsequence of a given array of integers, A.

In other words, find a subsequence of array in which the subsequence's elements are in
strictly increasing order, and in which the subsequence is as long as possible.

In this case, return the length of the longest increasing subsequence.

Problem Constraints
1 <= length(A) <= 2500
0 <= A[i] <= 2500

Input Format
The first and the only argument is an integer array A.

Output Format
Return an integer representing the length of the longest increasing subsequence.

Example Input
Input 1:
 A = [1, 2, 1, 5]
Input 2:
 A = [0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15]

Example Output
Output 1:
 3
Output 2:
 6

Example Explanation
Explanation 1:
 The longest increasing subsequence: [1, 2, 5]
Explanation 2:
 The possible longest increasing subsequences: [0, 2, 6, 9, 13, 15] or [0, 4, 6, 9, 11, 15] or [0, 4, 6, 9, 13, 15]
 */
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        System.out.println(new LongestIncreasingSubsequence().lis(List.of(1, 2, 1, 5)));
    }

    public int lis(final List<Integer> A) {
        int n = A.size();
        int[] ans = new int[n];
        Arrays.fill(ans, 1);
        int sol = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (A.get(i) > A.get(j)) {
                    ans[i] = Math.max(ans[i], 1 + ans[j]);
                }
                if (ans[i] > sol) {
                    sol = ans[i];
                }
            }
        }
        return sol;
    }
}
