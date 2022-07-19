package interviewbit.math;

/*
Determine whether an integer is a palindrome. Do this without extra space.
A palindrome integer is an integer x for which reverse(x) = x where reverse(x) is x with its digit reversed.
Negative numbers are not palindromic.

Example :
Input : 12121
Output : 1

Input : 123
Output : 0
 */
public class PalindromeInteger {
    public static void main(String[] args) {
        System.out.println(isPalindrome(12121));
    }

    public static int isPalindrome(int A) {
        int temp = A;
        if (A < 0) {
            return 0;
        }
        int r = 0, sum = 0;
        while (A > 0) {
            r = A % 10;
            sum = (sum * 10) + r;
            A = A / 10;
        }
        if (temp == sum) {
            return 1;
        } else {
            return 0;
        }
    }
}
