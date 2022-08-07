package interviewbit.binarysearch;

/*
Implement pow(x, n) % d.
In other words, given x, n and d,

find (x^n % d)
Note that remainders on division cannot be negative. In other words, make sure the answer you return is non negative.

Problem Constraints
-109 <= x <= 109
0 <= n <= 109
1 <= d <= 109

Example Input
x = 2
n = 3
d = 3

Example Output
2

Example Explanation
2^3 % 3 = 8 % 3 = 2.
 */

public class ImplementPowerFunction {
    public static void main(String[] args) {
        System.out.println(pow(2, 4, 3));
    }

    public static int pow(int a, int y, int d) {
        if (a == 0) {
            return 0;
        }
        long res = 1;
        long x = a;
        while (y > 0) {
            if ((y & 1) == 1) {
                res = (res * x) % d;
            }
            y = y >> 1;
            x = (x * x) % d;
        }

        return (int) ((d + res) % d);
    }
}
