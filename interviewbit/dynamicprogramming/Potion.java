package interviewbit.dynamicprogramming;

/*
You are given N potions arranged in a row in the form of an array A
Each potion has one of 100 different colors (colors have numbers from 0 to 99)
You need to mix all these potions together.

At each step, you are going to take two potions that stand next to each other and mix them together,
and put the resulting mixture in their place.

When mixing two mixtures of colors X and Y, the resulting mixture will have the color (X + Y) mod 100.

Also, there will be some smoke in the process.
The amount of smoke generated when mixing two mixtures of colors X and Y is X * Y.

Find out what is the minimum amount of smoke that you can get when mixing all the potions together.

Problem Constraints
1 <= N <= 100
0 <= Ai <= 99

Input Format
The first argument is the integer array A.

Output Format
Return a single integer denoting the minimum amount of smoke.

Example Input
Input 1:
A = [2, 3]
Input 2:
A = [2, 3, 4, 5]

Example Output
Output 1:
6
Output 2:
71

Example Explanation
Explanation 1:
There are only two potions given. Upon mixing them, we get 2 * 3 = 6 amounts of smoke.
Explanation 2:
Out of all the possible order of operations of mixing the given potions, the minimum amount of smoke you can get is 71.
 */
public class Potion {
    public static void main(String[] args) {
        System.out.println(new Potion().minSmoke(new int[]{2, 3, 4, 5}));
    }

    public int minSmoke(int[] A) {

        int n = A.length;
        long[][] sum = new long[n][n];
        long[][] dp = new long[n][n];
        for (int i = 0; i < n; i++) {
            sum[i][i] = A[i];
        }

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i < n - len + 1; i++) {
                int j = i + len - 1;
                long min = Integer.MAX_VALUE;
                for (int k = i; k <= j - 1; k++) {
                    long temp = dp[i][k] + dp[k + 1][j] + (sum[i][k] * sum[k + 1][j]);
                    if (temp < min) {
                        sum[i][j] = (sum[i][k] + sum[k + 1][j]) % 100;
                        min = temp;
                        dp[i][j] = min;
                    }
                }
            }
        }
        return (int) dp[0][n - 1];

    }
}
