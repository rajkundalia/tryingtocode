package interviewbit.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given a matrix M of size nxm and an integer K, find the maximum element in the K manhattan distance neighbourhood
for all elements in nxm matrix.

In other words, for every element M[i][j] find the maximum element M[p][q] such that abs(i-p)+abs(j-q) <= K.

Note: Expected time complexity is O(N*N*K)
Constraints:

1 <= n <= 300
1 <= m <= 300
1 <= K <= 300
0 <= M[i][j] <= 1000
Example:
Input:
M  = [[1,2,4],[4,5,8]] , K = 2
Output:
ans = [[5,8,8],[8,8,8]]
 */
public class KthManhattanDistanceNeighbourhood {
    public static void main(String[] args) {
        int[][] B = {{1, 2, 4}, {4, 5, 8}};
        System.out.println(new KthManhattanDistanceNeighbourhood().solve(2, B));
    }

    // debug to understand this
    public int[][] solve(int A, int[][] B) {
        int m = B.length;
        int n = B[0].length;
        int[][] curr = B;

        for (int d = 0; d < A; d++) {
            int[][] next = deepCopy(curr);
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int val = curr[i][j];
                    int left = j == 0 ? -1 : curr[i][j - 1];
                    int right = j == n - 1 ? -1 : curr[i][j + 1];
                    int up = i == 0 ? -1 : curr[i - 1][j];
                    int down = i == m - 1 ? -1 : curr[i + 1][j];
                    next[i][j] = Math.max(val, Math.max(left, Math.max(right, Math.max(up, down))));
                }
            }
            curr = next;
        }

        return curr;
    }

    private int[][] deepCopy(int[][] original) {
        int[][] result = new int[original.length][];
        for (int i = 0; i < original.length; i++) {
            result[i] = Arrays.copyOf(original[i], original[i].length);
        }
        return result;
    }
}
