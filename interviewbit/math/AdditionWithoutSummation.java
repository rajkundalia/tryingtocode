package interviewbit.math;

/*
You are given two numbers A and B.
You have to add them without using arithmetic operators and return their sum.

Problem Constraints
1 <= A, B <= 109

Input Format
The first argument is the integer A. The second argument is the integer B.
Output Format
Return a single integer denoting their sum.

Example Input
Input 1:
A = 3
B = 10
Input 2:

A = 6
B = 1

Example Output
Output 1:
13
Output 2:
7

Example Explanation
Explanation 1:
3 + 10 = 13
Explanation 2:

6 + 1 = 7.
Note, you have to add without using arithmetic operators.
 */
public class AdditionWithoutSummation {
    public static void main(String[] args) {
        System.out.println(solveAdditionWithoutSummation(4, 5));
    }

    /*
        AND (&) only shows position that need a carry.
        XOR (^) helps in simulating addition
        Left shift (<<) helps in carrying the query for adding to left side

        Understand with example

     */
    public static int solveAdditionWithoutSummation(int a, int b) {
        while(b != 0){
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }
}
