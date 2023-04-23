package interviewbit.graph;

import java.util.ArrayList;

/*
Given an arbitrary unweighted rooted tree which consists of N nodes.

The goal of the problem is to find the largest distance between two nodes in a tree.

Distance between two nodes is a number of edges on a path between the nodes (there will be a unique path between any
pair of nodes since it is a tree).

The nodes will be numbered 0 through N - 1.

The tree is given as an array A, there is an edge between nodes A[i] and i (0 <= i < N).
Exactly one of the i's will have A[i] equal to -1, it will be root node.

Problem Constraints
1 <= N <= 40000

Input Format
First and only argument is an integer array A of size N.

Output Format
Return a single integer denoting the largest distance between two nodes in a tree.

Example Input
Input 1:
 A = [-1, 0, 0, 0, 3]

Example Output
Output 1:
 3

Example Explanation
Explanation 1:
 node 0 is the root and the whole tree looks like this:
          0
       /  |  \
      1   2   3
               \
                4
 One of the longest path is 1 -> 0 -> 3 -> 4 and its length is 3, thus the answer is 3.
 */
public class LargestDistanceBetweenNodesOfATree {
    public static void main(String[] args) {
        System.out.println(new LargestDistanceBetweenNodesOfATree().solve(new int[]{-1, 0, 0, 0, 3}));
    }

    public int solve(int[] A) {
        int n = A.length;
        ArrayList<Integer>[] adjacencyList = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        int root = 0;

        for (int i = 0; i < n; i++) {
            if (A[i] == -1) {
                root = i;
                continue;
            }

            int u = i;
            int v = A[i];
            adjacencyList[u].add(v);
            adjacencyList[v].add(u);
        }

        int[] ans = {0};
        findDiameter(root, -1, adjacencyList, ans);

        return ans[0];
    }

    private int findDiameter(int source, int parent, ArrayList<Integer>[] adjacencyList, int[] ans) {
        int firstMaxHeight = 0;
        int secondMaxHeight = 0;
        int countOfChild = 0;

        for (int child : adjacencyList[source]) {
            if (child != parent) {
                countOfChild++;

                int height = findDiameter(child, source, adjacencyList, ans);

                if (firstMaxHeight < height) {
                    secondMaxHeight = firstMaxHeight;
                    firstMaxHeight = height;
                } else if (secondMaxHeight < height) {
                    secondMaxHeight = height;
                }
            }
        }

        int tempAns = firstMaxHeight + secondMaxHeight;

        if (countOfChild >= 2) {
            tempAns += 2;
        } else if (countOfChild == 1) {
            tempAns += 1;
        }

        ans[0] = Math.max(ans[0], tempAns);

        // return height of current Node
        if (countOfChild > 0) {
            return 1 + firstMaxHeight;
        } else {
            return 0;
        }
    }
}
