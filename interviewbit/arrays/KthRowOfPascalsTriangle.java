package interviewbit;

import java.util.ArrayList;

/*
Given an index k, return the kth row of the Pascal's triangle.
Pascal's triangle: To generate A[C] in row R, sum up A'[C] and A'[C-1] from previous row R - 1.

Example:

Input : k = 3


Return : [1,3,3,1]

Note: k is 0 based. k = 0, corresponds to the row [1].

Note: Could you optimize your algorithm to use only O(k) extra space?
 */
public class KthRowOfPascalsTriangle {
    public static void main(String[] args) {
        System.out.println(solveKthRowOfPascalsTriangle(3));
    }

    public static ArrayList<Integer> solveKthRowOfPascalsTriangle(int A) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i <= A; i++) {
            result.add(findNCR(A, i));
        }
        return result;
    }

    public static int findNCR(int n, int r) {
        long result = 1;
        r = Math.min(r, n - r);
        for (int i = 1; i <= r; i++) {
            result = result * (n - i + 1) / i;
        }
        return (int) result;
    }
}
