package interviewbit.dynamicprogramming;

import java.util.Arrays;

/*
Given a string A, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.
Below is one possible representation of A = “great”:

    great
   /    \
  gr    eat
 / \    /  \
g   r  e   at
           / \
          a   t

To scramble the string, we may choose any non-leaf node and swap its two children.
For example, if we choose the node “gr” and swap its two children, it produces a scrambled string “rgeat”.

    rgeat
   /    \
  rg    eat
 / \    /  \
r   g  e   at
           / \
          a   t
We say that “rgeat” is a scrambled string of “great”.
Similarly, if we continue to swap the children of nodes “eat” and “at”, it produces a scrambled string “rgtae”.
    rgtae
   /    \
  rg    tae
 / \    /  \
r   g  ta  e
       / \
      t   a
We say that “rgtae” is a scrambled string of “great”.

Given two strings A and B of the same length, determine if B is a scrambled string of S.

Input Format:
The first argument of input contains a string A.
The second argument of input contains a string B.
Output Format:
Return an integer, 0 or 1:
    => 0 : False
    => 1 : True
Constraints:
1 <= len(A), len(B) <= 50
Examples:
Input 1:
    A = "we"
    B = "we"

Output 1:
    1
Input 2:
    A = "phqtrnilf"
    B = "ilthnqrpf"
Output 2:
    0
 */
public class ScrambleString {
    public static void main(String[] args) {
        System.out.println(new ScrambleString().isScramble("we", "we"));
        System.out.println(new ScrambleString().isScramble("great", "rgeat"));
    }

    public int isScramble(final String s1, final String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return 0;
        }

        if (s1.equals(s2)) {
            return 1;
        }

        char[] a1 = s1.toCharArray();
        char[] a2 = s2.toCharArray();
        Arrays.sort(a1);
        Arrays.sort(a2);
        if (!(new String(a1).equals(new String(a2))))
            return 0;
        for (int i = 1; i < s1.length(); i++) {
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) == 1
                    && isScramble(s1.substring(i), s2.substring(i)) == 1) {
                return 1;
            }
            if (isScramble(s1.substring(0, i), s2.substring(s2.length() - i)) == 1
                    && isScramble(s1.substring(i), s2.substring(0, s2.length() - i)) == 1) {
                return 1;
            }
        }
        return 0;
    }
}

