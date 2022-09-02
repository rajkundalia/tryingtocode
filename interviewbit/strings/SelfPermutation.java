package interviewbit.strings;

import java.util.Arrays;

/*
You are given two strings A and B.
Check whether there exists any permutation of both A and B such that they are equal.
Return a single integer 1 if its exists, 0 otherwise.

Problem Constraints
1 <= |A|, |B| <= 105
Both strings contain only lowercase english alphabets.

Input Format
The first argument is the string A. The second argument is the string B.

Output Format
Return a single integer 1 if a permutation exists, 0 otherwise.

Example Input
Input 1:
A = 'scaler'
B = 'relasc'
Input 2:
A = 'scaler'
B = 'interviewbit'

Example Output
Output 1:
1
Output 2:
0

Example Explanation
Explanation 1:
We can rearrange the second string to 'scaler', hence, a permuation exists.
Explanation 2:
The given length of the two strings itself is different. There is no possible permutation.
 */
public class SelfPermutation {
    public static void main(String[] args) {
        System.out.println(permuteStrings("scaler", "relasc"));
    }

    public static int permuteStrings(String A, String B) {
        char[] first = A.toCharArray();
        char[] second = B.toCharArray();
        Arrays.sort(first);
        Arrays.sort(second);
        return Arrays.equals(first, second) ? 1 : 0;
    }
}
