package leetcode.topinterview150;

/*
Given two integers left and right that represent the range [left, right], return the bitwise AND of all numbers
in this range, inclusive.

Example 1:

Input: left = 5, right = 7
Output: 4
Example 2:

Input: left = 0, right = 0
Output: 0
Example 3:

Input: left = 1, right = 2147483647
Output: 0
 */
public class BitwiseANDOfNumbersRange {
    public static void main(String[] args) {
        System.out.println(new BitwiseANDOfNumbersRange().rangeBitwiseAnd(5, 7));
    }

    /*
    The trick here is that :
    Bitwise-AND of any two numbers will always produce a number less than or equal to the smaller number.

    Consider the following example:

									12 ---- 1100
									11 ---- 1011
									10 ---- 1010
									9  ---- 1001
									8  ---- 1000
									7  ---- 0111
									6  ---- 0110
									5  ---- 0101

    Desired Range: [5,12]

    Starting from 12, the loop will first do
    12 & 11 = 8

    Next iteration, the loop will do
    8 & 7 = 0

    why did we skip and'ing of 10,9? Because even if we did so, the result would eventually be and'ed with 8
    whose value would be lesser than equal to 8.

    Hence, you start from the range end and keep working your way down the range till you reach the start.

     while(n>m)
               n = n & n-1;
     return m&n;
     */
    public int rangeBitwiseAnd(int left, int right) {
        while(right > left) {
            right = right & (right - 1);
        }
        return right & left;
    }
}
