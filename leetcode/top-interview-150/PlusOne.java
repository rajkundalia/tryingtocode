package leetcode.topinterview150;

import java.util.Arrays;

/*
You are given a large integer represented as an integer array digits, where each digits[i] is the
ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order.
The large integer does not contain any leading 0's.

Increment the large integer by one and return the resulting array of digits.

Example 1:

Input: digits = [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Incrementing by one gives 123 + 1 = 124.
Thus, the result should be [1,2,4].
Example 2:

Input: digits = [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
Incrementing by one gives 4321 + 1 = 4322.
Thus, the result should be [4,3,2,2].
Example 3:

Input: digits = [9]
Output: [1,0]
Explanation: The array represents the integer 9.
Incrementing by one gives 9 + 1 = 10.
Thus, the result should be [1,0].
 */
public class PlusOne {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new PlusOne().plusOne(new int[]{1, 2, 3})));
    }

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
                // starting from extreme right--> if array[i] is less than 9 means can be added with 1
                // i.e. [ 5,8 ]-->[ 5,9 ] or
                //      [ 9,4 ]-->[ 9,5 ] or
                //      [ 6,0 ]-->[ 6,1 ]
                // and will directly return array
            }
            digits[i] = 0;
            // if array[i] is not less than 9, means it have to be 9 only then digit is changed to 0,
            // and we again revolve around loop to check for number if less than 9 or not
            // i.e. [ 5,9 ]-->[ 5,0 ]-loop->[ 6,0 ] or
            //      [ 1,9,9 ]-->[ 1,9,0 ]-loop->[ 1,0,0 ]-loop->[ 2,0,0 ]
            // and will directly return array
        }

        // if all number inside array are 9
        // i.e. [ 9,9,9,9 ] than according to above loop it will become [ 0,0,0,0 ]
        // but we have to make it like this [ 9,9,9,9 ]-->[ 1,0,0,0,0 ]

        // to make like above we need to make new array of length--> n+1
        // by default new array values are set to -->0 only
        // thus just changed first value of array to 1 and return the array

        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
