package interviewbit.bitmanipulation;

/*
Divide two integers without using multiplication, division and mod operator.
Return the floor of the result of the division.

Example:
5 / 2 = 2
Also, consider if there can be overflow cases. For overflow case, return INT_MAX.
Note: INT_MAX = 2^31 - 1

//https://youtu.be/bdxJHWIyyqI
//Coding Interview Question - Bit Manipulation - Divide Integers Scaler
 */
public class DivideIntegers {
    public static void main(String[] args) {
        System.out.println(divide(15, 2));
    }

    public static int divide(int A, int B) {
        long ans = 0; // quotient
        long temp = 0;
        int sign = 0;
        long a = A;
        long b = B;
        if ((a > 0 && b < 0) || (a < 0 && b > 0)) {
            sign = 1;
        }
        if (a < 0) {
            a = -a;
        }
        if (b < 0) {
            b = -b;
        }
        for (int i = 5; i >= 0; i--) {

            if (temp + (b << i) <= a) {
                temp += b << i;
                ans += 1L << i; // number of times divisor is called to get nearby to dividend
            }
        }
        if (sign == 1) {
            ans = -ans;
        }
        if (ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int) ans;
    }
}
