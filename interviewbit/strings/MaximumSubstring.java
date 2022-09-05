package interviewbit.strings;

/*
Given a string A consisting of only characters 'a' and 'b'.
Divide the string into substrings of length B.
Find the substring with maximum count of 'a' and return the count.

Note: If the length of the string is not a multiple of B and there are some characters left in the
end consider them also as a substring.

Problem Constraints
1 <= |A| <= 105
Ai = {'a', 'b'}
1 <= B <= 105

Input Format
First argument A is a string.
Second argument is an integer B.

Output Format
Return an integer.

Example Input
Input 1:
A = "baab"
B = 2
Input 2:
A = "bba"
B = 2

Example Output
Output 1:
1
Output 2:
1

Example Explanation
Explanation 1:
The subtrings are "ba" and "ab".
Both have count of 'a' equal to 1.
Explanation 2:
The substrings are "bb" and "a".
"a" has the highest count which is 1.
 */
public class MaximumSubstring {
    public static void main(String[] args) {
        System.out.println(solve("baab", 2));
    }

    public static int solve(String A, int B) {
        int n = A.length();
        int ans = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (i % B == 0) {
                ans = Math.max(ans, count);
                count = 0;
            }
            if (A.charAt(i) == 'a') {
                count++;
            }
        }
        ans = Math.max(ans, count);
        return ans;
    }
}
