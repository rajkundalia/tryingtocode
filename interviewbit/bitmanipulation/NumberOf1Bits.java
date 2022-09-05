package interviewbit.bitmanipulation;

/*
Write a function that takes an integer and returns the number of 1 bits it has.

Problem Constraints
0 <= A <= 4294967295

Input Format
First and only argument contains integer A
Output Format
Return an integer as the answer

Example Input
Input1:
    11

Example Output
Output1:
3

Example Explanation
Explaination1:
11 is represented as 1101 in binary 
 */
public class NumberOf1Bits {
    public static void main(String[] args) {
        System.out.println(numSetBits(7));
    }

    public static int numSetBits(long a) {
        int res = 0;
        while (a != 0) {
            a = a & (a - 1);
            res++;
        }
        return res;
    }
}
