package interviewbit.dynamicprogramming;

/*
You are climbing a stair case and it takes A steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Input Format:
The first and the only argument contains an integer A, the number of steps.
Output Format:
Return an integer, representing the number of ways to reach the top.

Constrains:
1 <= A <= 36

Example :
Input 1:
A = 2
Output 1:2
Explanation 1:
[1, 1], [2]

Input 2:
A = 3
Output 2:3
Explanation 2:
[1 1 1], [1 2], [2 1]
 */
public class Stairs {
    public static void main(String[] args) {
        System.out.println(new Stairs().climbStairs(2));
    }

    public int climbStairs(int A) {

        int[] dp = new int[A + 1];
        dp[0] = 1; // 1 way to climb 0 steps
        dp[1] = 1; // 1 way to climb 1 step

        for (int i = 2; i <= A; i++) {
            dp[i] = dp[i - 1] + dp[i - 2]; // climb either 1 or 2 steps
        }

        return dp[A];
    }
}
