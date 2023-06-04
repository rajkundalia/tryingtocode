package interviewbit.graph;

import java.io.File;

/*
You are given an assignment to sort out the files of your department today.
A file contains various records. Each record has an (ID, Parent ID).
To make your task easier, you decided to separate records into different sets.
If a set contains a record with (ID, Parent ID) - (X, Y), then both X and Y must be present in the set.
There are A records. You are also given a 2D array B of dimensions N x 2,
where each row is record's (ID, Parent ID).

You have to find the maximum number of sets you can divide the records into.

Problem Constraints
1 <= A, N <= 105
1 <= B[i][0], B[i][1] <= A
There can be duplicate records.
There can be two records (X, Y) and (Y, X).

Input Format
The first argument is the integer A.
The second argument is the 2D integer array B.

Output Format
Return a single integer denoting the maximum number of sets you can break the record into.

Example Input
Input 1:
A = 4
B = [[1, 2], [3, 4]]
Input 2:
A = 4
B = [[1, 2], [3, 4], [2, 4]]

Example Output
Output 1:
2
Output 2:
1

Example Explanation
Explanation 1:
We can create two sets (1, 2), (3, 4). Since, (1, 2) need to be together and (3, 4).
Explanation 2:
We can only have 1 set because (1, 2) need to be together (2, 4) need to be together.
Hence, (1, 2, 4) need to be together. Similarly, (1, 2, 3, 4) need to be together. Therefore, the answer is 1.
 */
public class FileSearch {

    static class DSU {
        int[] rank, parent;

        public DSU(int n) {
            rank = new int[n + 1];
            parent = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                parent[i] = i;
            }
        }

        public int get(int a) {
            return parent[a] = (parent[a] == a ? a : get(parent[a]));
        }

        public void union(int a, int b) {
            a = get(a);
            b = get(b);
            if (rank[a] == rank[b]) {
                rank[a]++;
            }
            if (rank[a] > rank[b]) {
                parent[b] = a;
            } else {
                parent[a] = b;
            }
        }

    }

    public static void main(String[] args) {
        System.out.println(new FileSearch().breakRecords(4, new int[][]{
                {1, 2}, {3, 4}
        }));
    }

    public int breakRecords(int A, int[][] B) {
        int m = B.length;
        DSU dsu = new DSU(A);
        int ans = A;
        for (int i = 0; i < m; i++) {
            if (dsu.get(B[i][0]) == dsu.get(B[i][1])) {
                continue;
            }
            ans--;
            dsu.union(B[i][0], B[i][1]);
        }
        return ans;
    }
}


