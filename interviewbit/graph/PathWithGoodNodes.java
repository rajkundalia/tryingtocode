package interviewbit.graph;

import java.util.ArrayList;

/*
Given a tree with N nodes labelled from 1 to N.

Each node is either good or bad denoted by binary array A of size N where if A[i] is 1 then ithnode is good else if A[i] is
0 then ith node is bad.

Also the given tree is rooted at node 1 and you need to tell the number of root to leaf paths in the tree
that contain not more than C good nodes.

NOTE:
Each edge in the tree is bi-directional.

Problem Constraints
2 <= N <= 105
A[i] = 0 or A[i] = 1
0 <= C <= N

Input Format
First argument is an binary integer array A of size N.
Second argument is a 2-D array B of size (N-1) x 2 denoting the edge of the tree.
Third argument is an integer C.

Output Format
Return an integer denoting the number of root to leaf paths in the tree that contain not more than C good nodes.

Example Input
Input 1:
 A = [0, 1, 0, 1, 1, 1]
 B = [  {1, 2},
        {1, 5},
        {1, 6},
        {2, 3},
        {2, 4}
     ]
 C = 1

Example Output
Output 1:
 3

Example Explanation
Explanation 1:
 Path (1 - 2 - 3) and (1 - 5) and (1 - 6) are the paths which contain atmost C nodes.
 */
public class PathWithGoodNodes {
    public static void main(String[] args) {
        System.out.println(new PathWithGoodNodes().solve(new int[]{0, 1, 0, 1, 1, 1}, new int[][]{
                {1, 2},
                {1, 5},
                {1, 6},
                {2, 3},
                {2, 4}
        }, 1));
    }

    public int solve(int[] A, int[][] B, int C) {
        int n = A.length;
        ArrayList<Integer>[] adjacencyList = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        for (int i = 0; i < B.length; i++) {
            int u = B[i][0];
            int v = B[i][1];

            adjacencyList[u].add(v);
            adjacencyList[v].add(u);
        }

        int[] ans = {0};

        dfs(1, -1, 0, A, adjacencyList, C, ans);

        return ans[0];
    }

    private void dfs(int source, int parent, int goodNodes, int[] A, ArrayList<Integer>[] adjacencyList, int C, int[] ans) {
        if (A[source - 1] == 1) {
            goodNodes++;
        }

        if (goodNodes > C) {
            return;
        }

        int countOfChild = 0;

        for (int child: adjacencyList[source]) {
            if (child != parent) {
                countOfChild++;
                dfs(child, source, goodNodes, A, adjacencyList, C, ans);
            }
        }

        if (countOfChild == 0) {
            ans[0]++;
        }
    }
}
