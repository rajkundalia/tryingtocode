package interviewbit.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
Given an 1D integer array A containing N distinct integers.
Find the number of unique pairs of integers in the array whose XOR is equal to B.
NOTE:
Pair (a, b) and (b, a) is considered to be same and should be counted once.

Problem Constraints
1 <= N <= 105
1 <= A[i], B <= 107

Input Format
First argument is an 1D integer array A.
Second argument is an integer B.

Output Format
Return a single integer denoting the number of unique pairs of integers in the array A whose XOR is equal to B.

Example Input
Input 1:
 A = [5, 4, 10, 15, 7, 6]
 B = 5
Input 2:
 A = [3, 6, 8, 10, 15, 50]
 B = 5

Example Output
Output 1:
 1
Output 2:
 2

Example Explanation
Explanation 1:
 (10 ^ 15) = 5
Explanation 2:
 (3 ^ 6) = 5 and (10 ^ 15) = 5
 */
public class PairsWithGivenXOR {
    public static void main(String[] args) {
        System.out.println(solve(new ArrayList<>(List.of(5, 4, 10, 15, 7, 6)), 5));
    }

    /*
    The idea is based on the fact that A[i] ^ A[j] is equal to B if and only if A[i] ^ B is equal to A[j].
     */
    public static int solve(ArrayList<Integer> A, int B) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < A.size(); i++) {
            map.put(A.get(i), 1);
        }

        int count = 0;
        for (int i = 0; i < A.size(); i++) {
            int val = B ^ A.get(i);
            if (map.containsKey(val)) {
                count++;
            }
        }
        return count / 2;
    }
}
