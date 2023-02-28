package interviewbit.dynamicprogramming;

/*
Given a number A, return number of ways you can draw A chords in a circle with 2 x A points such that no 2 chords intersect.

Two ways are different if there exists a chord which is present in one way and not in other.

Return the answer modulo 109 + 7.

Input Format:
The first and the only argument contains the integer A.
Output Format:

Return an integer answering the query as described in the problem statement.
Constraints:
1 <= A <= 1000

Examples:
Input 1:
    A = 1

Output 1:
    1

Explanation 1:
    If points are numbered 1 to 2 in clockwise direction, then different ways to draw chords are:
    {(1-2)} only.
    So, we return 1.

Input 2:
    A = 2

Output 2:
    2

Explanation 2:
    If points are numbered 1 to 4 in clockwise direction, then different ways to draw chords are:
    {(1-2), (3-4)} and {(1-4), (2-3)}.
    So, we return 2.
 */
public class IntersectingChordsInACircle {
    public static void main(String[] args) {
        System.out.println(new IntersectingChordsInACircle().chordCnt(4));
    }

    /*
        logic from: https://youtu.be/qgQg1BcCWBA

        n = 0 -> ways 1 C0
        n = 2 -> ways 1 C1
        n = 4 -> ways 2 C1*C1 + C1*C1 = 2
        n = 6 -> ways 5 C3 = C0*C2 + C1*C1 + C2*C0
        n = 8 -> ways 14 C4 = C0*C3 + C1*C2 + C2*C1 + C3*C0

        here whatever n is given, we need to consider n*2 points for that
        so, n = 4 gives answer 14
     */
    public int chordCnt(int n) {
        long[] dp = new long[n + 1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            int l = 0;
            int r = i - 1;

            while (l <= i - 1) {
                dp[i] = (dp[i] + (dp[l] * dp[r]));
                l++;
                r--;
            }
        }
        return (int) (dp[n])%1000000007;
    }
}
