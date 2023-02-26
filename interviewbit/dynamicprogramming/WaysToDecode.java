package interviewbit.dynamicprogramming;

/*
A message containing letters from A-Z is being encoded to numbers using the following mapping:
 'A' -> 1
 'B' -> 2
 ...
 'Z' -> 26
Given an encoded message A containing digits, determine the total number of ways to decode it modulo 109 + 7.

Problem Constraints
1 <= |A| <= 105

Input Format
The first and the only argument is a string A.

Output Format
Return a single integer denoting the total number of ways to decode it modulo 109 + 7.

Example Input
Input 1:
 A = "8"
Input 2:
 A = "12"

Example Output
Output 1:
 1
Output 2:
 2

Example Explanation
Explanation 1:
 Given encoded message "8", it could be decoded as only "H" (8).
 The number of ways decoding "8" is 1.
Explanation 2:
 Given encoded message "12", it could be decoded as "AB" (1, 2) or "L" (12).
 The number of ways decoding "12" is 2.
 */
public class WaysToDecode {
    public static void main(String[] args) {
        System.out.println(new WaysToDecode().numDecodings("1213"));
    }

    public int numDecodings(String A) {

        if (A.length() == 0 || A.charAt(0) == '0') {
            return 0;
        }

        int n = A.length();
        int[] dp = new int[n + 1];

        dp[0] = 1; // this is for if there are no characters, so we can decode it only in 1 way
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            if (A.charAt(i - 1) >= '1' && A.charAt(i - 1) <= '9') {
                dp[i] = dp[i - 1];
            }
            if ((A.charAt(i - 2) == '1') || A.charAt(i - 2) == '2' && (A.charAt(i - 1) >= '0' && A.charAt(i - 1) <= '6')) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n]% 1000000007;
    }
}
