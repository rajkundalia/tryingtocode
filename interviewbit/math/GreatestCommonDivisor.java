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
       If we examine the Euclidean Algorithm we can see that it makes use of the following properties:
       GCD(A,0) = A
       GCD(0,B) = B
       If A = B*Q + R and B≠0 then GCD(A,B) = GCD(B,R) where Q is an integer, R is an integer between 0 and B-1
     */
    public static int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
    }
}
