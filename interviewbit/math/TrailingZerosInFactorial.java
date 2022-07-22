package interviewbit.math;

/*
Given an integer A, return the number of trailing zeroes in A!.
Note: Your solution should be in logarithmic time complexity.
Problem Constraints
0 <= A <= 10000000

Input Format
First and only argumment is integer A.

Output Format
Return an integer, the answer to the problem.

Example Input
Input 1:
 A = 4
Input 2:
 A = 5

Example Output
Output 1:
 0
Output 2:
 1

Example Explanation
Explanation 1:
 4! = 24
Explanation 2:
 5! = 120
 */
public class TrailingZerosInFactorial {
    public static void main(String[] args) {
        System.out.println(trailingZeroes(126));
    }

    /*
        5! = 120
        1x2x3x4x5=120
        Now trailing zero is 1 here.
        Trailing zero is formed by 10 i.e. 2*5.
        Here in 5!, 5 comes only once which we can get  by n/5 i.e. 5/5=1.
        If it is 10!, 5 comes twice, 10/5=2.
        So we can actually count number of 5's to tell number of trailing zeros.

        for case 26!, 26/5=5 but there is 25 included in it, so number of 5 becomes [26/5]5+[26/25]1=6.
        for case 126! -> [126/5]25 + [126/25]5 + [126/125]1 = 31
     */
    public static int trailingZeroes(int A) {
        int result = 0;
        int power = 1;
        int powerResult = 0;
        while(A > powerResult) {
            powerResult = (int) Math.pow(5, power++);
            result += (A/powerResult);
        }
        return result;
    }
}
