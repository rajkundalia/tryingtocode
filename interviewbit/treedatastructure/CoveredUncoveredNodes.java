package interviewbit.treedatastructure;

import java.util.LinkedList;
import java.util.Queue;

/*
You are given the root of a binary tree A, you need to return the absolute difference
between sum of all covered elements and the sum of all uncovered elements.

In a binary tree, a node is called Uncovered if it appears either on left boundary or right boundary.
Rest of the nodes are called covered.

Problem Constraints
1 <= Number of nodes in the binary tree <= 105

Input Format
The first argument is the root of the binary tree A.

Output Format
Return a single integer denoting the absolute difference of the sum of covered and uncovered nodes.

Example Input
Input 1:
    2
   / \
  1   4
 /   / \
6  10   5
Input 2:
      1
     /
    2
   /
  3


Example Output
Output 1:
8
Output 2:
6

Example Explanation
Explanation 1:
The node with value 10 is the only covered node. All other nodes are uncovered.
Therefore, the absolute difference is |(10) - (2 + 1 + 4 + 6 + 5)| = 8
Explanation 2:
All the given nodes are uncovered. Hence, the answer is sum of given nodes -6.
 */
public class CoveredUncoveredNodes {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);

        root.left = node2;
        node2.left = node3;

        System.out.println(new CoveredUncoveredNodes().coveredNodes(root));
    }

    public Long coveredNodes(TreeNode A) {
        long uncovered = 0;
        long covered = 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(A);

        while (!q.isEmpty()) {
            int l = q.size();
            for (int i = 0; i < l; i++) {
                if (i == 0 || i == l - 1) {
                    uncovered += q.peek().val;
                } else {
                    covered += q.peek().val;
                }
                if (q.peek() != null) {
                    if (q.peek().left != null) {
                        q.add(q.peek().left);
                    }
                    if (q.peek().right != null) {
                        q.add(q.peek().right);
                    }
                }
                q.remove();
            }
        }

        return Math.abs(uncovered - covered);
    }
}
