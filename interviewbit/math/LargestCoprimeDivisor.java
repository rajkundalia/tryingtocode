package interviewbit.math;

public class LargestCoprimeDivisor {
    public static void main(String[] args) {
        System.out.println(solveLargestCoprimeDivisor(30, 12));
    }

    /*
        We find GCD of A and B.
        Then divide A by that, this would remove all common factors.
        So when there is nothing common between A and B, we get gcd(A, B) == 1.
        At this time, A is the answer.
     */
    public static int solveLargestCoprimeDivisor(int A, int B) {
        while (gcd(A, B) != 1) {
            A /= gcd(A, B);
        }
        return A;
    }

    static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
