package leetcode.topinterview150;

/*
Given a non-negative integer x, return the square root of x rounded down to the nearest integer.
The returned integer should be non-negative as well.

You must not use any built-in exponent function or operator.

For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.

Example 1:

Input: x = 4
Output: 2
Explanation: The square root of 4 is 2, so we return 2.
Example 2:

Input: x = 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.
 */
public class Sqrt {
    public static void main(String[] args) {
        System.out.println(new Sqrt().mySqrt(4));
    }

    public int mySqrt(int x) {
        if (x == 0 || x == 1) return x;

        // Binary Search
        int left = 0;
        int right = x;
        while (left < right) {
            // mid = (left + right) / 2 can overflow if right > Integer.MAX_VALUE - left
            int mid = left + (right - left) / 2;

            // same thing here , mid * mid > x can overflow. replace by mid > x / mid
            if (mid > x / mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
                // if mid * mid < x but (mid + 1) * (mid + 1) > x then mid was the right answer
                if (left > x / left) {
                    return mid;
                }
            }
        }

        return left;
    }
}
