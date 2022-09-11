package interviewbit.bitmanipulation;

/*
Given an integer A.
Swap the Bth and Cth bit from right in binary representation of A.
Return the integer formed.

Problem Constraints
1 <= A < 230
1 <= B, C <= 30

Input Format
First argument is an integer A.
Second argument is an integer B.
Third argument is an integer C.

Output Format
Return an integer.

Example Input
Input 1:
A = 9
B = 1
C = 2
Input 2:
A = 1
B = 1
C = 3

Example Output
Output 1:
10
Output 2:
4

Example Explanation
Explanation 1:
5 -> 101
Swapping 1st and 2nd bit from right gives 110.
Explanation 2:
1 -> 001
Swapping 1st and 3rd bit from right gives 100.
 */
public class SwapBits {
    public static void main(String[] args) {
        System.out.println(solve(9, 1, 2));
    }

//    We need to change to Bth and Cth bit from right.
//            therefore
//
//            A= 1001
//    A= 1000 (after changing 1st bit from right)
//    A=1010 (after changing 2nd bit from right) = 10
    public static int solve(int A, int B, int C) {
        B -= 1;
        C -= 1;
        int bitB = 1 & (A >> B);
        int bitC = 1 & (A >> C);
        if (bitB != bitC) {
            A = A ^ (1 << B);
            A = A ^ (1 << C);
        }
        return A;
    }
}
