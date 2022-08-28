package interviewbit.strings;

/*
Given a string A of size N, find and return the longest palindromic substring in A.

Substring of string A is A[i...j] where 0 <= i <= j < len(A)
Palindrome string:
A string which reads the same backwards. More formally, A is palindrome if reverse(A) = A.
Incase of conflict, return the substring which occurs first ( with the least starting index).

Input Format
First and only argument is a string A.

Output Format
Return a string denoting the longest palindromic substring of string A.

Example Input
A = "aaaabaaa"

Example Output
"aaabaaa"

Example Explanation
We can see that longest palindromic substring is of length 7 and the string is "aaabaaa".
 */
public class LongestPalindromeSubstring {
    public static void main(String[] args) {
        //System.out.println(longestPalindrome("bb"));
        System.out.println(longestPalindrome("abb"));
        //System.out.println(longestPalindrome("aaaabaaa"));
        //System.out.println(longestPalindrome("abbcccbbbcaaccbababcbcabca"));
    }

    static int s, len;

    public static String longestPalindrome(String A) {
        int n = A.length();
        for (int i = 0; i < n; i++) {
            help(A, i, i + 1, n);
            help(A, i, i, n);
        }
        return A.substring(s, s + len);
    }

    public static void help(String A, int i, int j, int n) {
        while (i >= 0 && j < n && A.charAt(i) == A.charAt(j)) {
            i--;
            j++;
        }
        if (len < j - i - 1) {
            s = i + 1;
            len = j - i - 1;
        }
    }
}