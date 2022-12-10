package interviewbit.hashing;

import java.util.HashSet;
import java.util.Set;

/*
Given a string A consisting of lowercase characters.
Check if characters of the given string can be rearranged to form a palindrome.
Return 1 if it is possible to rearrange the characters of the string A such that it becomes a palindrome else return 0.

Problem Constraints
1 <= |A| <= 105
A consists only of lower-case characters.

Input Format
First argument is an string A.

Output Format
Return 1 if it is possible to rearrange the characters of the string A such that it becomes a palindrome else return 0.

Example Input
Input 1:
 A = "abcde"
Input 2:
 A = "abbaee"
Example Output
Output 1:
 0
Output 2:
 1
Example Explanation
Explanation 1:
 No possible rearrangement to make the string palindrome.
Explanation 2:
 Given string "abbaee" can be rearranged to "aebbea" to form a palindrome.
 */
public class CheckPalindrome {
    public static void main(String[] args) {
        System.out.println(solve("abbaee"));
    }

    public static int solve(String A) {
        if (A.length() == 0) {
            return 0;
        }
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < A.length(); i++) {
            char c = A.charAt(i);
            if (!set.contains(c)) {
                set.add(c);
            } else {
                set.remove(c);
            }
        }

        if (A.length() % 2 == 0 && set.isEmpty()) {
            return 1;
        }
        if (A.length() % 2 != 0 && set.size() == 1) {
            return 1;
        }
        return 0;
    }
}
