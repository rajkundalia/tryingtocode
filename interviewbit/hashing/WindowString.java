package interviewbit.hashing;

/*
Given a string S and a string T, find the minimum window in S which will contain all the characters in
T in linear time complexity.

Note that when the count of a character C in T is N, then the count of C in minimum window in S should be at least N.
Example :
S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC"

Note:
If there is no such window in S that covers all characters in T, return the empty string ''.
If there are multiple such windows, return the first occurring minimum window ( with minimum start index ).
 */
public class WindowString {
    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }

    public static String minWindow(String A, String B) {
        int n = A.length();
        int m = B.length();
        if (n < m) return "";
        if (m == 0) return "";
        int arr[] = new int[256];
        int brr[] = new int[256];
        for (int i = 0; i < m; i++) {
            brr[B.charAt(i)]++;
            arr[A.charAt(i)]++;
        }
        int j = 0;
        String ans = "";
        int min = Integer.MAX_VALUE;
        for (int i = m; i <= n; i++) {
            while (match(arr, brr)) {
                if (min > (i - j)) {
                    min = i - j;
                    ans = A.substring(j, i);
                }
                arr[A.charAt(j)]--;
                j++;
            }
            if (i < n)
                arr[A.charAt(i)]++;
        }
        return ans;
    }

    public static boolean match(int a[], int b[]) {
        for (int i = 0; i < 256; i++) {
            if (b[i] > 0 && a[i] < b[i]) {
                return false;
            }
        }
        return true;
    }
}
