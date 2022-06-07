package interviewbit.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given an array A of integers, find the maximum of j - i subjected to the constraint of A[i] <= A[j].

Input Format
First and only argument is an integer array A.

Output Format
Return an integer denoting the maximum value of j - i;

Example Input
Input 1:
 A = [3, 5, 4, 2]

Example Output
Output 1: 2

Example Explanation
Explanation 1:
Maximum value occurs for pair (3, 4).
 */
public class MaxDistance {
    public static void main(String[] args) {
        System.out.println(solveMaxDistance(List.of(3, 5, 4, 2)));
    }

    public static int solveMaxDistance(final List<Integer> A) {
        int maxDiff = 0;
        int n = A.size();
        int[] RMax = new int[n];
        int[] LMin = new int[n];

        LMin[0] = A.get(0);

        for (int i = 1; i < n; i++) {
            LMin[i] = Math.min(A.get(i), LMin[i - 1]);
        }

        RMax[n - 1] = A.get(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            RMax[i] = Math.max(A.get(i), RMax[i + 1]);
        }

        int i = 0, j = 0;
        while (j < n && i < n) {
            if (LMin[i] <= RMax[j]) {
                maxDiff = Math.max(maxDiff, j - i);
                j++;
            } else {
                i++;
            }
        }
        return maxDiff;
    }
}
