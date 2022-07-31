package interviewbit.math;

/*
Find last digit of the number AB.
A and B are large numbers given as strings.

Problem Constraints
1 <= |A| <= 105
1 <= |B| <= 105

Input Format
First argument is a string A.
First argument is a string B.

Output Format
Return an integer.

Example Input
Input 1:
A = 2
B = 10
Input 2:
A = 11
B = 11

Example Output
Output 1:
4
Output 2:
1

Example Explanation
Explanation 1:
210 = 1024, hence last digit is 4.
Explanation 2:
1111 = 285311670611, hence last digit is 1.
 */
public class FindLastDigit {
    public static void main(String[] args) {
        System.out.println(solveFindLastDigit("2", "5"));
    }

    /*
        2^1=2, 2^5=32, 2^9=512
        2^2=4, 2^6=64
        2^3=8, 2^7=128
        2^4=16, 2^8=256

        With difference in power by 4, the last digit stays same.
     */
    public static int solveFindLastDigit(String A, String B) {
        int n = B.length();
        int a = A.charAt(A.length() - 1) - '0';
        int b = n == 1 ? Integer.parseInt(B) : Integer.parseInt(B.substring(B.length() - 2));
        long ans = (long) Math.pow(a, (b % 4 + 4));
        return (int) (ans % 10);
    }
}
