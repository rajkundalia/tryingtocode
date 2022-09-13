package interviewbit.twopointers;

import java.util.ArrayList;
import java.util.List;

/*
Given two integers A and B which represent an integer range [A, B].
Find the maximum number of distinct palindromic integers we can take from the given range,
such that the absolute difference between any two integers doesn't exceed C.

Problem Constraints
1 <= A <= B <= 105
1 <= C <= 105

Input Format
The first argument is an integer A.
The second argument is an integer B.
The third argument is an integer C.

Output Format
Return an integer.

Example Input
Input 1:
A = 80
B = 110
C = 10
Input 2:
A = 1
B = 10
C = 10

Example Output
Output 1:
2
Output 2:
9

Example Explanation
Explanation 1:
The plaindromic integers are 88, 99, 101.
We will pick 99, 101.
Explanation 2:
The plaindromic integers are 1, 2, 3, 4, 5, 6, 7, 8, 9.
We can pick all the palindrome integers.
 */
public class PalindromeNumbers {
    public static void main(String[] args) {
        System.out.println(solve(80, 110, 10));
    }

    public static int solve(int A, int B, int C) {
        int i;
        List<Integer> list = new ArrayList<>();
        for (i = A; i <= B; i++) {
            if (checkPalindrome(Integer.toString(i))) {
                list.add(i);
            }
        }

        int l = 0;
        int n = list.size();
        int ans = 0;
        i = 0;
        while (i < n && (list.get(i) - list.get(l)) <= C) {
            while (i < n && list.get(i) - list.get(l) <= C) i++;
            ans = Math.max(ans, i - l);
            if (i == n) break;
            while (l < n && list.get(i) - list.get(l) > C) l++;
        }
        return ans;
    }

    private static boolean checkPalindrome(String number) {
        int n = number.length();
        for (int i = 0; i < n / 2; i++) {
            if (number.charAt(i) != number.charAt(n - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
