package interviewbit.binarysearch;

/*
Given an integer A.
Compute and return the square root of A.
If A is not a perfect square, return floor(sqrt(A)).
DO NOT USE SQRT FUNCTION FROM STANDARD LIBRARY.
NOTE: Do not use sort function from standard library. Users are expected to solve this in O(log(A)) time.

Input Format
The first and only argument given is the integer A.

Output Format
Return floor(sqrt(A))

Example Input
Input 1:
 11
Input 2:
 9


Example Output
Output 1:
 3
Output 2:
 3

Example Explanation
Explanation:
 When A = 11 , square root of A = 3.316. It is not a perfect square so we return the floor which is 3.
 When A = 9 which is a perfect square of 3, so we return 3.
 */
public class SquareRootOfInteger {
    public static int sqrt(int a) {
        long low = 1;
        long high = a;
        while (low <= high) {
            long mid = (high + low) / 2;
            if (mid * mid == a) {
                return (int) mid;
            }
            if (mid * mid > a) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        // if we did not find an exact match the high variable is smaller than low
        // and therefore contains the floor value of sqrt.
        return (int) high;
    }

    public static void main(String[] args) {
        System.out.println(sqrt(11));
    }
}
