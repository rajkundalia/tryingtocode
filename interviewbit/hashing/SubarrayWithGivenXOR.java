package interviewbit.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given an array of integers A and an integer B.
Find the total number of sub-arrays having bitwise XOR of all elements equals to B.

Problem Constraints
1 <= length of the array <= 105
1 <= A[i], B <= 109

Input Format
The first argument given is the integer array A.
The second argument given is integer B.

Output Format
Return the total number of subarrays having bitwise XOR equals to B.

Example Input
Input 1:
 A = [4, 2, 2, 6, 4]
 B = 6
Input 2:
 A = [5, 6, 7, 8, 9]
 B = 5

Example Output
Output 1:
 4
Output 2:
 2

Example Explanation
Explanation 1:
 The subarrays having XOR of their elements as 6 are:
 [4, 2], [4, 2, 2, 6, 4], [2, 2, 6], [6]
Explanation 2:
 The subarrays having XOR of their elements as 5 are [5] and [5, 6, 7, 8, 9]
 */
public class SubarrayWithGivenXOR {
    public static void main(String[] args) {
        System.out.println(solve(new ArrayList<>(List.of(4, 2, 2, 6, 4)), 6));
    }

    public static int solve(ArrayList<Integer> A, int B) {
        int xor = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < A.size(); i++) {
            xor = xor ^ A.get(i);
            if (map.get(xor ^ B) != null) {
                count += map.get(xor ^ B);
            }

            if (xor == B) {
                count++;
            }

            if (map.get(xor) != null) {
                map.put(xor, map.get(xor) + 1);
            } else {
                map.put(xor, 1);
            }
        }
        return count;
    }
}
