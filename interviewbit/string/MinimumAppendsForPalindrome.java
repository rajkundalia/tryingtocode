package interviewbit.strings;

/*
Given a string A consisting of lowercase characters.
We need to tell minimum characters to be appended (insertion at end) to make the string A a palindrome.

Problem Constraints
1 <= |A| <= 105
A consists only of lower-case characters.

Input Format
First argument is an string A.

Output Format
Return a integer denoting the minimum characters to be appended (insertion at end) to make the string A a palindrome.

Example Input
Input 1:
 A = "abede"
Input 2:
 A = "aabb"

Example Output
Output 1:
 2
Output 2:
 2

Example Explanation
Explanation 1:
 We can make string palindrome as "abedeba" by adding ba at the end of the string.
Explanation 2:
 We can make string palindrome as "aabbaa" by adding aa at the end of the string.
 */
public class MinimumAppendsForPalindrome {
    public static void main(String[] args) {
        System.out.println(solve("abede"));
    }

    public static int solve(String A) {
        int N = A.length();
        int i = 0;
        int j = N - 1;
        int k = 0;
        while (i < j) {
            if (A.charAt(i) == A.charAt(j)) {
                i++;
                j--;
            } else {
                k++;
                i = k;
                j = N - 1;
            }
        }
        return k;
    }
}

/*
public class Solution {
    public int solve(String A) {
        for(int i = 0; i<A.length(); i++){
            if(isPalindrome(i, A)){
                return i;
            }
        }
        return A.length();
    }

    public boolean isPalindrome(Integer index, String A){
        int start = index;
        int end = A.length() -1;

        while(start <= end){
            if(A.charAt(start) != A.charAt(end)){
                return false;
            }
            ++start;
            --end;
        }
        return true;
    }
}

 */
