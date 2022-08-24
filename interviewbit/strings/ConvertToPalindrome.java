package interviewbit.strings;

/*
Given a string A consisting only of lowercase characters, we need to check whether it is possible to make this string a
palindrome after removing exactly one character from this.

If it is possible then return 1 else return 0.

Problem Constraints
3 <= |A| <= 105
 A[i] is always a lowercase character.

Input Format
First and only argument is an string A.

Output Format
Return 1 if it is possible to convert A to palindrome by removing exactly one character else return 0.

Example Input
Input 1:
 A = "abcba"
Input 2:
 A = "abecbea"

Example Output
Output 1:
 1
Output 2:
 0

Example Explanation
Explanation 1:
 We can remove character ‘c’ to make string palindrome
Explanation 2:
 It is not possible to make this string palindrome just by removing one character
 */
public class ConvertToPalindrome {
    public static void main(String[] args) {
        System.out.println(solve("phmjjmap"));
        //qifjhwvhvohmnnibd
    }

    public static int solve(String A) {
        int n = A.length();
        int start = 0;
        int end = n - 1;
        boolean check = false;
        while (start < end) {
            if (A.charAt(start) == A.charAt(end)) {
                start++;
                end--;
            } else {
                check = true;
                break;
            }
        }
        if (!check) {
            return 1;
        }
        String str1 = A.substring(start + 1, end + 1);
        String str2 = A.substring(start, end);
        if (palindrome(str1) || palindrome(str2)) {
            return 1;
        }
        return 0;
    }

    public static boolean palindrome(String A) {
        int n = A.length();
        for (int i = 0; i < n / 2; i++) {
            if (A.charAt(i) != A.charAt(n - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
