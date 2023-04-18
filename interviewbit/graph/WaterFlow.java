package interviewbit.graph;

import java.util.LinkedList;
import java.util.Queue;

/*
Given an N x M matrix A of non-negative integers representing the height of each unit cell in a continent,
the "Blue lake" touches the left and top edges of the matrix and the "Red lake" touches the right and bottom edges.

Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.

Find the number of cells from where water can flow to both the Blue and Red lake.

Problem Constraints
1 <= M, N <= 1000
1 <= A[i][j] <= 109

Input Format
First and only argument is a 2D matrix A.

Output Format
Return an integer denoting the number of cells from where water can flow to both the Blue and Red lake.

Example Input
Input 1:

 A = [
       [1, 2, 2, 3, 5]
       [3, 2, 3, 4, 4]
       [2, 4, 5, 3, 1]
       [6, 7, 1, 4, 5]
       [5, 1, 1, 2, 4]
     ]
Input 2:

 A = [
       [2, 2]
       [2, 2]
     ]

Example Output
Output 1:
 7
Output 2:
 4

Example Explanation
Explanation 1:
 Blue Lake ~   ~   ~   ~   ~
        ~  1   2   2   3  (5) *
        ~  3   2   3  (4) (4) *
        ~  2   4  (5)  3   1  *
        ~ (6) (7)  1   4   5  *
        ~ (5)  1   1   2   4  *
           *   *   *   *   * Red Lake
 Water can flow to both lakes from the cells denoted in parentheses.
Explanation 2:
 Water can flow from all cells.
 */
public class WaterFlow {

    public class Pair {
        int key;
        int value;

        public Pair(int k, int v) {
            key = k;
            value = v;
        }

        public int getKey() {
            return key;
        }

        public int getValue() {
            return value;
        }
    }

    public static void main(String[] args) {
        System.out.println(new WaterFlow().solve(new int[][]{
                {2, 2},
                {2, 2}
        }));
    }

    public int solve(int[][] A) {
        int[] rows = {0, 1, 0, -1};
        int[] cols = {1, 0, -1, 0};

        if (A.length == 0) {
            return 0;
        }
        int n = A.length;
        int m = A[0].length;

        int[][] visited = new int[n][m];

        Queue<Pair> queue = new LinkedList<>();

        for (int j = 0; j < m; j++) {
            queue.add(new Pair(0, j));
            visited[0][j] = 1;
        }

        for (int i = 1; i < n; i++) {
            queue.add(new Pair(i, 0));
            visited[i][0] = 1;
        }

        while (!queue.isEmpty()) {
            Pair poll = queue.poll();
            int x = poll.getKey();
            int y = poll.getValue();

            for (int k = 0; k < 4; k++) {
                int p = x + rows[k];
                int q = y + cols[k];

                if (p >= 0 && p < n && q >= 0 && q < m && A[p][q] >= A[x][y] && visited[p][q] == 0) {
                    visited[p][q] = 1;
                    queue.add(new Pair(p, q));
                }
            }
        }

        int ans = 0;
        for (int j = 0; j < m; j++) {
            queue.add(new Pair(n - 1, j));
            if (visited[n - 1][j] == 1) {
                ans++;
            }
            visited[n - 1][j] = 2;
        }

        for (int i = 0; i < n - 1; i++) {
            queue.add(new Pair(i, m - 1));
            if (visited[i][m - 1] == 1) {
                ans++;
            }
            visited[i][m - 1] = 2;
        }

        while (!queue.isEmpty()) {
            Pair poll = queue.poll();
            int x = poll.getKey();
            int y = poll.getValue();
            for (int k = 0; k < 4; k++) {
                int p = x + rows[k];
                int q = y + cols[k];
                if (p >= 0 && p < n && q >= 0 && q < m && A[p][q] >= A[x][y]) {
                    if (visited[p][q] == 1) {
                        ans++;
                    }
                    if (visited[p][q] == 0 || visited[p][q] == 1) {
                        visited[p][q] = 2;
                        queue.add(new Pair(p, q));
                    }
                }
            }
        }
        return ans;
    }
}

