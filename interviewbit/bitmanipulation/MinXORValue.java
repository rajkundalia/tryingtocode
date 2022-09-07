package interviewbit.bitmanipulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Given an integer array A of N integers, find the pair of integers in the array which have minimum XOR value.
Report the minimum XOR value.

Input Format:
    First and only argument of input contains an integer array A
Output Format:
    return a single integer denoting minimum xor value
Constraints:

2 <= N <= 100 000
0 <= A[i] <= 1 000 000 000
For Examples :

Example Input 1:
    A = [0, 2, 5, 7]
Example Output 1:
    2
Explanation:
    0 xor 2 = 2
Example Input 2:
    A = [0, 4, 7, 9]
Example Output 2:
    3
 */
public class MinXORValue {
    public static void main(String[] args) {
        System.out.println(findMinXor(new ArrayList<>(List.of(0, 2, 5, 7))));
    }

    /*
        If duplicates present then ans will be 0, but this is just a special case

        Observe the xor value of two less distant and more distant elements
        Which one will be smaller?
        Think how to take xor of 2 less distant values in array
        You should be thinking of sorting, yes
        That's what the Solution is about to
        Note if a<=b<=c then ( a xor b < a xor b ) and may ( b xor c < a xor c )
     */
    public static int findMinXor(ArrayList<Integer> A) {
        Collections.sort(A);
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < A.size() - 1; i++) {
            ans = Math.min(ans, A.get(i) ^ A.get(i + 1));
        }
        return ans;
    }
}
