package leetcode.topinterview150;

/*
Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
Example 1:

Input: x = 2.00000, n = 10
Output: 1024.00000
Example 2:

Input: x = 2.10000, n = 3
Output: 9.26100
Example 3:

Input: x = 2.00000, n = -2
Output: 0.25000
Explanation: 2^-2 = 1/2^2 = 1/4 = 0.25
 */
public class PowerXN {
    public static void main(String[] args) {
        System.out.println(new PowerXN().myPow(2.1, 3));
    }

    // https://takeuforward.org/data-structure/implement-powxn-x-raised-to-the-power-n/
    public double myPow(double x, int n) {
        double ans = 1.0;
        long nn = n;

        if (nn < 0) {
            nn = -1 * nn;
        }

        while (nn > 0) {
            if (nn % 2 == 1) {
                ans = ans * x;
                nn = nn - 1;
            } else {
                x = x * x;
                nn = nn / 2;
            }
        }

        if (n < 0) {
            ans = 1.0 / ans;
        }
        return ans;
    }
}
