package interviewbit.bitmanipulation;

import java.util.ArrayList;
import java.util.List;

/*
Given an integer array A of size N.
You need to find the value obtained by XOR-ing the contiguous subarrays, followed by XOR-ing the values thus obtained.
Determine and return this value.

For example, if A = [3, 4, 5] :
Subarray    Operation   Result
3       None            3
4       None            4
5       None            5
3,4   3 XOR 4         7
4,5   4 XOR 5         1
3,4,5    3 XOR 4 XOR 5   2
Now we take the resultant values and XOR them together:
3 ⊕ 4 ⊕ 5 ⊕ 7 ⊕ 1⊕ 2 = 6 we will return 6.

Problem Constraints
1 <= N <= 105

1 <= A[i] <= 108

Input Format
First and only argument is an integer array A.
Output Format
Return a single integer denoting the value as described above.

Example Input
Input 1:
 A = [1, 2, 3]
Input 2:
 A = [4, 5, 7, 5]

Example Output
Output 1:
 2
Output 2:
 0

Example Explanation
Explanation 1:
 1 ⊕ 2 ⊕ 3 ⊕  (1 ⊕ 2 ) ⊕ (2 ⊕ 3) ⊕ (1 ⊕ 2 ⊕ 3) = 2
Explanation 2:
 4 ⊕ 5 ⊕ 7 ⊕ 5 ⊕ (4 ⊕ 5) ⊕ (5 ⊕ 7) ⊕ (7 ⊕ 5) ⊕ (4 ⊕ 5 ⊕ 7) ⊕ (5 ⊕ 7 ⊕ 5) ⊕ (4 ⊕ 5 ⊕ 7 ⊕ 5) = 0
 */
public class XORingSubarrays {
    public static void main(String[] args) {
        System.out.println(solve(new ArrayList<>(List.of(4, 5, 7, 5))));
    }

    /*
        example:
        a,b,c

        sub arrays:
        a
        ab
        abc
        b
        bc
        c

        a xor (a xor b) xor (a xor b xor c) xor (b) xor (b xor c) xor c

        xor is associative

        a xor a = 0
        so a xor a xor a = a;
        if number of a is odd, then a remains
        if number of a is even, then all xors becomes 0

        if size of the list is even, then everything becomes 0 because number of all elements is even
     */
    public static int solve(ArrayList<Integer> A) {
        int ans = 0;
        if (A.size() % 2 == 0) {
            return ans;
        }
        // take an example of 2 3 4
        /*
            2
            2 3
            2 3 4
            3
            3 4
            4

            2 comes 3 times -> 2 xor 2 xor 2 = 2
            3 comes 4 times -> 3 xor 3 xor 3 xor 3 = 0
            4 comes 3 times -> 4 xor 4 xor 4 = 4
            2 xor 4 = 6

            since here it is 0 indexed, loop starts with 0 and +2 which really captures odd elements
         */
        for (int i = 0; i < A.size(); i += 2) {
            ans ^= A.get(i);
        }
        return ans;
    }
}
