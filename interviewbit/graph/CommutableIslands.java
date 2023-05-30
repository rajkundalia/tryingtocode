package interviewbit.graph;

import java.util.Arrays;

/*
There are A islands and there are M bridges connecting them. Each bridge has some cost attached to it.
We need to find bridges with minimal cost such that all islands are connected.
It is guaranteed that input data will contain at least one possible scenario in which all islands are connected with each other.

Input Format:
The first argument contains an integer, A, representing the number of islands.
The second argument contains an 2-d integer matrix, B, of size M x 3:
    => Island B[i][0] and B[i][1] are connected using a bridge of cost B[i][2].
Output Format:
Return an integer representing the minimal cost required.
Constraints:

1 <= A, M <= 6e4
1 <= B[i][0], B[i][1] <= A
1 <= B[i][2] <= 1e3
Examples:

Input 1:
    A = 4
    B = [   [1, 2, 1]
            [2, 3, 4]
            [1, 4, 3]
            [4, 3, 2]
            [1, 3, 10]  ]

Output 1:
    6

Explanation 1:
    We can choose bridges (1, 2, 1), (1, 4, 3) and (4, 3, 2), where the total cost incurred will be (1 + 3 + 2) = 6.

Input 2:
    A = 4
    B = [   [1, 2, 1]
            [2, 3, 2]
            [3, 4, 4]
            [1, 4, 3]   ]

Output 2:
    6

Explanation 2:
    We can choose bridges (1, 2, 1), (2, 3, 2) and (1, 4, 3), where the total cost incurred will be (1 + 2 + 3) = 6.
 */
public class CommutableIslands {
    public static void main(String[] args) {
        System.out.println(new CommutableIslands().solve(4, new int[][]{
                {1, 2, 1},
                {2, 3, 2},
                {3, 4, 4},
                {1, 4, 3}
        }));
    }

    public int solve(int A, int[][] B) {
        Arrays.sort(B, (x, y) -> x[2] - y[2]);

        int[] parent = new int[A + 1];
        for (int i = 0; i < A + 1; i++) {
            parent[i] = i;
        }

        int res = 0;

        for (int i = 0, s = 0; s < A - 1; i++) {
            int x = find(B[i][0], parent);
            int y = find(B[i][1], parent);

            if (x != y) {
                union(x, y, parent);
                res = res + B[i][2];
                s++;
            }
        }

        return res;
    }

    public int find(int x, int[] parent) {
        if (parent[x] == x) {
            return x;
        } else {
            int res = find(parent[x], parent);
            parent[x] = res;
            return res;
        }
    }

    public void union(int x, int y, int[] parent) {
        int xrep = find(x, parent);
        int yrep = find(y, parent);

        if (xrep == yrep) {
            return;
        } else {
            parent[xrep] = yrep;
        }
    }
}
