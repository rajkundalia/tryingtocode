package interviewbit.math;

/*
Given a positive integer which fits in a 32 bit signed integer, find if it can be expressed as A^P where
P > 1 and A > 0. A and P both should be integers.

Example:
Input : 4
Output : True
as 2^2 = 4.
 */
public class PowerOfTwoIntegers {
    public static void main(String[] args) {
        System.out.println(isPower(125));
    }

    /*
        when x^y = A, we can rearrange y*log(X) = log(A) and then y = log(A) / log(x). This is a logarithm property to
        bring power in front.

        The minimum value y can take is 2. This means that the maximum value x can take is sqrt(A)!
        We don’t even need to iterate x in [1, A). We can do that in [1, sqrt(A)]. You can understand
        this by using A = 25.
     */
    public static int isPower(int A) {
        for (int x = 1; x <= Math.sqrt(A); x++) {
            int y = (int) (Math.log(A) / Math.log(x));
            if (Math.pow(x, y) == A) {
                return 1;
            }
        }
        return 0;
    }
}
