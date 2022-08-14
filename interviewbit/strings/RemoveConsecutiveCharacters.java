package interviewbit.strings;

/*
Given a string A and integer B, remove all consecutive same characters that have length exactly B.

Problem Constraints
1 <= |A| <= 100000
1 <= B <= |A|

Input Format
First Argument is string A.
Second argument is integer B.

Output Format
Return a string after doing the removals.

Example Input
Input 1:
A = "aabcd"
B = 2
Input 2:
A = "aabbccd"
B = 2

Example Output
Output 1:
 "bcd"
Output 2:
 "d"

Example Explanation
Explanation 1:
 "aa" had length 2.
Explanation 2:
 "aa", "bb" and "cc" had length of 2.
 */
public class RemoveConsecutiveCharacters {
    public static void main(String[] args) {
        System.out.println(solve("aabbccd", 2));
    }

    public static String solve(String A, int B) {
        int n = A.length();
        if (n == B) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        String temp = "";
        int i = 0;
        int j = 0;
        while (i < n && j < n) {
            i = j;
            while (j < n && A.charAt(i) == A.charAt(j)) {
                temp += A.charAt(j);
                j++;
            }
            if (temp.length() != B) {
                result.append(temp);
            }
            temp = "";
        }
        return result.toString();
    }
}
