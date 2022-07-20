package interviewbit.math;

import java.util.List;

/*
Hamming distance between two non-negative integers is defined as the number of positions at which
the corresponding bits are different.
Given an array A of N non-negative integers, find the sum of hamming distances of all pairs of integers in the array.
Return the answer modulo 1000000007.

Problem Constraints
1 <= |A| <= 200000
1 <= A[i] <= 109

Input Format
First and only argument is array A.

Output Format
Return one integer, the answer to the problem.

Example Input
Input 1:
 A = [1]
Input 2:
 A = [2, 4, 6]

Example Output
Output 1:
 0
Output 2:
 8

Example Explanation
Explanation 1:
 No pairs are formed.
Explanation 2:

 We return, f(2, 2) + f(2, 4) + f(2, 6) + f(4, 2) + f(4, 4) + f(4, 6) + f(6, 2) + f(6, 4) + f(6, 6) = 8
 */
public class SumOfPairwiseHammingDistance {
    public static void main(String[] args) {
        System.out.println(hammingDistance(new int[]{2, 4, 6}));
    }

    /*
        The logic is something like for 2,4,6
        123 -> Bit Number

        010
        100
        110

        All bits are same for 3rd bit.
        For 2nd bit: 4 pairs
        2,4::4,2
        4,6::6,4

        For 1st bit: 4 pairs
        2,4::4,2
        2,6::6,2

        8 would be the answer

        Logic: If we count the number of 1s and 0s and multiply them and into 2 (2,4::4,2 is also possible),
        we will get the pairs.

        To find the number of 1s and 0s, we use left shift on 1 so that logical and(&) operation can be performed to
        find count.
     */
    public static int hammingDistance(final int[] A) {
        long n = A.length;
        long ans = 0;

        for (int i = 0; i < 32; i++) {
            int countOne = 0;
            for (int j = 0; j < n; j++) {
                if ((A[j] & (1 << i)) != 0) {
                    countOne++;
                }
            }
            ans += countOne * (n - countOne) * 2;
        }
        return (int) (ans % 1000000007);
    }
}
