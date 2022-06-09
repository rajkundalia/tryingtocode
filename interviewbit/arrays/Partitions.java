package interviewbit.arrays;

import java.util.ArrayList;
import java.util.List;

/*
    Problem Description
You are given a 1D integer array B containing A integers.
Count the number of ways to split all the elements of the array into 3 contiguous parts so that the sum of elements in each part is the same.
Such that : sum(B[1],..B[i]) = sum(B[i+1],...B[j]) = sum(B[j+1],...B[n])

Problem Constraints
1 <= A <= 105

-109 <= B[i] <= 109

Input Format
First argument is an integer A.
Second argument is an 1D integer array B of size A.

Output Format
Return a single integer denoting the number of ways to split the array B into three parts with the same sum.

Example Input
Input 1:

 A = 5
 B = [1, 2, 3, 0, 3]
Input 2:

 A = 4
 B = [0, 1, -1, 0]

Example Output
Output 1:
 2
Output 2:
 1

Example Explanation
Explanation 1:

 There are no 2 ways to make partitions -
 1. (1,2)+(3)+(0,3).
 2. (1,2)+(3,0)+(3).
Explanation 2:

 There is only 1 way to make partition -
 1. (0)+(-1,1)+(0).
 */
public class Partitions {
    public static void main(String[] args) {
        System.out.println(solvePartitions(5, new ArrayList<>(List.of(1, 2, 3, 0, 3))));
    }

    public static int solvePartitions(int A, ArrayList<Integer> B) {
        int sum = 0;
        int[] arr = new int[A];


        for (int i = 0; i < A; i++) {
            sum += B.get(i);
            arr[i] = sum;
        }

        if (sum % 3 != 0) {
            return 0;
        }

        int ans = 0;
        int count = 0;
        int u = sum / 3;
        int v = 2 * sum / 3;

        // here we take A - 1 because the first 2 parts i.e. u and then v, if the sum is divisible by three,
        // the part will automatically be divisible by 3
        // in case a list has 0 in it then 1 combination increases
        for (int i = 0; i < A - 1; i++) {
            if (arr[i] == v) {
                ans += count;
            }

            if (arr[i] == u) {
                count++;
            }
        }
        return ans;
    }
}
