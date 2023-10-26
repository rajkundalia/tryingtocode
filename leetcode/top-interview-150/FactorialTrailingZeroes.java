package leetcode.topinterview150;

/*
Given an integer n, return the number of trailing zeroes in n!.

Note that n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1.

Example 1:

Input: n = 3
Output: 0
Explanation: 3! = 6, no trailing zero.
Example 2:

Input: n = 5
Output: 1
Explanation: 5! = 120, one trailing zero.
Example 3:

Input: n = 0
Output: 0
 */
public class FactorialTrailingZeroes {
    public static void main(String[] args) {
        System.out.println(new FactorialTrailingZeroes().trailingZeroes(6));
    }

    /*
        Intuition
        The intuition behind the program is based on the observation that trailing zeros in a factorial come
        from the product of the factors 2 and 5. Since the number of factors of 2 is always greater than the number
        of factors of 5 in any given number, counting the number of factors of 5 is enough to calculate the number of
        trailing zeros in a factorial. Therefore, the program counts the number of factors of 5 in n and its powers to
        calculate the number of trailing zeros in n!.

        Approach
        The program uses a while loop to iterate over n and its powers of 5. In each iteration, the program adds the
        number of factors of 5 in the current value of n to a counter c. The program then divides n by 5 to get the
        next smaller value to check. This process continues until n is less than 5.
     */
    public int trailingZeroes(int n) {
        int trailingZeroes = 0;
        while(n > 4) { // > 4 because 1st trailing zero starts from 5!
            trailingZeroes += (n / 5);
            n /= 5;
        }
        return trailingZeroes;
    }
}
