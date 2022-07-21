package interviewbit.math;

/*
You are given an integer N and the task is to reverse the digits of the given integer.
Return 0 if the result overflows and does not fit in a 32 bit signed integer

Look at the example for clarification.

Problem Constraints
N belongs to the Integer limits.

Input Format
Input an Integer.

Output Format
Return a single integer denoting the reverse of the given integer.

Example Input
Input 1:
 x = 123
Input 2:
 x = -123

Example Output
Output 1:
 321
Ouput 2:
 -321

Example Explanation
 If the given integer is negative like -123 the output is also negative -321.
 */
public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(reverse(-1234567891));
    }

    public static int reverse(int A) {
        int temp = Math.abs(A);
        int rem = 0;
        long reverse = 0;
        while (temp > 0) {
            rem = temp % 10;
            reverse = (reverse * 10) + rem;
            temp = temp / 10;
        }

        if (A < 0) {
            reverse *= (-1);
        }

        if (reverse >= Integer.MAX_VALUE || reverse <= Integer.MIN_VALUE) {
            return 0;
        }
        return (int) reverse;
    }
}
