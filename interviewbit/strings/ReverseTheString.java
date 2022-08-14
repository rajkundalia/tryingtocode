package interviewbit.strings;

/*
Given a string A.

Return the string A after reversing the string word by word.

NOTE:

A sequence of non-space characters constitutes a word.
Your reversed string should not contain leading or trailing spaces, even if it is present in the input string.
If there are multiple spaces between words, reduce them to a single space in the reversed string.

 Input Format
The only argument given is string A.
Output Format
Return the string A after reversing the string word by word.
For Example

Input 1:
    A = "the sky is blue"
Output 1:
    "blue is sky the"

Input 2:
    A = "this is ib"
Output 2:
    "ib is this"

Input 3:
 A = " hello world "
Output 3:
 "world hello"
 */
public class ReverseTheString {
    public static void main(String[] args) {
        System.out.println(solve("this is ib"));
    }

    // can also be served by the following way:
    //first reverse every word in string then reverse the whole string
    //Approach: "The sky is blue" -> "eht yks si elub" -> "blue is sky the" i.e. 2 times reverse

    public static String solve(String A) {
        String a = A.trim().replaceAll("\\s{2,}", " ");
        String str[] = a.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = str.length - 1; i >= 0; i--) {
            sb.append(str[i]);
            if (i != 0) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
