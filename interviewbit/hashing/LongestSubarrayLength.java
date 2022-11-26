package interviewbit.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given an integer array A of size N containing 0's and 1's only.
You need to find the length of the longest subarray having count of 1’s one more than count of 0’s.
Note: In the subarray count of 1's should be one more than the count of 0's.

Problem Constraints
1 <= N <= 105

Input Format
First and only argument is an integer array A of size N.

Output Format
Return an integer denoting the longest length of the subarray.

Example Input
Input 1:
 A = [0, 1, 1, 0, 0, 1]
Input 2:
 A = [1, 0, 0, 1, 0]

Example Output
Output 1:
 5
Output 2:
 1

Example Explanation
Explanation 1:
 Subarray of length 5, index 1 to 5 i.e 1, 1, 0, 0, 1. Count of 1 = 3, Count of 0 = 2.
Explanation 2:
 Subarray of length 1 will be only subarray that follow the above condition.
 */
public class LongestSubarrayLength {
    public static void main(String[] args) {
        System.out.println(solve(new ArrayList<>(List.of(0, 1, 1, 0, 0, 1))));
    }

    public static int solve(ArrayList<Integer> A) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) == 0) {
                A.set(i, -1);
            }
        }

        int sum = 0;
        int maxLen = 0;

        for (int i = 0; i < A.size(); i++) {
            sum += A.get(i);
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
            if (map.containsKey(sum - 1)) {
                maxLen = Math.max(maxLen, i - map.get(sum - 1));
            }
        }
        return maxLen;
    }
}
