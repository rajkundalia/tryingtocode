package interviewbit.bitmanipulation;

/*
Reverse the bits of an 32-bit unsigned integer A.

Problem Constraints
0 <= A <= 232

Input Format
First and only argument of input contains an integer A.
Output Format
Return a single unsigned integer denoting the decimal value of reversed bits.

Example Input
Input 1:
 0
Input 2:
 3

Example Output
Output 1:
 0
Output 2:
 3221225472

Example Explanation
Explanation 1:
        00000000000000000000000000000000
=>      00000000000000000000000000000000
Explanation 2:
        00000000000000000000000000000011
=>      11000000000000000000000000000000
 */
public class ReverseBits {
    public static void main(String[] args) {
        System.out.println(reverse(3));
    }

    // Dry run with a 8 digit example
    public static long reverse(long A) {
        long ans = 0L;
        for (int i = 0; i < 32; i++) {
            ans = ans << 1L;
            ans = ans | (A & 1L); // Or operation is here for adding the digit
            A = A >> 1L;
        }
        return ans;
    }
}
