package interviewbit.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given an integer array A of size N, find the first repeating element in it.
We need to find the element that occurs more than once and whose index of first occurrence is smallest.
If there is no repeating element, return -1.

Problem Constraints
1 <= N <= 105
1 <= A[i] <= 109

Input Format
First and only argument is an integer array A of size N.

Output Format
Return an integer denoting the first repeating element.

Example Input
Input 1:
 A = [10, 5, 3, 4, 3, 5, 6]
Input 2:
 A = [6, 10, 5, 4, 9, 120]

Example Output
Output 1:
 5
Output 2:
 -1

Example Explanation
Explanation 1:
 5 is the first element that repeats
Explanation 2:
 There is no repeating element, output -1
 */
public class FirstRepeatingElement {
    public static void main(String[] args) {
        System.out.println(solve(new ArrayList<>(List.of(10, 5, 3, 4, 3, 5, 6))));
    }

    public static int solve(ArrayList<Integer> A) {
        Map<Integer, Integer> map = new HashMap<>();
        int minIndex = Integer.MAX_VALUE;
        for (int i = 0; i < A.size(); i++) {
            if (map.containsKey(A.get(i))) {
                minIndex = Math.min(minIndex, map.get(A.get(i)));
            } else {
                map.put(A.get(i), i);
            }
        }
        return minIndex == Integer.MAX_VALUE ? -1 : A.get(minIndex);

    }
}
