package interviewbit.dynamicprogramming;

import java.util.Arrays;
import java.util.List;

/*
Given a 1D integer array A of length N, find the length of the longest subsequence which is first
increasing (strictly) and then decreasing (strictly).

Problem Constraints
0 <= N <= 3000
 -107 <= A[i] <= 107

Input Format
The first and the only argument contains an integer array A.

Output Format
Return an integer representing the answer as described in the problem statement.

Example Input
Input 1:
 A = [1, 2, 1]
Input 2:
 A = [1, 11, 2, 10, 4, 5, 2, 1]

Example Output
Output 1:
 3
Output 2:
 6

Example Explanation
Explanation 1:
 [1, 2, 1] is the longest subsequence.
Explanation 2:
 [1 2 10 4 2 1] is the longest subsequence.
 */
//https://takeuforward.org/data-structure/longest-bitonic-subsequence-dp-46/
public class LengthOfLongestSubsequence {
    public static void main(String[] args) {
        System.out.println(new LengthOfLongestSubsequence().longestSubsequenceLength(List.of(1, 11, 2, 10, 4, 5, 2, 1)));
    }

    public int longestSubsequenceLength(final List<Integer> A) {
        int n = A.size();

        if(n == 0) {
            return 0;
        }
        
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];

        Arrays.fill(dp1, 1);
        Arrays.fill(dp2, 1);

        // LIS i.e. increasing order from front of the list
        for (int i = 0; i < n; i++) {
            for (int prevIndex = 0; prevIndex < i; prevIndex++) {
                if (A.get(prevIndex) < A.get(i)) {
                    dp1[i] = Math.max(dp1[i], 1 + dp1[prevIndex]);
                }
            }
        }

        // LIS i.e. increasing order from back of the list
        for (int i = n - 1; i >= 0; i--) {
            for (int prevIndex = n - 1; prevIndex > i; prevIndex--) {
                if (A.get(prevIndex) < A.get(i)) {
                    dp2[i] = Math.max(dp2[i], 1 + dp2[prevIndex]);
                }
            }
        }

        int maxIndex = -1;

        for (int i = 0; i < n; i++) {
            maxIndex = Math.max(maxIndex, dp1[i] + dp2[i] - 1);
        }

        return maxIndex;
    }

}
