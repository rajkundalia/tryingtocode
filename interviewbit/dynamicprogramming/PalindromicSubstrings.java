package interviewbit.dynamicprogramming;

/*
Given a string A consisting of only lowercase English letters.
Return the number of substrings of A which are palindrome.

Problem Constraints
1 <= A <= 103

Input Format
The first and only argument is a string A.

Output Format
Return an integer.

Example Input
Input 1:
A = "aba"
Input 2:
A = "abcd"

Example Output
Output 1:
4
Output 2:
4

Example Explanation
Explanation 1:
The plaindrome substrings are "a", "b", "a" and "aba".
Explanation 2:

The plaindrome substrings are "a", "b", "c" and "d".
 */
public class PalindromicSubstrings {
    public static void main(String[] args) {
        System.out.println(new PalindromicSubstrings().solve("aba"));
    }

    public int solve(String A) {
        int n = A.length();
        int[] dp = new int[n];

        dp[0] = 1;

        for (int i = 1; i < n; i++) {
            int count = 0;
            for (int j = 0; j <= i; j++) {
                if (isPalindrome(A, i, j)) {
                    count++;
                }
            }
            dp[i] = dp[i - 1] + count;
        }
        return dp[n - 1];
    }

    private boolean isPalindrome(String a, int i, int j) {
        while (i > j) {
            if (a.charAt(i) != a.charAt(j)) {
                return false;
            }
            i--;
            j++;
        }
        return true;
    }
}
