package interviewbit.dynamicprogramming;

/*
There are A coins (Assume A is even) in a line.
Two players take turns to take a coin from one of the ends of the line until there are no more coins left.
The player with the larger amount of money wins, Assume that you go first.
Return the maximum amount of money you can win.

NOTE:
You can assume that opponent is clever and plays optimally.

Problem Constraints
1 <= length(A) <= 500
1 <= A[i] <= 105

Input Format
The first and the only argument of input contains an integer array A.

Output Format
Return an integer representing the maximum amount of money you can win.

Example Input
Input 1:
 A = [1, 2, 3, 4]
Input 2:
 A = [5, 4, 8, 10]

Example Output
Output 1:
 6
Output 2:
 15

Example Explanation
Explanation 1:

 You      : Pick 4
 Opponent : Pick 3
 You      : Pick 2
 Opponent : Pick 1

Total money with you : 4 + 2 = 6
Explanation 2:
 You      : Pick 10
 Opponent : Pick 8
 You      : Pick 5
 Opponent : Pick 4

Total money with you : 10 + 5 = 15
 */
// Explanation: https://youtu.be/ww4V7vRIzSk
public class CoinsInALine {
    public static void main(String[] args) {
        System.out.println(new CoinsInALine().maxcoin(new int[]{5, 4, 8, 10}));
    }

    public int maxcoin(int[] A) {
        int[][] dp = new int[A.length][A.length];

        for (int g = 0; g < dp.length; g++) {
            for (int i = 0, j = g; j < dp.length; i++, j++) {
                if (g == 0) {
                    dp[i][j] = A[i];
                } else if (g == 1) {
                    dp[i][j] = Math.max(A[i], A[j]);
                } else {
                    // we select i, here then
                    // remaining i+1, j
                    // we select i again, then i+2,j
                    // or if we select j, i+1, j-1
                    int val1 = A[i] + Math.min(dp[i + 2][j], dp[i + 1][j - 1]);

                    // we select j, here then
                    // remaining i, j-1
                    // we select j again, then i,j-2
                    // or if we select i, i+1,j-1
                    int val2 = A[j] + Math.min(dp[i + 1][j - 1], dp[i][j - 2]);

                    int val = Math.max(val1, val2);
                    dp[i][j] = val;
                }
            }
        }
        return dp[0][A.length - 1];
    }
}
