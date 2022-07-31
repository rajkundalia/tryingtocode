package interviewbit.math;

/*
Given a large number represent in the form of an integer array A, where each element is a digit.
You have to find whether there exists any permutation of the array A such that the number becomes divisible by 60.
Return 1 if it exists, 0 otherwise.

Problem Constraints
1 <= |A| <= 105
0 <= Ai <= 9

Input Format
The first argument is an integer array A.

Output Format
Return a single integer '1' if there exists a permutation, '0' otherwise.

Example Input
Input 1:
A = [0, 6]
Input 2:
A = [2, 3]

Example Output
Output 1:
1
Output 2:
0

Example Explanation
Explanation 1:
We can rearrange the digits to form 60, which is divisible by 60.
Explanation 2:

There are only two possible permutations: [23, 32].
Both of them are not divisible by 60.
 */
public class DivisibleBy60 {
    public static void main(String[] args) {
        System.out.println(divisibleBy60(new int[]{0, 6}));
    }

    // number has to be divible by 3,4,5
    /*
    For a number to be divisible by a composite number, it should be divisible
by the individual prime numbers raised to their highest powers.
Here, 60 = 4 * 5 * 3.
Now, we have to make sure that the number is divisible by 3, 4, 5.
For, a number to be divisible by 5, the last digit should be either 0 or 5.
For, a number to be divisible by 4, the last two digits should be divisible by 4.
Hence, here for a number to be divisble by 4 & 5, the last digits should be 0,
and the second last digits should be even.

Next, for a number to be divisible by 3, the sum of digits should be divisible by 3.
Hence, if the given array sum is divisible by 3 and contains 0 and an another even digit,
then there exists a permutation which is divisible by 60.
     */
    public static int divisibleBy60(int[] A) {
        if (A.length == 1 && A[0] == 0) {
            return 1;
        }
        boolean f0 = false, f2 = false;
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            if (A[i] == 0) {
                f0 = true;
            } else if (A[i] % 2 == 0) {
                f2 = true;
            }
        }
        if (sum % 3 == 0 && f0 && f2) {
            return 1;
        } else {
            return 0;
        }
    }
}
