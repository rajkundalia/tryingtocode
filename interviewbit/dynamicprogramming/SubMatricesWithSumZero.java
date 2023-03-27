package interviewbit.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

/*
Given a 2D matrix, find the number non-empty sub matrices, such that the sum of the elements inside the
sub matrix is equal to 0. (note:  elements might be negative).

Example:
Input
-8 5  7
3  7 -8
5 -8  9
Output
2

Explanation
-8 5 7

3 7 -8

5 -8 9

-8 5 7

3 7 -8

5 -8 9
 */
public class SubMatricesWithSumZero {
    public static void main(String[] args) {
        System.out.println(new SubMatricesWithSumZero().solve(new int[][]{
                {-8, 5, 7},
                {3, 7, -8},
                {5, -8, 9}
        }));
//        int arr[] = { 10, 2, -2, -20, 10 };
//        int sum = -10;
//        int n = arr.length;
//        System.out.println(SubMatricesWithSumZero.findSubarraySum(arr, n, sum));
    }

    public int solve(int[][] A) {
        if(A.length == 0 || A[0].length == 0) {
            return 0;
        }
        int T = 0;
        int xlen = A[0].length, ylen = A.length, ans = 0;
        Map<Integer, Integer> res = new HashMap<>();
        for (int[] r : A) {
            for (int j = 1; j < xlen; j++) {
                r[j] += r[j - 1];
            }
        }
        for (int j = 0; j < xlen; j++) {
            for (int k = j; k < xlen; k++) {
                res.clear();
                res.put(0, 1);
                int csum = 0;
                for (int i = 0; i < ylen; i++) {
                    csum += A[i][k] - (j > 0 ? A[i][j - 1] : 0);
                    ans += res.getOrDefault(csum - T, 0);
                    res.put(csum, res.getOrDefault(csum, 0) + 1);
                }
            }
        }
        return ans;
    }

    static int findSubarraySum(int arr[], int n, int sum)
    {
        // HashMap to store number of subarrays
        // starting from index zero having
        // particular value of sum.
        HashMap<Integer, Integer> prevSum = new HashMap<>();
        prevSum.put(0,1);
        int res = 0;

        // Sum of elements so far.
        int currSum = 0;

        for (int i = 0; i < n; i++) {

            // Add current element to sum so far.
            currSum += arr[i];
            //calculate the sum that have to be removed
            //so that we can get the desired sum

            int removeSum=currSum-sum;

            //get count of occurrences of that sum that
            //have to removed and add it to res value
            if (prevSum.containsKey(removeSum))
                res += prevSum.get(removeSum);

            // Add currsum value to count of
            // different values of sum.
            prevSum.put(currSum,prevSum.getOrDefault(currSum,0)+1);
        }

        return res;
    }

}
