package interviewbit.strings;

import java.util.Arrays;

/*
Given the array of strings A, you need to find the longest string S which is the prefix of ALL the strings in the array.
Longest common prefix for a pair of strings S1 and S2 is the longest string S which is the prefix of both S1 and S2.
For Example: longest common prefix of "abcdefgh" and "abcefgh" is "abc".

Input Format
The only argument given is an array of strings A.

Output Format
Return the longest common prefix of all strings in A.

Example Input
Input 1:
A = ["abcdefgh", "aefghijk", "abcefgh"]
Input 2:
A = ["abab", "ab", "abcd"];

Example Output
Output 1:
"a"
Output 2:
"ab"

Example Explanation
Explanation 1:
Longest common prefix of all the strings is "a".
Explanation 2:
Longest common prefix of all the strings is "ab".
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{}));
    }

    /*
        // declare a string and equal it to the first string of the array
        // do a for loop starting from the second element up until the last
        // do a while check with every iteration if the strings of the array start with our declared string
        // while it doest start, remove the last element of our string up until it doe
        // a check to see if our string is empty, if it is it means the answer throughout this entire loop will empty
     */
    public static String longestCommonPrefix(String[] A) {
        String ans = A[0];
        for (int i = 1; i < A.length; i++) {
            String str = A[i];
            while (!str.startsWith(ans)) {
                ans = ans.substring(0, ans.length() - 1);
                if (ans.isEmpty()) {
                    return "";
                }
            }
        }
        return ans;
    }


    // Sorting Solution
    /*
    if(A==null || A.length==0){
            return "";
        }
      Arrays.sort(A);
      String first=A[0];
      String last=A[A.length-1];
      int c=0;
      while(c<first.length() && first.charAt(c)==last.charAt(c)){
          c++;
      }
      return first.substring(0,c);
     */
}
