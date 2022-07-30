package interviewbit.math;

/*
Given a range [A, B], find sum of integers divisible by 7 in this range.
Problem Constraints
1 <= A <= B <= 109

Input Format
First argument is an integer A.
Second argument is an integer B.

Output Format
Return an integer.

Example Input
Input 1:
A = 1
B = 7
Input 2:
A = 99
B = 115

Example Output
Output 1:
7
Output 2:
217

Example Explanation
Explanation 1:
Integers divisible by 7 in given range are {7}.
Explanation 2:
Integers divisible by 7 in given range are {105, 112}.
 */
public class SumOfMultiplesOf7 {
    public static void main(String[] args) {
        System.out.println(solveSumOfMultiplesOf7(7, 14));
        System.out.println(sumDivisibles(7, 14, 7));
    }

    public static long solveSumOfMultiplesOf7(int A, int B) {
        long x = A / 7;
        if (A % 7 == 0) x--; // this is done so that if A is a multiple of 7, it does not get excluded.
        long y = B / 7;
        long sum = y * (y + 1) / 2 - x * (x + 1) / 2;
        return sum * 7;
    }

    /*
        More information:
        https://www.geeksforgeeks.org/sum-of-all-numbers-in-the-given-range-which-are-divisible-by-m/
        https://www.geeksforgeeks.org/count-numbers-divisible-m-given-range/
     */

    // Function to find the largest number
    // smaller than or equal to N
    // that is divisible by K
    static int findSmallNum(int N, int K) {
        // Finding the remainder when N is
        // divided by K
        int rem = N % K;

        // If the remainder is 0, then the
        // number itself is divisible by K
        if (rem == 0)
            return N;
        else

            // Else, then the difference between
            // N and remainder is the largest number
            // which is divisible by K
            return N - rem;
    }

    // Function to find the smallest number
    // greater than or equal to N
    // that is divisible by K
    static int findLargeNum(int N, int K) {
        // Finding the remainder when N is
        // divided by K
        int rem = (N + K) % K;

        // If the remainder is 0, then the
        // number itself is divisible by K
        if (rem == 0)
            return N;
        else

            // Else, then the difference between
            // N and remainder is the largest number
            // which is divisible by K
            return N + K - rem;
    }

    // Function to find the sum of numbers
    // divisible by M in the given range
    static int sumDivisibles(int A, int B, int M) {
        // Variable to store the sum
        int first = findSmallNum(A, M);
        int last = findLargeNum(B, M);

        // To bring the smallest and largest
        // numbers in the range [A, B]
        if (first < A)
            first += M;

        if (last > B)
            first -= M;

        // To count the number of terms in the AP
        // https://www.geeksforgeeks.org/count-numbers-divisible-m-given-range/
        int n = (B / M) - (A - 1) / M;

        // Sum of n terms of an AP
        return n * (first + last) / 2;
    }
}
