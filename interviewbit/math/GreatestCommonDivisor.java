package interviewbit.math;

/*
Given 2 non negative integers m and n, find gcd(m, n)
GCD of 2 integers m and n is defined as the greatest integer g such that g is a divisor of both m and n.
Both m and n fit in a 32 bit signed integer.
Example
m : 6
n : 9

GCD(m, n) : 3
 */
public class GreatestCommonDivisor {
    public static void main(String[] args) {
        System.out.println(gcd1(9, 6));
        System.out.println(gcd(9, 6));
    }

    public static int gcd1(int A, int B) {
        while (A != B) {
            if (A > B) {
                A -= B;
            } else {
                B -= A;
            }
        }
        return A;
    }

    /*
    Basic Euclidean Algorithm for GCD: The algorithm is based on the below facts.

    If we subtract a smaller number from a larger one (we reduce a larger number), GCD doesn’t change.

    So if we keep subtracting repeatedly the larger of two, we end up with GCD.
    Now instead of subtraction, if we divide the smaller number, the algorithm stops when we find the remainder 0.
    Below is a recursive function to evaluate gcd using Euclid’s algorithm.
     */
    public static int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
    }
}
