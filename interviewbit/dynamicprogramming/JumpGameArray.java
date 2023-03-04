package interviewbit.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

/*
Given an array of non-negative integers, A, you are initially positioned at the 0th index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

Input Format:
The first and the only argument of input will be an integer array A.
Output Format:
Return an integer, representing the answer as described in the problem statement.
    => 0 : If you cannot reach the last index.
    => 1 : If you can reach the last index.
Constraints:
    1 <= len(A) <= 106
    0 <= A[i] <= 30

Examples:
Input 1:
    A = [2,3,1,1,4]

Output 1:
    1

Explanation 1:
    Index 0 -> Index 2 -> Index 3 -> Index 4

Input 2:
    A = [3,2,1,0,4]

Output 2:
    0

Explanation 2:
    There is no possible path to reach the last index.
 */
public class JumpGameArray {
    public static void main(String[] args) {
        System.out.println(new JumpGameArray().canJump(new ArrayList<>(List.of(2, 3, 1, 1, 4))));
    }

    private int canJump(ArrayList<Integer> A) {
        int index = A.size() - 1;

        for (int i = A.size() - 1; i >= 0; i--) {
            if (A.get(i) + i >= index) {
                index = i;
            }
        }

        return index == 0 ? 1 : 0;
    }

    public int canJump1(ArrayList<Integer> A) {
        int n = A.size();
        int furtherReach = 0;
        for (int i = 0; i < n; i++) {
            if (i > furtherReach || furtherReach >= n - 1) {
                break;
            }
            furtherReach = Math.max(furtherReach, i + A.get(i));
        }
        return furtherReach >= n - 1 ? 1 : 0;
    }
}
