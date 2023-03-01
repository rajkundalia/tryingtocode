package interviewbit.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
Given a N * 2 array A where (A[i][0], A[i][1]) represents the ith pair.

In every pair, the first number is always smaller than the second number.

A pair (c, d) can follow another pair (a, b) if b < c , similarly in this way a chain of pairs can be formed.

Find the length of the longest chain subsequence which can be formed from a given set of pairs.

Note: A subsequence of a given sequence is a sequence that can be derived from the given sequence by
deleting some or no elements without changing the order of the remaining elements.

Problem Constraints
1 <= N <= 103
1 <= A[i][0] < A[i][1] <= 104

Input Format
First and only argument is an 2D integer array A of size N * 2 representing the N pairs.

Output Format
Return a single integer denoting the length of longest chain subsequence of pairs possible under given constraint.

Example Input
Input 1:
 A = [  [5, 24]
        [39, 60]
        [15, 28]
        [27, 40]
        [50, 90]
     ]
Input 2:
A = [   [10, 20]
        [1, 2]
     ]

Example Output
Output 1:
 3
Output 2:
 1

Example Explanation
Explanation 1:
 Longest chain that can be formed is of length 3, and the chain is [ [5, 24], [27, 40], [50, 90] ]
Explanation 2:
 Longest chain that can be formed is of length 1, and the chain is [ [1, 2] ] or [ [10, 20] ]
 */
public class ChainOfPairs {
    public static void main(String[] args) {
        System.out.println(new ChainOfPairs().solve(new ArrayList<>(List.of(new ArrayList<>(List.of(5, 24)),
                new ArrayList<>(List.of(39, 60)),
                new ArrayList<>(List.of(15, 28)),
                new ArrayList<>(List.of(27, 40)),
                new ArrayList<>(List.of(50, 90))))));
    }

    public int solve(ArrayList<ArrayList<Integer>> A) {
        //dp array to store the length of longest subsequence at dp[index] which ends with pair at index
        int[] dp = new int[A.size()];

        //stores the length of the largest subsequence
        int max = 1;

        //Initializing the array with 1 because the element itself counts as a seq of length 1
        Arrays.fill(dp, 1);

        //Start with index 1 because sequence ending at 0th pair will have only that pair
        for (int i = 1; i < A.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (A.get(j).get(1) < A.get(i).get(0)) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                    if (dp[i] > max) {
                        max = dp[i];
                    }
                }
            }
        }
        //Returns the largest subsequence
        return max;
    }
}
