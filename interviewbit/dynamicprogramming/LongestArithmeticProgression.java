package interviewbit.dynamicprogramming;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Find the longest Arithmetic Progression in an integer array A of size N, and return its length.

More formally, find longest sequence of indices, 0 < i1 < i2 < … < ik < ArraySize(0-indexed) such that sequence
A[i1], A[i2], …, A[ik] is an Arithmetic Progression.

Arithmetic Progression is a sequence in which all the differences between consecutive pairs are the same,
i.e sequence B[0], B[1], B[2], …, B[m - 1] of length m is an Arithmetic Progression if and only if
B[1] - B[0] == B[2] - B[1] == B[3] - B[2] == … == B[m - 1] - B[m - 2]

Note: The common difference can be positive, negative, or 0.

Problem Constraints
1 <= N <= 1000
1 <= A[i] <= 1e9

Input Format
The first and only argument of input contains an integer array, A.

Output Format
Return an integer, representing the length of the longest possible arithmetic progression.

Example Input
Input 1:
 A = [3, 6, 9, 12]
Input 2:
 A = [9, 4, 7, 2, 10]

Example Output
Output 1:
4
Output 2:
3

Example Explanation
Explanation 1:
[3, 6, 9, 12] form an arithmetic progression.
Explanation 1:
[4, 7, 10] form an arithmetic progression.
 */
public class LongestArithmeticProgression {
    public static void main(String[] args) {
        System.out.println(new LongestArithmeticProgression().solve(List.of(9, 4, 7, 2, 10)));
    }

    /*
        [3, 6, 9, 12]
        [[:],[3:1],[6:1,3:2],[9:1,6:1,3:3]]

        Here, we need to form a map like this, key is difference, value is count.

        We have to find difference from the previous elements.

        For 3, no previous element.
        For 6, 6-3=3, so 3:1
        For 9, 9-3=6, so 6:1; for 9-6=3, we have 3:1 in map of element 6, so 3:1+1 -> 3:2

        For 12, 12-3=9, so 9:1; for 12-6=6, we don't have difference 6 entry in map of element 6, so 6:1;
            for 12-9=3, we do have 3:2 in map of element 9, so 3:3

        Now 3:3 -> count 3+1 is the answer i.e. 4

        https://youtu.be/Y3sZ2bsresI
     */
    public int solve(final List<Integer> A) {
        int n = A.size();
        if (n <= 2) {
            return 2;
        }

        HashMap<Integer, Integer>[] dp = new HashMap[n];
        int maxValue = 1;

        for (int i = 0; i < n; i++) {
            int currentElement = A.get(i);
            dp[i] = new HashMap<>();
            HashMap<Integer, Integer> currentMap = dp[i];
            // empty hashmap of the current element that we are going to fill now

            for (int j = 0; j < i; j++) {
                int difference = currentElement - A.get(j);
                HashMap<Integer, Integer> previousMap = dp[j];
                int newValue = previousMap.getOrDefault(difference, 0) + 1;
                currentMap.put(difference, newValue);
                dp[i] = currentMap;
                maxValue = Math.max(maxValue, currentMap.get(difference));
            }
        }
        return maxValue + 1;
    }
}
