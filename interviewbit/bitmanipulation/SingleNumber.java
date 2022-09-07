package interviewbit.bitmanipulation;

import java.util.List;

/*
Given an array of integers A, every element appears twice except for one. Find that single one.
NOTE: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Problem Constraints
1 <= |A| <= 2000000
0 <= A[i] <= INTMAX

Input Format
First and only argument of input contains an integer array A.

Output Format
Return a single integer denoting the single element.

Example Input
Input 1:
 A = [1, 2, 2, 3, 1]
Input 2:
 A = [1, 2, 2]

Example Output
Output 1:
 3
Output 2:
 1

Example Explanation
Explanation 1:
3 occurs once.
Explanation 2:
1 occurs once.
 */
public class SingleNumber {
    public static void main(String[] args) {
        System.out.println(singleNumber(List.of(1, 2, 2, 3, 1)));
    }

    /*
        If we Xor a number with itself it returns 0. That means a^a = 0
        If we Xor any number with zero we get that number itself. That means a^0 = a.
     */
    public static int singleNumber(final List<Integer> A) {
        int ans = 0;
        for (int a : A) {
            ans = ans ^ a;
        }
        return ans;
    }

}
