package interviewbit.dynamicprogramming;

/*
You are given A eggs, and you have access to a building with B floors from 1 to B.

Each egg is identical in function, and if an egg breaks, you cannot drop it again.

You know that there exists a floor C with 0 <= C <= B  such that any egg dropped at a floor higher than C will break,
and any egg dropped at or below floor C will not break.

Each move, you may take an egg (if you have an unbroken one) and drop it from any floor X (with 1 <= X <= B).

Your goal is to know with certainty what the value of C is.

What is the minimum number of moves that you need to know with certainty what C is, regardless of the initial value of C

Problem Constraints
1 <= A <= 100
1 <= B <= 104

Input Format
First Argument is an integer A denoting number of eggs.
Second Argument is an integer B denoting number of floors.

Output Format
Return an integer denoting the Minimum number of moves.

Example Input
Input 1:
 A = 1
 B = 2
Input 2:
 A = 2
 B = 10

Example Output
Output 1:
 2
Output 2:
 4

Example Explanation
Explanation 1:
 Drop the egg from floor 1.  If it breaks, we know with certainty that F = 0.
 Otherwise, drop the egg from floor 2.  If it breaks, we know with certainty that F = 1.
 If it didn't break, then we know with certainty F = 2.
 Hence, we needed 2 moves in the worst case to know what F is with certainty.
 */
//https://youtu.be/UvksR0hR9nA
public class EggDropProblem {
    public static void main(String[] args) {
        System.out.println(new EggDropProblem().solve(1, 2));
    }

    // n is number of eggs
    // k is number of floors
    public int solve(int n, int k) {
        int[][] dp = new int[n + 1][k + 1];

        // first for loop is for eggs
        // second for loop is for floors
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                if (i == 1) {
                    dp[i][j] = j;
                } else if (j == 1) {
                    dp[i][j] = 1;
                } else {
                    int min = Integer.MAX_VALUE;
                    for (int mj = j - 1, pj = 0; mj >= 0; mj--, pj++) {
                        int v1 = dp[i][mj]; // egg survives
                        int v2 = dp[i - 1][pj]; // egg breaks
                        int val = Math.max(v1, v2);
                        min = Math.min(min, val);
                    }
                    dp[i][j] = min + 1;
                }
            }
        }
        return dp[n][k];
    }
}
