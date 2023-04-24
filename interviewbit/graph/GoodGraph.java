package interviewbit.graph;

/*
Given a directed graph of N nodes where each node is pointing to any one of the N nodes (can possibly point to itself).
Ishu, the coder, is bored and he has discovered a problem out of it to keep himself busy.

The problem is as follows:

A node is 'good' if it satisfies one of the following:
It is the special node (marked as node 1)
It is pointing to the special node (node 1)
It is pointing to a good node.

Ishu is going to change the pointers of some nodes to make them all 'good'.
You have to find the min. the number of pointers to change in order to make all the nodes good (Thus, a Good Graph).

Note: Resultant Graph should hold the property that all nodes are good and each node must point to exactly one node.

Problem Constraints
1 <= N <= 100,000

Input Format
A vector of N integers containing N numbers all between 1 to N, where i-th number is the number of node that i-th node is pointing to.

Output Format
An Integer denoting min. number of pointer changes.

Example Input
Input 1:
A = [1, 2, 1, 2]
Input 2:
A = [3, 1, 3, 1]

Example Output
Output 1:
1
Output 2:
1

Example Explanation
Explanation 1:
Pointer of node 2 is made to point to node 1
Explanation 2:
Pointer of node 3 is made to point to node 1
 */
public class GoodGraph {
    public static void main(String[] args) {
        System.out.println(new GoodGraph().solve(new int[]{3, 1, 3, 1}));
    }

    public int solve(int[] A) {
        int n = A.length;
        int[] visited = new int[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                if (dfs(i, A, visited) != 0) {
                    count++;
                }
            }
        }
        return count;
    }

    private int dfs(int node, int[] A, int[] visited) {
        if (A[node] == 1) {
            return 0;
        }

        if (visited[node] == 1) {
            A[node] = 1;
            return 1;
        }

        visited[node] = 1;
        int res = dfs(A[node] - 1, A, visited);
        A[node] = 1;
        return res;
    }
}
