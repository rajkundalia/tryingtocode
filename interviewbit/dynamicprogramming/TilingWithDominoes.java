package interviewbit.dynamicprogramming;

/*
Given an integer A you have to find the number of ways to fill a 3 x A board with 2 x 1 dominoes.
Return the answer modulo 109 + 7 .

NOTE:
See the sample explanation for better understanding.

Problem Constraints
1 <= A <= 105

Input Format
First and only argument is an integer A.

Output Format
Return an integer denoting the number of ways to fill a 3 x A board with 2 x 1 dominoes with modulo 109 + 7.

Example Input
Input 1:
 2
Input 2:
 1

Example Output
Output 1:
 3
Output 2:
 0

Example Explanation
Explanation 1:
 Following are all the 3 possible ways to fill up a 3 x 2 board.

Explanation 2:
 Not a even a single way exists to completely fill the grid of size 3 x 1.
 */
/*
Final Recursive Relations are:
An = An-2 + 2*(Bn-1)
Bn = An-1 + Bn-2

Base Cases:
A0 = 1
A1 = 0
B0 = 0
B1 = 1
https://www.interviewbit.com/problems/tiling-with-dominoes/

Pictorial understanding is important for this
 */
public class TilingWithDominoes {
    public static void main(String[] args) {
        System.out.println(new TilingWithDominoes().solve(2));
    }

    public int solve(int n) {
        int mod = (int) 1e9 + 7;
        int[] A = new int[n + 1];
        int[] B = new int[n + 1];
        A[0] = 1;
        A[1] = 0;
        B[0] = 0;
        B[1] = 1;
        for (int i = 2; i <= n; i++) {
            A[i] = (A[i - 2] % mod + 2 * B[i - 1] % mod) % mod;
            B[i] = (A[i - 1] % mod + B[i - 2] % mod) % mod;
        }
        return A[n] % mod;
    }

}
