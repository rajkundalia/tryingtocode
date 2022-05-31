package interviewbit;

import java.util.ArrayList;
import java.util.List;

/**
 * Find the contiguous subarray within an array, A of length N which has the largest sum.
 * <p>
 * Input Format:
 * <p>
 * The first and the only argument contains an integer array, A.
 * Output Format:
 * <p>
 * Return an integer representing the maximum possible sum of the contiguous subarray.
 * Constraints:
 * <p>
 * 1 <= N <= 1e6
 * -1000 <= A[i] <= 1000
 * For example:
 * <p>
 * Input 1:
 * A = [1, 2, 3, 4, -10]
 * <p>
 * Output 1:
 * 10
 * <p>
 * Explanation 1:
 * The subarray [1, 2, 3, 4] has the maximum possible sum of 10.
 * <p>
 * Input 2:
 * A = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
 * <p>
 * Output 2:
 * 6
 * <p>
 * Explanation 2:
 * The subarray [4,-1,2,1] has the maximum possible sum of 6.
 */
public class MaxSumContiguousSubarray {
    public static void main(String[] args) {
        System.out.println(solveMaxSumContiguousSubarray(new ArrayList<>(List.of(1, 2, 3, 4, -10))));
        System.out.println(solveMaxSumContiguousSubarray(new ArrayList<>(List.of(-2, 1, -3, 4, -1, 2, 1, -5, 4))));
    }

    private static int solveMaxSumContiguousSubarray(ArrayList<Integer> A) {
        int maxSum = Integer.MIN_VALUE;
        int prefixSum = 0;

        for (int i = 0; i < A.size(); i++) {
            prefixSum += A.get(i);
            if (prefixSum > maxSum) {
                maxSum = prefixSum;
            }
            if (prefixSum < 0) {
                prefixSum = 0;
            }
        }
        return maxSum;
    }
}
