package interviewbit.heapsandmaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/*
Given two equally sized 1-D arrays A, B containing N integers each.
A sum combination is made by adding one element from array A and another element of array B.
Return the maximum C valid sum combinations from all the possible sum combinations.

Problem Constraints
1 <= N <= 105
1 <= A[i] <= 105
1 <= C <= N

Input Format
First argument is an one-dimensional integer array A of size N.
Second argument is an one-dimensional integer array B of size N.
Third argument is an integer C.

Output Format
Return a one-dimensional integer array of size C denoting the top C maximum sum combinations.
NOTE:
The returned array must be sorted in non-increasing order.

Example Input
Input 1:
 A = [3, 2]
 B = [1, 4]
 C = 2
Input 2:
 A = [1, 4, 2, 3]
 B = [2, 5, 1, 6]
 C = 4

Example Output
Output 1:
 [7, 6]
Output 1:
 [10, 9, 9, 8]

Example Explanation
Explanation 1:
 7     (A : 3) + (B : 4)
 6     (A : 2) + (B : 4)
Explanation 2:
 10   (A : 4) + (B : 6)
 9   (A : 4) + (B : 5)
 9   (A : 3) + (B : 6)
 8   (A : 3) + (B : 5)
 */
public class MaximumSumCombinations {
    public static void main(String[] args) {
        System.out.println(solve(new ArrayList<>(List.of(1, 4, 2, 3)), new ArrayList<>(List.of(2, 5, 1, 6)), 4));
    }

    public static ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
        Collections.sort(A, Collections.reverseOrder());
        Collections.sort(B, Collections.reverseOrder());
        int n = A.size();

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : A) {
            for (int j : B) {
                int s = i + j;
                if (pq.size() < C) {
                    pq.add(s);
                } else {
                    if (s > pq.peek()) {
                        pq.poll();
                        pq.add(s);
                    } else {
                        break;
                    }
                }
            }
        }
        ArrayList<Integer> ret = new ArrayList<>(pq);
        Collections.sort(ret, Collections.reverseOrder());
        return ret;
    }
}
