package interviewbit.greedyalgorithm;

import java.util.Arrays;

/*
Given an array A, of N integers A.
Return the highest product possible by multiplying 3 numbers from the array.
NOTE: The solution will fit in a 32-bit signed integer.

Problem Constraints
3 <= N <= 5*105

Input Format
The first and the only argument is an integer array A.

Output Format
Return the highest possible product.

Example Input
Input 1:
A = [1, 2, 3, 4]
Input 2:
A = [0, -1, 3, 100, 70, 50]

Example Output
Output 1:
24
Output 1:
350000

Example Explanation
Explanation 1:
2 * 3 * 4 = 24
Explanation 2:
70 * 50 * 100 = 350000
 */
public class HighestProduct {
    public static void main(String[] args) {
        System.out.println(new HighestProduct().maxp3(new int[]{0, -1, 3, 100, 70, 50}));
    }

    /*
        sort and then take higher 3 elements or lowest 2 and highest 1
     */
    public int maxp3(int[] A) {
        Arrays.sort(A);
        int size = A.length;
        int highestThree = A[size - 1] * A[size - 2] * A[size - 3];
        int twoLowestAndOneHighest = A[0] * A[1] * A[size - 1];
        return Math.max(highestThree, twoLowestAndOneHighest);
    }
}
