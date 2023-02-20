package interviewbit.dynamicprogramming;

/*
Given A, B, C, find whether C is formed by the interleaving of A and B.

Input Format:*

The first argument of input contains a string, A.
The second argument of input contains a string, B.
The third argument of input contains a string, C.
Output Format:

Return an integer, 0 or 1:
    => 0 : False
    => 1 : True
Constraints:

1 <= length(A), length(B), length(C) <= 150
Examples:

Input 1:
    A = "aabcc"
    B = "dbbca"
    C = "aadbbcbcac"

Output 1:
    1

Explanation 1:
    "aa" (from A) + "dbbc" (from B) + "bc" (from A) + "a" (from B) + "c" (from A)

Input 2:
    A = "aabcc"
    B = "dbbca"
    C = "aadbbbaccc"

Output 2:
    0

Explanation 2:
    It is not possible to get C by interleaving A and B.
 */
//https://youtu.be/U49f4WpAhV4
public class InterleavingStrings {
    public static void main(String[] args) {
        System.out.println(new InterleavingStrings().isInterleave("aabcc", "dbbca", "aadbbbaccc"));
        System.out.println(new InterleavingStrings().isInterleave("aabcc", "dbbca", "aadbbcbcac"));
    }

    public int isInterleave(String A, String B, String C) {
        int a = A.length();
        int b = B.length();
        int c = C.length();

        if (a + b != c) {
            return 0;
        }

        int[][] dp = new int[a + 1][b + 1];

        dp[0][0] = 1;

        // 1st column i.e. A is empty
        for (int i = 1; i < dp.length; i++) {
            if (C.charAt(i - 1) == A.charAt(i - 1)) {
                dp[i][0] = dp[i - 1][0];
            }
        }

        // 1st row i.e. B is empty
        for (int i = 1; i < dp[0].length; i++) {
            if (C.charAt(i - 1) == B.charAt(i - 1)) {
                dp[0][i] = dp[0][i - 1];
            }
        }

        for (int i = 1; i <= a; i++) {
            for (int j = 1; j <= b; j++) {
                boolean b1 = C.charAt(i + j - 1) == A.charAt(i - 1);
                boolean b2 = C.charAt(i + j - 1) == B.charAt(j - 1);
                if (b1 && b2) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                } else if (b1) {
                    dp[i][j] = dp[i - 1][j];
                } else if (b2) {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }

        return dp[a][b];
    }
}
